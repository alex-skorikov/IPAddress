package converter.converters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * My reader- writer.
 */
public class ReaderWriterIMPL implements IReaderWriter {
    /**
     * Data erader.
     */
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String readData() {
        String out = "";
        try {
            out = reader.readLine();
        } catch (IOException e) {
            System.out.println("Can't read from Input stream ");
            e.printStackTrace();
        }
        return out;
    }

    @Override
    public void writeData(String str) {
        System.out.println(str);
    }

}
