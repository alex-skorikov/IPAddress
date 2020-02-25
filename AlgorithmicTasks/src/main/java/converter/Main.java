package converter;

import converter.converters.Converter;
import converter.converters.IReaderWriter;
import converter.converters.ReaderWriterIMPL;
import converter.storages.IStorage;
import converter.storages.MyStorage;
import converter.validators.IValidated;
import converter.validators.MyValidator;

/**
 * Class run application.
 */
public class Main {
    /**
     * Method main.
     * @param args arguments.
     */
    public static void main(String[] args) {
        IReaderWriter readerWriter = new ReaderWriterIMPL();
        IValidated validated = new MyValidator();
        IStorage storage = new MyStorage();
        Converter converter = new Converter(readerWriter, validated, storage);
        converter.convert();
    }
}
