/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.epam.utils;

import java.util.List;

/**
 *
 * @author Dima
 */
public class Sentence implements LanguageUnit {
    private List<LanguageUnit> sentence;

    public Sentence(List<LanguageUnit> sentence) {
        this.sentence = sentence;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for(LanguageUnit sen: sentence){
            output.append(sen);
        }
        return output.toString();
    }
    
    public List<LanguageUnit> getUnits(){
        return sentence;
    }
}
