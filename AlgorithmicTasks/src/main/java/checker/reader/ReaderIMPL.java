package checker.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class Reader IMPL.
 */
public class ReaderIMPL implements Reader {
    /**
     * BufferedReader.
     */
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String readLine() {
        String input = "";
        try {
            input =  reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    @Override
    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
