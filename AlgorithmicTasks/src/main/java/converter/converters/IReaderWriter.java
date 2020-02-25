package converter.converters;

/**
 * Interface for read and write.
 */
public interface IReaderWriter {
    /**
     * Read data.
     *
     * @return string data.
     */
    String readData();

    /**
     * Write data.
     *
     * @param str string.
     */
    void writeData(String str);
}
