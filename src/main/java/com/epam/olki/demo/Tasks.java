package com.epam.olki.demo;

import com.epam.olki.entities.BaseComponent;
import com.epam.olki.entities.Composite;

import java.util.*;

/**
 * Created by olki on 6/2/15.
 */
public class Tasks {

    public static String task1(Composite inputText) {
        return "";
    }

    public static String task2(Composite inputText) {

        List sortedList = new ArrayList<Composite>();
        Comparator<Composite> comparator = (Composite x, Composite y) ->
                (x.getSize() < y.getSize()) ? -1 : (x.getSize() > y.getSize()) ? 1 : 0;

        for (Iterator<BaseComponent> paragraphIterator = inputText.getIterator();
             paragraphIterator.hasNext(); ) {

            Composite paragraph = (Composite) paragraphIterator.next();
            for (Iterator<BaseComponent> sentenceIterator = paragraph.getIterator();
                 sentenceIterator.hasNext(); ) {
                Composite sentence = (Composite) sentenceIterator.next();
                sortedList.add(sentence);
            }
        }

        Collections.sort(sortedList, comparator);

        System.out.println(sortedList.toString());
        return "";
    }

    public static String task3(Composite inputText) {
        //String regex = "[^.]*(круто|класс)[^.]*(\\.|$)";
        //Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        //Matcher m = p.matcher(st);
        //while (m.find())
        return "";
    }

    public static String task4(Composite inputText) {
        return "";
    }

    public static String task5(Composite inputText) {
        return "";
    }

    public static String task6(Composite inputText) {
        return "";
    }
}
