package com.v2.artesa.Utils;

import java.util.regex.Pattern;

/**
 * Created by CaioSChristino on 27/12/16.
 */

public class TextUtil {

    private static final String EMAIL_ADDRESS = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
            "\\@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
            "(" +
            "\\." +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
            ")+";

    private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_ADDRESS);
        return pattern.matcher(email).matches();
    }

    /**
     * Validate username with regular expression
     *
     * @param password username for validation
     * @return true valid username, false invalid username
     */
    public static boolean validatePassword(final String password) {
        Pattern pattern = Pattern.compile(USERNAME_PATTERN);
        return pattern.matcher(password).matches();
    }
}
