package com.epam.olki.utils;

import com.epam.olki.entities.Composite;
import com.epam.olki.entities.Leaf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {

    private Logger logger = LoggerFactory.getLogger(TextParser.class);
    public static final String REGEX_LISTING = "\\s*(Start listing)([^\\t]+)(End listing)";
    public static final String REGEX_PARAGRAPH_WITH_LISTING = "((?:[^\\n][\\n]?)+)";
    //public static final String REGEX_PARAGRAPH_WITH_LISTING = "(\\s*(.+))([^(\\s*(Start listing)([^\\t]+)(End listing)\\s)])|\\s*(Start listing)([^\\t]+)(End listing)";
    public static final String REGEX_PARAGRAPH_WITHOUT_LISTING = "\\t(.+))([^((Start listing)([^\\t]+)(End listing))]";
    public static final String REGEX_SENTENCE = "([^(\\.|!|\\?)]+)(\\.|!|\\?)";
    public static final String REGEX_WORD = "([^(\\s)]*)(\\s)*";
    public static final String REGEX_SYMBOL = ".{1}";
    public static final String REGEX_WORD_AND_SIGN = "([\\.,!\\?:;@]{1})|([^\\.,!\\?:;@]*)";
    public static final String REGEX_EMPTY = ".]*";

    public TextParser() {
    }

    public Composite parse(String text) {
        Composite wholeText = new Composite();
        parseToParagraph(wholeText, text);
        return wholeText;
    }

    private void parseToParagraph(Composite wholeText, String text) {
        // parse to paragraph
        Composite paragraphList;
        Pattern patternParagraph = Pattern
                .compile(REGEX_PARAGRAPH_WITH_LISTING);
        Leaf paragraphLeaf;
        String paragraph;
        Matcher matcher = patternParagraph.matcher(text);
        while (matcher.find()) {
            paragraphList = new Composite();
            paragraph = matcher.group();
            logger.info("Paragraph is - {}", paragraph);
            if (Pattern.matches(REGEX_LISTING, paragraph)) {
                paragraphLeaf = new Leaf(paragraph);
                paragraphList.addElement(paragraphLeaf);
            } else {
                parseToSentence(paragraphList, paragraph);
            }
            wholeText.addElement(paragraphList);
        }
    }

    private void parseToSentence(Composite paragraphList,
                                          String paragraph) {
        // parse to sentence
        Pattern patternSentence = Pattern.compile(REGEX_SENTENCE);
                Matcher matcher = patternSentence.matcher(paragraph);
        String sentence;

        Composite sentenceList;
        while (matcher.find()) {
            sentenceList = new Composite();
            sentence = matcher.group();
            logger.info("Sentence is - {}", sentence);
            parseToWord(sentenceList, sentence);
            paragraphList.addElement(sentenceList);
        }
    }

    private void parseToWord(Composite sentenceList,
                                      String sentence) {
        // parse to word
        Pattern patternWord = Pattern.compile(REGEX_WORD);
        String word;
        Matcher matcher = patternWord.matcher(sentence);
        Composite wordList;
        while (matcher.find()) {
            wordList = new Composite();
            word = matcher.group();
            logger.info("Word is - {}", word);
            parseToSymbol(wordList, word);
            sentenceList.addElement(wordList);
        }
    }

    private void parseToSymbol(Composite wordList,
                                        String wordSign) {
        // parse to symbol
        Pattern pattern = Pattern.compile(REGEX_SYMBOL);
        String symbol;
        Matcher matcher = pattern.matcher(wordSign);
        Leaf symbolLeaf;
        while (matcher.find()) {
            symbol = matcher.group();
            symbolLeaf = new Leaf(symbol);
            wordList.addElement(symbolLeaf);
        }
    }
}
