/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.epam.mvc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import ua.kpi.epam.utils.EmptyWordException;
import ua.kpi.epam.utils.LanguageUnit;
import ua.kpi.epam.utils.NonTextPart;
import ua.kpi.epam.utils.Punctuation;
import ua.kpi.epam.utils.PunctuationTypes;
import ua.kpi.epam.utils.Sentence;
import ua.kpi.epam.utils.Word;

/**
 * Class Text is model of MVC pattern
 * @author Dima
 */
public class Text {

    private List<LanguageUnit> sentences;

    /**
     * Constructor of Text from list of sentences
     * @param sentences List of sentences
     */
    public Text(List<LanguageUnit> sentences) {
        this.sentences = sentences;
    }

    /**
     * Constructor of Text class from file with filename
     * @param filemane 
     */
    public Text(String filename) {
        //TODO: Load and parse text file
        // начало угловая скобка, ключевое слово, конец - угловая скобка
        // проверка кратности угловых скобок 
        sentences = new LinkedList<>();
        try (InputStream in = new FileInputStream(filename)) {
            Scanner s = new Scanner(in);
            while (s.hasNextLine()) {
                sentences.addAll(parseString(s.nextLine()));
            }
            //s.nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Default Text test constructor
     */
    public Text() {
        sentences = new LinkedList();
        List<LanguageUnit> elements = new LinkedList();
        try {
            elements.add(new Word("Привет"));
            elements.add(new Punctuation(PunctuationTypes.COMMA));
            elements.add(new Punctuation(PunctuationTypes.WHITESPACE));
            elements.add(new Word("арбуз"));
            elements.add(new Punctuation(PunctuationTypes.WHITESPACE));
            elements.add(new Word("голубь"));
            elements.add(new Punctuation(PunctuationTypes.WHITESPACE));
            elements.add(new Word("Игорь"));
            elements.add(new Punctuation(PunctuationTypes.WHITESPACE));
            elements.add(new Word("омар"));
            elements.add(new Punctuation(PunctuationTypes.WHITESPACE));
            elements.add(new Word("я"));
            elements.add(new Punctuation(PunctuationTypes.WHITESPACE));
            elements.add(new Word("а"));
            elements.add(new Punctuation(PunctuationTypes.DOT));
        } catch (EmptyWordException e) {
            e.printStackTrace();
        }
        sentences.add(new Sentence(elements));
    }

    /**
     * Returns all words in text
     * @return List<Word> - all words
     */
    public List<Word> getWords() {
        List<Word> words = new LinkedList();
        for (LanguageUnit sen : sentences) {
            if (sen instanceof Sentence) {
                Sentence currentSentence = (Sentence) sen;
                for (LanguageUnit unit : currentSentence.getUnits()) {
                    if (unit instanceof Word) {
                        words.add((Word) unit);
                    }
                }
            }
        }
        return words;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (LanguageUnit sen : sentences) {
            output.append(sen);
        }
        return output.toString();
    }

    /**
     * Parse line to list of language unit
     * @param data line
     * @return List of LanguageUnit
     */
    private List<LanguageUnit> parseString(String data) {

        //temporary variables
        List<LanguageUnit> output = new LinkedList<>();
        List<LanguageUnit> temp = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            // if nontext symbols
            if (!isCyrillic(c) && !isPunctuation(c)) {
                parseNonTextSymbol(sb, temp, output, c);
                temp = new LinkedList<>();
            } else if (isPunctuation(c)) {
                temp = parsePunctuation(c, sb, temp, output);
            } else {
                sb.append(data.charAt(i));
            }
        }
        // if we have some words, but we have not sentence
        parseEOL(sb, temp, output);
        return output;
    }

    /**
     * Add all words after last dot until new line symbol
     * @param sb
     * @param temp
     * @param output 
     */
    private void parseEOL(StringBuilder sb, List<LanguageUnit> temp,
            List<LanguageUnit> output) {
        try {
            if (sb.length() != 0) {
                temp.add(new Word(sb.toString()));
                sb.setLength(0);
            }
            temp.add(new Punctuation(PunctuationTypes.NEW_LINE));
            output.add(new Sentence(temp));

        } catch (EmptyWordException e) {
            e.printStackTrace();
        }
    }

    /**
     * Parse dot symbol and make a new sentence
     * @param sb
     * @param temp
     * @param output 
     */
    private void parseDot(StringBuilder sb, List<LanguageUnit> temp, List<LanguageUnit> output) {
        try {
            if (sb.length() != 0) {
                temp.add(new Word(sb.toString()));
                sb.setLength(0);
            }
            temp.add(new Punctuation(PunctuationTypes.DOT));
            output.add(new Sentence(temp));
        } catch (EmptyWordException e) {
            e.printStackTrace();
        }
    }

    /**
     * Parse withespace symbol
     * @param sb
     * @param temp 
     */
    private void parseWhitespace(StringBuilder sb, List<LanguageUnit> temp) {
        try {
            if (sb.length() != 0) {
                temp.add(new Word(sb.toString()));
                sb.setLength(0);
            }
        } catch (EmptyWordException e) {
            e.printStackTrace();
        }
        temp.add(new Punctuation(PunctuationTypes.WHITESPACE));
    }

    /**
     * Parse comma symbol
     * @param sb
     * @param temp 
     */
    private void parseComma(StringBuilder sb, List<LanguageUnit> temp) {
        try {
            if (sb.length() != 0) {
                temp.add(new Word(sb.toString()));
                sb.setLength(0);
            }
        } catch (EmptyWordException e) {
            e.printStackTrace();
        }
        temp.add(new Punctuation(PunctuationTypes.COMMA));
    }

    /**
     * Parse non text symbol
     * @param sb
     * @param temp
     * @param output
     * @param c 
     */
    private void parseNonTextSymbol(StringBuilder sb, List<LanguageUnit> temp, List<LanguageUnit> output, char c) {
        try {
            if (sb.length() != 0) {
                temp.add(new Word(sb.toString()));
                sb.setLength(0);
            }
            output.add(new Sentence(temp));
        } catch (EmptyWordException e) {
            e.printStackTrace();
        }
        output.add(new NonTextPart(String.valueOf(c)));
    }

    /**
     * Check for cyrillic character
     * @param c char
     * @return 
     */
    private boolean isCyrillic(char c) {
        return Character.UnicodeBlock.CYRILLIC.equals(Character.UnicodeBlock.of(c));
    }

    /**
     * Check if punctuation
     * @param c char
     * @return 
     */
    private boolean isPunctuation(char c) {
        return c == ' ' || c == ',' || c == '.';
    }

    private List<LanguageUnit> parsePunctuation(char c, StringBuilder sb,
                                                List<LanguageUnit> temp,
                                                List<LanguageUnit> output) {
        if (c == ',') {
            parseComma(sb, temp);
        } else if (c == ' ') {
            parseWhitespace(sb, temp);
        } else if (c == '.') {
            parseDot(sb, temp, output);
            temp = new LinkedList<>();
        }
        return temp;
    }
}
