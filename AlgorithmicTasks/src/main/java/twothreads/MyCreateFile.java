package twothreads;

import java.io.File;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * My ceate file.
 */
public class MyCreateFile implements CreateFile {

    @Override
    public File createFile() {
        File file = new File("AlgorithmicTasks/src/main/java/twothreads/resources/file.txt");
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)))) {
            writer.write("0");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
