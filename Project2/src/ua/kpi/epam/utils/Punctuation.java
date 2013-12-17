/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.epam.utils;

/**
 * Class for punctuation symbols
 * @author Dima
 */
public class Punctuation implements LanguageUnit {

    private final PunctuationTypes type;

    public Punctuation(PunctuationTypes type) {
        this.type = type;
    }

    public PunctuationTypes getType() {
        return type;
    }

    @Override
    public String toString() {
        switch (type) {
            case COMMA: {
                return ",";
            }
            case DOT: {
                return ".";
            }
            case WHITESPACE: {
                return " ";
            }
            case NEW_LINE: {
                return "\n";
            }
            default: {
                return "";
            }
        }

    }
}
