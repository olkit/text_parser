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
        List sortedSentenceList = new ArrayList<Composite>();
        Comparator<Composite> comparator = (Composite x, Composite y) ->
                (x.getSize() < y.getSize()) ? -1 : (x.getSize() > y.getSize()) ? 1 : 0;
        //PriorityQueue priorityQueue = new PriorityQueue(comparator);

        for (Iterator<BaseComponent> paragraphIterator = inputText.getIterator();
             paragraphIterator.hasNext(); ) {

            Composite paragraph = (Composite) paragraphIterator.next();
            for (Iterator<BaseComponent> sentenceIterator = paragraph.getIterator();
                 sentenceIterator.hasNext(); ) {
                Composite sentence = (Composite) sentenceIterator.next();
                logger.trace("Sentence added to List: {}", sentence);
                sortedSentenceList.add(sentence);
            }
        }

        logger.info("List sorted: {}", sortedSentenceList);
        Collections.sort(sortedSentenceList, comparator);
        return sortedSentenceList.toString();
    }


    public static String task5(Composite inputText) {
        logger.info("Task5 Started. Created new List");

        List wordList = new ArrayList<Composite>();
        int firstWord = 0;
        int lastWord = 0;

        for (Iterator<BaseComponent> paragraphIterator = inputText.getIterator();
             paragraphIterator.hasNext(); ) {

            Composite paragraph = (Composite) paragraphIterator.next();
            for (Iterator<BaseComponent> sentenceIterator = paragraph.getIterator();
                 sentenceIterator.hasNext(); ) {

                firstWord = lastWord;
                Composite sentence = (Composite) sentenceIterator.next();
                logger.trace("Swap first and Last words in sentence: {}", sentence);
                for (Iterator<BaseComponent> wordIterator = sentence.getIterator();
                     wordIterator.hasNext(); ) {

                    Composite word = (Composite) wordIterator.next();
                    logger.trace("Added {}: \"{}\" ", lastWord, word);
                    wordList.add(word);
                    lastWord++;
                }
                logger.trace("Swap {} and {} words in sentence", firstWord, lastWord - 1);
                Collections.swap(wordList, firstWord, lastWord - 1);
                logger.trace("Result after swap in sentence: {}", sentence);
            }
        }

        return inputText.toString();
    }
}
