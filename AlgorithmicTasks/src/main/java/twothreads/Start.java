package twothreads;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * My start.
 */
public class Start  implements Startable {
    /**
     * Work number.
     */
    private AtomicInteger numberWork;
    /**
     * Create file.
     */
    private CreateFile createFile;
    /**
     * File.
     */
    private File file;
    /**
     * Reader-writer.
     */
    private ReadableWritable readableWritable;
    /**
     * Work.
     */
    private Workable workable;
    /**
     * Thread 1.
     */
    private Thread thread;
    /**
     * Thread 2.
     */
    private Thread thread2;

    /**
     * Start work.
     * @param i work number.
     *
     */
    public Start(int i) {
        this.numberWork = new AtomicInteger(i);
        createFile = new MyCreateFile();
        file = createFile.createFile();
        readableWritable = new ReaderWriter(file);
        workable = new MyWork(new Semaphore(1), readableWritable, numberWork);
        thread = new Thread(workable);
        thread2 = new Thread(workable);
    }

    @Override
    public void startApplication() throws InterruptedException {
        thread.setName("ONE");
        thread2.setName("TWO");
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        try {
            System.out.printf("File conteins %s", readableWritable.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
