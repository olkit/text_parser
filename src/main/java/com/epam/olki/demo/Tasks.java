package com.epam.olki.demo;

import com.epam.olki.entities.BaseComponent;
import com.epam.olki.entities.Composite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Tasks {

    private static Logger logger = LoggerFactory.getLogger(Tasks.class);

    public static String task2(Composite inputText) {

        logger.info("Task2 Started. Created new List");
        List sortedList = new ArrayList<Composite>();
        Comparator<Composite> comparator = (Composite x, Composite y) ->
                (x.getSize() < y.getSize()) ? -1 : (x.getSize() > y.getSize()) ? 1 : 0;

        for (Iterator<BaseComponent> paragraphIterator = inputText.getIterator();
             paragraphIterator.hasNext(); ) {

            Composite paragraph = (Composite) paragraphIterator.next();
            for (Iterator<BaseComponent> sentenceIterator = paragraph.getIterator();
                 sentenceIterator.hasNext(); ) {
                Composite sentence = (Composite) sentenceIterator.next();
                logger.trace("Sentence added to List: {0}", sentence);
                sortedList.add(sentence);
            }
        }

        logger.info("List sorted: {0}", sortedList);
        Collections.sort(sortedList, comparator);
        return sortedList.toString();
    }
}
