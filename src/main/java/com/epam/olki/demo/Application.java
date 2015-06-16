package com.epam.olki.demo;

import com.epam.olki.entities.Composite;
import com.epam.olki.entities.Leaf;
import com.epam.olki.utils.TextLoader;
import com.epam.olki.utils.TextParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

/**
 * Created by olki on 6/2/15.
 */
public class Application {


    public static void run() {

        Logger logger = LoggerFactory.getLogger(Application.class);
        logger.info("Application Started");

        String path = "src/Text.txt";
        String text = new TextLoader().readText(path);
        TextParser textParser = new TextParser();
        Composite wholeText = textParser.parse(text);

        System.out.println(Tasks.task2(wholeText));
    }
}
