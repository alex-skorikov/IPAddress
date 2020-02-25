package converter.storages;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * Test myStorage class.
 */
public class MyStorageTest {
    /**
     * Storage for test.
     */
    private MyStorage storage = new MyStorage();

    /**
     * Test starage save and get data.
     */
    @Test
    public void saveData() {

        String str = "1024 byte = 1 kilobyte";
        String str2 = "2 bar = 12 ring";
        String str3 = "4 hare = 1 cat";
        String str4 = "5 cat = 0.5 giraffe";
        String str5 = "1 byte = 8 bit";
        String str6 = "15 ring = 2.5 bar";
        String str7 = "16.8 ring = 2 pyramid";

        storage.saveData(str);
        storage.saveData(str2);
        storage.saveData(str3);
        storage.saveData(str4);
        storage.saveData(str5);
        storage.saveData(str6);
        storage.saveData(str7);

        String test1 = "1 pyramid = ? bar";
        String test2 = "1 giraffe = ? hare";
        String test3 = "0.5 byte = ? cat";
        String test4 = "2 kilobyte = ? bit";

        String out1 = "1 pyramid = 1.4 bar";
        String out2 = "1 giraffe = 40 hare";
        String out3 = "Conversion not possible.";
        String out4 = "2 kilobyte = 16384 bit";

        Assert.assertThat(out1, is(storage.getData(test1)));
        Assert.assertThat(out2, is(storage.getData(test2)));
        Assert.assertThat(out3, is(storage.getData(test3)));
        Assert.assertThat(out4, is(storage.getData(test4)));

    }
}

