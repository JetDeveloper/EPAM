/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.epam.mvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import ua.kpi.epam.utils.Word;

/**
 * Controller class of MVC pattern
 * @author Dima
 */
public class Controller {

    private Text model;
    private View consoleView;

    public Controller(Text model, View consoleView) {
        this.model = model;
        this.consoleView = consoleView;
    }

    public void sortByFirstConsonant() {

        HashSet<Word> words = new HashSet<>();
        for (Word w : model.getWords()) {
            if (w.getFirstSymbol().isVowel() && w.getFirstConsonant() != null) {
                words.add(w);
            }
        }
        
        // using HashSet to remove duplicates
        List<Word> removeDuplicates = new ArrayList<>(words);
        // Слова, начинающиеся с гласных букв, рассортировать в алфавитном 
        // порядке по первой согласной букве. 
        Collections.sort(removeDuplicates, new Comparator<Word>() {

            @Override
            public int compare(Word o1, Word o2) {
                // Comparing first consonant symbols in
                // alphabetical order
                if (o1.getFirstConsonant().getSymbol()
                        < o2.getFirstConsonant().getSymbol()) {
                    return -1;
                } else if (o1.getFirstConsonant().getSymbol()
                        > o2.getFirstConsonant().getSymbol()) {
                    return 1;
                } else {
                    return 0;
                }

            }
        });
        consoleView.printMessage("Слова, начинающиеся с гласных букв, "
                + "рассортировать в алфавитном  порядке по"
                + " первой согласной букве. ");
        consoleView.printWords(removeDuplicates);
    }

    public void displayText() {
        consoleView.printMessage("Исходный текст:");
        consoleView.printText();
    }
}
