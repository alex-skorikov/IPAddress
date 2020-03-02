package twothreads.readerwriter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.File;

/**
 * Reader - writer.
 */
public class ReaderWriter implements ReadableWritable {
    /**
     * File.
     */
    private File file;

    /**
     * Constructor.
     * @param file file.
     */
    public ReaderWriter(File file) {
        this.file = file;
    }

    @Override
    public String read() throws IOException {
        String out = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));) {
            out = reader.readLine();
        }
        return out;
    }

    @Override
    public void write(String writeStr) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false)))) {
            writer.write(writeStr);
        }
    }
}
