package com.epam.olki.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextLoader {

    public TextLoader() {
    }

    public static String readText(final String path) {

        Logger logger = LoggerFactory.getLogger(TextLoader.class);

        String text = "";
        try {

            /* #1 implementation
            InputStream loader = ClassLoader.getSystemResourceAsStream(path);
            InputStreamReader is = new InputStreamReader(loader, "UTF-8");
            BufferedReader reader = new BufferedReader(is);
            StringBuilder sb = new StringBuilder();
            while (reader.readLine() != null) {
                sb.append(reader.readLine()).append("\n");
            }
            reader.close();
            sb.trimToSize();
            text = String.valueOf(sb);
            */

            /* #2 implementation
            byte[] encoded = Files.readAllBytes(Paths.get(path));
            return new String(encoded, "UTF-8");
            */

            /* #3 implementation*/
            FileInputStream inFile = new FileInputStream(path);
            byte[] str = new byte[inFile.available()];
            text = new String(str); // String with all text

        } catch(UnsupportedEncodingException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            logger.info("Text loaded: {0}", text);
        }
        return text;
    }
}
