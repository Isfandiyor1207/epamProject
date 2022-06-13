package epam.project.bookshop.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.regex.Pattern;

import static epam.project.bookshop.command.ParameterName.*;
import static epam.project.bookshop.validation.ValidationParameterName.*;

public class RegistrationValidation {

    Logger logger= LogManager.getLogger();

    private static final String EMAIL_REGEX = "^(.+)@(.+)$";
    private static final String PASSWORD_REGEX = "((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{6,20})";
    private static final String PHONE_NUMBER_REGEX = "^(\\+\\d{12})$";
    private static final RegistrationValidation INSTANCE=new RegistrationValidation();

    public static RegistrationValidation getInstance() {
        return INSTANCE;
    }

    public boolean checkEmailValidation(String email) {
        return email != null && !email.isEmpty() && email.matches(EMAIL_REGEX);
    }

    public boolean checkPasswordToValidation(String password) {
        return password != null && !password.isEmpty() && password.matches(PASSWORD_REGEX);
    }

    public boolean checkPhoneNumberToValidation(String phoneNumber) {
        return phoneNumber != null && !phoneNumber.isEmpty() && phoneNumber.matches(PHONE_NUMBER_REGEX);
    }

    public boolean userRegistrationValidation(Map<String, String> user) {
        boolean isValid = true;
        if (!checkEmailValidation(user.get(EMAIL))) {
            user.put(WORN_EMAIL, ERROR_EMAIL_MSG);
            isValid = false;
        }
        if (!checkPasswordToValidation(user.get(PASSWORD))) {
            user.put(WORN_PASSWORD, ERROR_PASSWORD_MSG);
            isValid = false;
        }
        if (!checkPhoneNumberToValidation(user.get(PHONE_NUMBER))) {
            user.put(WORN_PHONE_NUMBER, ERROR_PHONE_NUMBER_MSG);
            isValid = false;
        }
        return isValid;
    }

}