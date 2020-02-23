package checker.check;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * Test example 2.
 */
public class Example2Test {
    /**
     * Test checker 2.
     */
    @Test
    public void whenGetNumberThenReturnString() {
        Example2 example2 = new Example2();
        String str1 = example2.checkNumber(3);
        String str2 = example2.checkNumber(5);
        String str3 = example2.checkNumber(15);
        String str4 = example2.checkNumber(1111);
        Assert.assertThat(str1, is("Fizz"));
        Assert.assertThat(str2, is("Bizz"));
        Assert.assertThat(str3, is("FizzBizz"));
        Assert.assertThat(str4, is("1111"));
    }
}