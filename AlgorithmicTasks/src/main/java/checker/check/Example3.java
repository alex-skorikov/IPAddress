package checker.check;

import checker.writer.Writer;

/**
 * Example 3.
 */
public class Example3 implements Checker {
    /**
     * Console writer.
     */
    private Writer writer;

    /**
     * Constructor.
     *
     * @param writer writer.
     */
    public Example3(Writer writer) {
        this.writer = writer;
    }

    @Override
    public String checkNumber(Integer number) {
        String str = number.toString();

        String[] words = new String[]{"FizzBuzz", "Buzz", "Fizz"};
        int index = Math.min(number % 3, 1) + Math.min(number % 5, 1) * 2;
        if (index < words.length) {
            str = words[index];
        }
        return str;
    }

    @Override
    public void printRezult(Integer integer) {
        for (int check = 1; check <= integer; check++) {
            writer.println(checkNumber(check));
        }
    }
}
