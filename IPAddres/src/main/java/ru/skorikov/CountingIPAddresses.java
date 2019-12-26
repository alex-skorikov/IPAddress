package ru.skorikov;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class counting.
 */
public class CountingIPAddresses {
    /**
     * File addresses.
     */
    private File file;
    /**
     * Array for unique ip.
     */
    private boolean[][][][] ipArray = new boolean[256][256][256][256];

    /**
     * Construtor.
     * @param path path to file.
     */
    public CountingIPAddresses(String path) {
        this.file = new File(path);
    }

    /**
     * Counting ip addresses.
     * @return count.
     * @throws IOException exception.
     */
    public Long counting() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String str;
        long ipCount = 0;
        while ((str = reader.readLine()) != null) {
            String[] parts = str.split("\\.");
            if (validateIP(parts)) {
                int indexArray0 = Integer.parseInt(parts[0]);
                int indexArray1 = Integer.parseInt(parts[1]);
                int indexArray2 = Integer.parseInt(parts[2]);
                int indexArray3 = Integer.parseInt(parts[3]);
                if (!ipArray[indexArray0][indexArray1][indexArray2][indexArray3]) {
                    ipArray[indexArray0][indexArray1][indexArray2][indexArray3] = true;
                    ipCount++;
                }
            }
        }
        reader.close();
        return ipCount;
    }

    /**
     * Validate address.
     * @param ip ip address.
     * @return isValid.
     */
    private boolean validateIP(String[] ip) {
        boolean isValid = true;
        try {
            if (ip.length != 4) {
                isValid = false;
            } else {
                for (String s : ip) {
                    int i = Integer.parseInt(s);
                    if ((i < 0) || (i > 255)) {
                        isValid = false;
                    }
                }
            }
        } catch (NumberFormatException e) {
            isValid = false;
        }
        return isValid;
    }
}
