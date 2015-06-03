package com.epam.olki.demo;

import com.epam.olki.entities.Composite;
import com.epam.olki.utils.TextParser;

/**
 * Created by olki on 6/2/15.
 */
public class Application {


    public static void run() {
        String path = "src/Text.txt";
        TextParser textParser = new TextParser();
        Composite wholeText = textParser.parse(path);
    }
}
