package checker;

import checker.check.Checker;
import checker.reader.Reader;
import checker.writer.Writer;

/**
 * Class start select checker.
 */
public class StartExample {
    /**
     * Checker.
     */
    private Checker checker;
    /**
     * Reader.
     */
    private Reader reader;
    /**
     * Writer.
     */
    private Writer writer;

    /**
     * Constructor.
     *
     * @param checker checker.
     * @param reader  reader.
     * @param writer  writer.
     */
    public StartExample(Checker checker, Reader reader, Writer writer) {
        this.checker = checker;
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Method run checker.
     *
     */
    public void start() {
        while (true) {
            writer.println("For exit enter : exit");
            writer.print("Enter number : ");
            String str = reader.readLine();
            if (str.equals("exit")) {
                break;
            }
            try {
                int num = Integer.parseInt(str);
                if (num <= 0) {
                    throw new ArithmeticException();
                }
                writer.println(checker.checkNumber(num));
            } catch (ArithmeticException e) {
                writer.println("Number must be > 0");
            } catch (NumberFormatException e) {
                writer.println("Not correct data");
            }
        }
        reader.close();
    }
}
