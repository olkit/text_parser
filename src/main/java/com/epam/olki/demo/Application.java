package com.epam.olki.demo;

import com.epam.olki.entities.Composite;
import com.epam.olki.utils.TextLoader;
import com.epam.olki.utils.TextParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {


    public static void run() {

        Logger logger = LoggerFactory.getLogger(Application.class);
        logger.trace("Application Started");
        logger.info(System.getProperty("user.dir"));

        String path = "src/Text.txt";
        logger.trace("Load text from: {}", path);
        String text = TextLoader.readText(path);
        TextParser textParser = new TextParser();
        logger.trace("Parse text from: {}", path);
        Composite wholeText = textParser.parse(text);

        logger.trace("Send text to task2");
        System.out.println(Tasks.task2(wholeText));

        logger.trace("Send text to task5");
        System.out.println(Tasks.task5(wholeText));
    }
}
