package checker.check;

import checker.writer.Writer;

/**
 * Example 1.
 */
public class Example1 implements Checker {
    /**
     * Console writer.
     */
    private Writer writer;

    /**
     * Constructor.
     *
     * @param writer writer.
     */
    public Example1(Writer writer) {
        this.writer = writer;
    }

    @Override
    public String checkNumber(Integer number) {
        StringBuilder builder = new StringBuilder();
        if (number % 3 == 0) {
            builder.append("Fizz");
        }
        if (number % 5 == 0) {
            builder.append("Buzz");
        }
        if (builder.length() == 0) {
            builder.append(number);
        }
        return builder.toString();
    }

    @Override
    public void printRezult(Integer enterNum) {
        for (int check = 1; check <= enterNum; check++) {
            writer.println(checkNumber(check));
        }
    }
}
