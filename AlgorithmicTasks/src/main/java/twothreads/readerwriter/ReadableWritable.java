package twothreads.readerwriter;

import java.io.IOException;

/**
 * Interface read-write.
 */
public interface ReadableWritable {
    /**
     * Read data.
     * @return String/
     * @throws IOException exception.
     */
    String read() throws IOException;

    /**
     * Write string.
     * @param str string.
     * @throws IOException exception.
     */
    void write(String str) throws IOException;
}
