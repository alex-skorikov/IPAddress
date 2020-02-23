package checker.check;

/**
 * Example 2.
 */
public class Example2 implements Checker {

    @Override
    public String checkNumber(Integer number) {
        String out = String.valueOf(number);
        if ((number % 3 == 0) && (number % 5 == 0)) {
            out = "FizzBizz";
        } else if (number % 3 == 0) {
            out = "Fizz";
        } else if (number % 5 == 0) {
            out = "Bizz";
        }
        return out;
    }
}
