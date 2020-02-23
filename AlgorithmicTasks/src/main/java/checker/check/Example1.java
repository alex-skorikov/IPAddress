package checker.check;

/**
 * Example 1.
 */
public class Example1 implements Checker {

    @Override
    public String checkNumber(Integer number) {
        StringBuilder builder = new StringBuilder();
        if (number % 3 == 0) {
            builder.append("Fizz");
        }
        if (number % 5 == 0) {
            builder.append("Bizz");
        }
        if (builder.length() == 0) {
            builder.append(number);
        }
        return builder.toString();
    }
}
