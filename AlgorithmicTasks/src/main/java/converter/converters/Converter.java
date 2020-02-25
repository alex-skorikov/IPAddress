package converter.converters;

import converter.storages.IStorage;
import converter.validators.IValidated;

/**
 * Class Converter.
 */
public class Converter {
    /**
     * Reader - writer.
     */
    private IReaderWriter readerWriter;
    /**
     * Data validator.
     */
    private IValidated validated;
    /**
     * Formula storage.
     */
    private IStorage storage;

    /**
     * Constructor.
     *
     * @param readerWriter reader-writer.
     * @param validated    validator.
     * @param storage      starage.
     */
    public Converter(IReaderWriter readerWriter, IValidated validated, IStorage storage) {
        this.readerWriter = readerWriter;
        this.validated = validated;
        this.storage = storage;
    }

    /**
     * Start method.
     */
    public void convert() {
        while (true) {
            readerWriter.writeData("For exit enter exit.");
            readerWriter.writeData("Enter data : ");
            String str = readerWriter.readData();
            if (str.equals("exit")) {
                break;
            }
            if (validated.validInput(str)) {
                storage.saveData(str);
                readerWriter.writeData("Formula added");
            } else if (validated.validOutput(str)) {
                readerWriter.writeData(storage.getData(str));
            } else {
                readerWriter.writeData("Not correct data.");
            }
        }
    }
}
