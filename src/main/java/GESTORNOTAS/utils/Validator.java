package utils;

public class Validator {

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email != null && email.matches(emailRegex);
    }

    public static boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
        return password != null && password.matches(passwordRegex);
    }

    public static boolean isStringEmpty(String text) {
        return text == null || text.trim().isEmpty();
    }

    public static boolean validateRegistration(String user, String pass, String passRep) {
        if (isStringEmpty(user) || isStringEmpty(pass)) {
            return false;
        }
        if (!pass.equals(passRep)) {
            return false;
        }
        return true;
    }

    public static boolean validateNote(String titulo) {
        return !isStringEmpty(titulo);
    }
}