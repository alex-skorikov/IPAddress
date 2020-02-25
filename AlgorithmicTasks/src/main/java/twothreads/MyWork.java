package twothreads;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Work class.
 */
public class MyWork implements Workable, Runnable {
    /**
     * Semathore.
     */
    private Semaphore semaphore;
    /**
     * Reader - writer.
     */
    private ReadableWritable readableWritable;
    /**
     * Work number.
     */
    private AtomicInteger numberCount;

    /**
     * Constructor.
     * @param semaphore semathore for multi threads.
     * @param readableWritable reader - writer.
     * @param nomberCount number.
     */
    public MyWork(Semaphore semaphore, ReadableWritable readableWritable, AtomicInteger nomberCount) {
        this.semaphore = semaphore;
        this.readableWritable = readableWritable;
        this.numberCount = nomberCount;
    }

    @Override
    public void run() {
        try {
            work();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void work() throws InterruptedException {
        while (numberCount.decrementAndGet() >= 0) {
            semaphore.acquire();

            try {
                int number = Integer.parseInt(readableWritable.read());
                System.out.printf("Old %d ", number);
                number++;
                System.out.printf("New %d ", number);
                System.out.printf("Thread %s", Thread.currentThread().getName() + "\n");
                readableWritable.write(String.valueOf(number));

            } catch (Exception e) {
                continue;
            }
            semaphore.release();
        }
    }
}
