package com.epam.olki.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by olki on 6/2/15.
 */
public class TextLoader {

    public static String readText(){
        try {
            byte[] encoded = Files.readAllBytes(Paths.get("book.txt"));
            return new String(encoded, "UTF-8");
        } catch(UnsupportedEncodingException e) {
            //logger.trace(e);
        } catch(IOException e) {
            //logger.trace(e);
        }
        return null;
    }

    private String readText2(final String path) {
        String text = "";
        try {
            FileInputStream inFile = new FileInputStream(path);
            byte[] str = new byte[inFile.available()];
            inFile.read(str);
            text = new String(str); // String with all text
            // System.out.println(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public static void writeText(String text, String path) {
        text = text.replaceAll("[ ][\n][\n]", "\n\n");
        text = text.substring(0, text.length() - 2);
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(path);
            printWriter.print(text);
        } catch(FileNotFoundException e) {
            //logger.trace(e);
        } finally {
            printWriter.close();
        }
    }
}
