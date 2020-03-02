package twothreads;

import checker.reader.Reader;
import checker.reader.ReaderIMPL;
import checker.writer.Writer;
import checker.writer.WriterIMPL;
import twothreads.logic.Start;

/**
 * Start application.
 */
public class Main {
    /**
     * Main method.
     * @param args string[] arguments.
     */
    public static void main(String[] args) {
        Reader reader = new ReaderIMPL();
        Writer writer = new WriterIMPL();

        while (true) {
            writer.println("For exit enter : exit");
            writer.println("Enter number : ");
            String str = reader.readLine();
            if (str.equals("exit")) {
                break;
            }
            try {
                int num = Integer.parseInt(str);
                if (num % 2 != 0) {
                    throw new ArithmeticException();
                }
                Start start = new Start(num);
                try {
                    start.startApplication();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (ArithmeticException e) {
                writer.println("Number must be aliquot 2");
            } catch (NumberFormatException e) {
                writer.println("Not correct data");
            }
        }
        reader.close();
    }
}
