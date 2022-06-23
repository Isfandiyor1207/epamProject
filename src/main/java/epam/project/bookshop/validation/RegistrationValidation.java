package epam.project.bookshop.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

import static epam.project.bookshop.command.ParameterName.*;
import static epam.project.bookshop.validation.ValidationParameterName.*;

public class RegistrationValidation {

    Logger logger = LogManager.getLogger();

    private static final String EMAIL_REGEX = "^(.+)@(.+)$";
    private static final String PASSWORD_REGEX = "((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{6,20})";
    private static final String PHONE_NUMBER_REGEX = "^(\\+\\d{12})$";
    private static final BaseValidation baseValidation = BaseValidation.getInstance();
    private static final RegistrationValidation INSTANCE = new RegistrationValidation();

    public static RegistrationValidation getInstance() {
        return INSTANCE;
    }

    public boolean checkEmailValidation(String email) {
        return !baseValidation.isEmpty(email) && email.matches(EMAIL_REGEX);
    }

    public boolean checkPasswordToValidation(String password) {
        return !baseValidation.isEmpty(password) && password.matches(PASSWORD_REGEX);
    }

    public boolean checkPhoneNumberToValidation(String phoneNumber) {
        return !baseValidation.isEmpty(phoneNumber) && phoneNumber.matches(PHONE_NUMBER_REGEX);
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

    public boolean checkUpdateUser(Map<String, String> user, Map<String, String> query) {
        boolean isValid = true;
        logger.info("user update validation:" + user.toString());

        logger.info(user.get(FIRSTNAME));
        logger.info(user.get(LASTNAME));
        logger.info(user.get(USERNAME));

        if (!baseValidation.isEmpty(user.get(FIRSTNAME))) {
            logger.info("User firstname is written to update: " + user.get(FIRSTNAME));
            query.put(FIRSTNAME, user.get(FIRSTNAME));
        }

        if (!baseValidation.isEmpty(user.get(LASTNAME))) {
            logger.info("User lastname is written to update: " + user.get(LASTNAME));
            query.put(LASTNAME, user.get(LASTNAME));
        }

        if (!baseValidation.isEmpty(user.get(USERNAME))) {
            logger.info("User username is written to update: " + user.get(USERNAME));
            query.put(USERNAME, user.get(USERNAME));
        }

        // todo check to regex if the information is not valid to regex warn error should be written to console

        if (checkPasswordToValidation(user.get(PASSWORD))) {
            logger.info("User password is written to update: " + user.get(PASSWORD));
            query.put(PASSWORD, user.get(PASSWORD));
        } else {
            logger.info("User password is not valid: " + user.get(PASSWORD));
            user.put(WORN_PASSWORD, ERROR_PASSWORD_MSG);
            isValid = false;
        }

        if (checkEmailValidation(user.get(EMAIL))) {
            logger.info("User email is written to update: " + user.get(EMAIL));
            query.put(EMAIL, user.get(EMAIL));
        } else {
            logger.info("User email is not valid: " + user.get(EMAIL));
            user.put(WORN_EMAIL, ERROR_EMAIL_MSG);
            isValid = false;
        }


        if (checkPhoneNumberToValidation(user.get(PHONE_NUMBER))) {
            logger.info("user phone number is written to update:  " + user.get(PHONE_NUMBER));
            query.put(USER_PHONE_NUMBER_IN_DB, user.get(PHONE_NUMBER));
        } else {
            logger.info("user phone number is not valid:" + user.get(PHONE_NUMBER));
            user.put(WORN_PHONE_NUMBER, ERROR_PHONE_NUMBER_MSG);
            isValid = false;
        }

        return isValid;
    }

}