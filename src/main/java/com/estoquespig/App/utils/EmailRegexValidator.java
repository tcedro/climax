package com.estoquespig.App.utils;

import org.apache.commons.validator.routines.EmailValidator;

public class EmailRegexValidator {
    public static boolean validateEmail(String email) {
        return EmailValidator.getInstance().isValid(email);
    }
}
