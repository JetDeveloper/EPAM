/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.epam.utils;

/**
 * NonTextPart class is used for code construction and other non russian
 * text constructions 
 * @author Dima
 */
public class NonTextPart implements LanguageUnit {
    private String contents;

    public NonTextPart(String contents) {
        this.contents = contents;
    }

    public String toString() {
        return contents;
    }
    
    
}
