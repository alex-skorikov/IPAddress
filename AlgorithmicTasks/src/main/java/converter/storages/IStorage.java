package converter.storages;

/**
 * Interface storage.
 */
public interface IStorage {
    /**
     * Save data to storage.
     * @param str string.
     */
    void saveData(String str);

    /**
     * Get data from storage.
     * @param str string.
     * @return rezult.
     */
    String getData(String str);
}
