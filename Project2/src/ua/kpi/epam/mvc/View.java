/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.epam.mvc;

import java.util.List;
import ua.kpi.epam.utils.Word;

/**
 * View class for MVC pattern
 * @author Dima
 */
public class View {
    private Text model;

    public View(Text model) {
        this.model = model;
        
    }
    public void printMessage(String message) {
        System.out.println(message);
    }
    public void printWords(List<Word> words) {
        for(Word w: words) {
            System.out.println(w);
        }
    }
    public void printText() {
        System.out.println(model);
    }
    
}
