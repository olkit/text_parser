package com.epam.olki.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by olki on 6/2/15.
 */
public class TextLoader {

    public TextLoader() {
    }

    public static String readText(final String path) {
        String text = "";
        try {
            //byte[] encoded = Files.readAllBytes(Paths.get("book.txt"));
            //return new String(encoded, "UTF-8");
            FileInputStream inFile = new FileInputStream(path);
            byte[] str = new byte[inFile.available()];
            inFile.read(str);
            text = new String(str); // String with all text
            // System.out.println(text);
        } catch(UnsupportedEncodingException e) {
            //logger.trace(e);
        } catch (FileNotFoundException e) {
            //logger.trace(e);
            e.printStackTrace();
        } catch (IOException e) {
            //logger.trace(e);
            e.printStackTrace();
        }
        return text;
    }
}
