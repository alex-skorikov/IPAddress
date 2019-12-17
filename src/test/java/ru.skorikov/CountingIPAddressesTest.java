package ru.skorikov;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;


/**
 * Class test.
 */
public class CountingIPAddressesTest {
    /**
     * @throws IOException exception.
     */
    @Test
    public void counting() throws IOException {
        String path = "src/test/resources/testFile.txt";
        CountingIPAddresses countingIPAddresses = new CountingIPAddresses(path);
        Long num = countingIPAddresses.counting();
        Assert.assertThat((long) 4, is(num));

    }
}