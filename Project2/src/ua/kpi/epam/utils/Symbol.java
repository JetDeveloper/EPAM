/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.epam.utils;

/**
 * Symbol class describes a symbol with vowel property
 * @author Dima
 */
public class Symbol implements LanguageUnit {

    private Character symbol;
    private boolean vowel;         /* vowel - гласный звук :) */

   /**
     * Constructor of Symbol class with char symbol
     * It sets a property of vowel
     * @param symbol - char symbol
     */
    public Symbol(char symbol) {
        this.symbol = symbol;
        checkVowel();
    }

    /**
     * Check vowel property of symbol of russian language rules
     */
    private void checkVowel() {
        // char to lower case
        char c = Character.toLowerCase(symbol);
        switch (c) {
            case 'а': {
                vowel = true;
                break;
            }
            case 'о': {
                vowel = true;
                break;
            }
            case 'у': {
                vowel = true;
                break;
            }
            case 'ы': {
                vowel = true;
                break;
            }
            case 'я': {
                vowel = true;
                break;
            }
            case 'ю': {
                vowel = true;
                break;
            }
            case 'е': {
                vowel = true;
                break;
            }
            case 'и': {
                vowel = true;
                break;
            }
            case 'ё': {
                vowel = true;
                break;
            }
            default: {
                vowel = false;
            }
        }
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Symbol other = (Symbol) obj;
        if (!this.symbol.equals(other.symbol) ) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.symbol;
        return hash;
    }

    @Override
    public String toString() {
        return symbol.toString();
    }

    public boolean isVowel() {
        return vowel;
    }
    
}