package epam.project.bookshop.validation;

import java.util.regex.Pattern;

public class RegistrationValidation {

    private static final String EMAIL_REGEX = "^(.+)@(.+)$";
    private static final String PASSWORD_REGEX = "((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20})";
    private static final String PHONE_NUMBER_REGEX="^(\\+\\d{3}[- .]?){2}\\\\d{4}$";

    public boolean checkEmailValidation(String email) {
        Pattern pattern= Pattern.compile(EMAIL_REGEX);
        return pattern.matcher(email).matches();
    }

    public boolean checkPasswordToValidation(String password){
        return Pattern.compile(PASSWORD_REGEX).matcher(password).matches();
    }

    public boolean checkPhoneNumberToValidation(String phoneNumber){
        return Pattern.compile(PASSWORD_REGEX).matcher(phoneNumber).matches();
    }
}
