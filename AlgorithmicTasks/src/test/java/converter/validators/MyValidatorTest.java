package converter.validators;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * Test my validator.
 */
public class MyValidatorTest {
    /**
     * My validator.
     */
    private MyValidator validator = new MyValidator();

    /**
     * Test data valid for input.
     */
    @Test
    public void validInput() {
        String str1 = "1024 byte = 1 kilobyte";
        String str2 = "2 bar = 12 ring";
        String str3 = "16.8 ring = 2 pyramid";
        String str4 = "4 hare = 1 cat";
        String str5 = "1 pyramid = ? bar";

        Assert.assertThat(validator.validInput(str1), is(true));
        Assert.assertThat(validator.validInput(str2), is(true));
        Assert.assertThat(validator.validInput(str3), is(true));
        Assert.assertThat(validator.validInput(str4), is(true));
        Assert.assertThat(validator.validInput(str5), is(false));
    }

    /**
     * Test valid data for output.
     */
    @Test
    public void validOutput() {
        String str1 = "1024 byte = ? kilobyte";
        String str2 = "2 bar = ? ring";
        String str3 = "16.8 ring = ? pyramid";
        String str4 = "4 hare = ? cat";
        String str5 = "1 pyramid = 4 bar";

        Assert.assertThat(validator.validOutput(str1), is(true));
        Assert.assertThat(validator.validOutput(str2), is(true));
        Assert.assertThat(validator.validOutput(str3), is(true));
        Assert.assertThat(validator.validOutput(str4), is(true));
        Assert.assertThat(validator.validOutput(str5), is(false));
    }
}