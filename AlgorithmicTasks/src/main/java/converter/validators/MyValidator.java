package converter.validators;

/**
 * My validator.
 */
public class MyValidator implements IValidated {
    @Override
    public boolean validInput(String str) {
        String regex = "[0-9]*[.,]?[0-9]*[' ']\\D*[\\=][\\' '][0-9]*[.,]?[0-9]*[\\' ']\\D*";
        return str.matches(regex);

    }

    @Override
    public boolean validOutput(String str) {
        String regex = "[0-9]*[.,]?[0-9]*[' ']\\D*[\\=][\\' '][\\?][\\' ']\\D*";
        return str.matches(regex);
    }
}
