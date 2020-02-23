package checker.writer;

/**
 * Class writer.
 */
public class WriterIMPL implements Writer {
    @Override
    public void println(String line) {
        System.out.println(line);
    }

    @Override
    public void print(String line) {
        System.out.print(line);
    }
}
