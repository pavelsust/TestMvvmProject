package com.fun.testmvvmproject.utils;

import android.widget.EditText;

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
}
