package checker.check;

import checker.writer.Writer;
import checker.writer.WriterIMPL;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

/**
 * Test Example 1.
 */
public class Example1Test {
    /**
     * Test checker 1.
     */
    @Test
    public void whenGetNumberThenReturnString() {
        Writer writer = new WriterIMPL();
        Example1 example1 = new Example1(writer);
        String str1 = example1.checkNumber(3);
        String str2 = example1.checkNumber(5);
        String str3 = example1.checkNumber(15);
        String str4 = example1.checkNumber(1111);
        Assert.assertThat(str1, is("Fizz"));
        Assert.assertThat(str2, is("Buzz"));
        Assert.assertThat(str3, is("FizzBuzz"));
        Assert.assertThat(str4, is("1111"));
    }

}