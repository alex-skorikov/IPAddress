package converter.validators;

/**
 * Data validation interface.
 */
public interface IValidated {
    /**
     * Validation input.
     * @param str input.
     * @return is string valid for input.
     */
    boolean validInput(String str);

    /**
     * Validation for output.
     * @param str intup,
     * @return is string valid for output.
     */
    boolean validOutput(String str);
}
