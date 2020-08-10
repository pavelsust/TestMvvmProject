package com.fun.testmvvmproject.utils;

import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppUtils {

    public static boolean isValidText(EditText e, String message) {
        boolean ret = false;
        if (e.getText().toString().trim().length() > 0) {
            e.setError(null);
            ret = true;
        } else {
            e.setError(message);
        }
        return ret;
    }

    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
