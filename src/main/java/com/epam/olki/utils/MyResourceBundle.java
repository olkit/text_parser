package com.epam.olki.utils;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by olki on 6/2/15.
 */
public class MyResourceBundle {

    private static ResourceBundle resourceBundle;

    static {
        Locale locale = Locale.getDefault();
        resourceBundle = ResourceBundle.getBundle("regexp", locale);
    }

    public static String getRegExp(String key) {

        return resourceBundle.getString(key);
    }

}
