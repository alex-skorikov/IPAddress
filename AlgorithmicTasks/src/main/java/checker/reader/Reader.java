package checker.reader;

/**
 * Reader.
 */
public interface Reader {
    /**
     * Read line.
     *
     * @return line.
     */
    String readLine();

    /**
     * Close reader.
     */
    void close();
}
