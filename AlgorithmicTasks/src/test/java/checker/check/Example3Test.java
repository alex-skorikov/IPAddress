package checker.check;

import checker.writer.Writer;
import checker.writer.WriterIMPL;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * Example3 test.
 */
public class Example3Test {

    /**
     * Test checker 2.
     */
    @Test
    public void whenGetNumberThenReturnString() {
        Writer writer = new WriterIMPL();

        Example3 example3 = new Example3(writer);
        String str1 = example3.checkNumber(3);
        String str2 = example3.checkNumber(5);
        String str3 = example3.checkNumber(15);
        String str4 = example3.checkNumber(1111);
        Assert.assertThat(str1, is("Fizz"));
        Assert.assertThat(str2, is("Buzz"));
        Assert.assertThat(str3, is("FizzBuzz"));
        Assert.assertThat(str4, is("1111"));
    }

}