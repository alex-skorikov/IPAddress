package checker;

import checker.check.Checker;
import checker.check.Example1;
import checker.reader.Reader;
import checker.reader.ReaderIMPL;
import checker.writer.Writer;
import checker.writer.WriterIMPL;

/**
 * Class run application.
 */
public class StartApplication {
    /**
     * Method main.
     * @param args string array.
     */
    public static void main(String[] args) {
        Writer writer = new WriterIMPL();
        Reader reader = new ReaderIMPL();
        Checker checker = new Example1();
        StartExample startExample = new StartExample(checker, reader, writer);
        startExample.start();

    }

}
