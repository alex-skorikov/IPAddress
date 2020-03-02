package checker.check;

import checker.writer.Writer;

/**
 * Example 2.
 */
public class Example2 implements Checker {
    /**
     * Console writer.
     */
    private Writer writer;

    /**
     * Constructor.
     *
     * @param writer writer.
     */
    public Example2(Writer writer) {
        this.writer = writer;
    }

    @Override
    public String checkNumber(Integer number) {
        String out = String.valueOf(number);
        if ((number % 3 == 0) && (number % 5 == 0)) {
            out = "FizzBuzz";
        } else if (number % 3 == 0) {
            out = "Fizz";
        } else if (number % 5 == 0) {
            out = "Buzz";
        }
        return out;
    }

    @Override
    public void printRezult(Integer integer) {
        for (int check = 1; check <= integer; check++) {
            writer.println(checkNumber(check));
        }
    }
}
