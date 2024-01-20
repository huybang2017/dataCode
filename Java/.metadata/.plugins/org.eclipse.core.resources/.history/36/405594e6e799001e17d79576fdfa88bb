package handleMaganement.HandleValidation;

public class ValidationUtils {

    public static boolean isPositiveInteger(String value) {
        try {
            int intValue = Integer.parseInt(value);
            return intValue > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean isValidAddress(String address) {
        return !isNullOrEmpty(address);
    }

    public static boolean isNumeric(String value) {
        return value.matches("\\d+");
    }

    public static boolean isAlphabetic(String value) {
        return value.matches("[a-zA-Z]+");
    }
}
