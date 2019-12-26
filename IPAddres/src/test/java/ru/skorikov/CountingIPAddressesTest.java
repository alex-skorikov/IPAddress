package ru.skorikov;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Ignore;

import java.io.IOException;


/**
 * Class test.
 */
public class CountingIPAddressesTest {
    /**
     * @throws IOException exception.
     */
    @Ignore
    public void counting() throws IOException {
        String path = "src/test/resources/testFile.txt";
        CountingIPAddresses countingIPAddresses = new CountingIPAddresses(path);
        Long num = countingIPAddresses.counting();
        Assert.assertThat((long) 4, Is.is(num));

    }
}