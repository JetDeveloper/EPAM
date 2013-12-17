/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.epam.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Word class describes a word like a sequence of Symbols
 * @author Dima
 */
public class Word implements LanguageUnit{

    private final List<Symbol> word;
    
    /**
     * Constructor of word from the List<Symbol>. If list is empty, throws 
     * EmptyWordException
     * @param word input List<Symbol>
     * @throws EmptyWordException - empty string
     */
    public Word(List<Symbol> symbols) throws EmptyWordException {
        if (symbols.isEmpty()) {
            throw new EmptyWordException();
        }
        this.word = symbols;
    }
    /**
     * Constructor of word from the String. If String is empty, throws 
     * EmptyWordException
     * @param word input String
     * @throws EmptyWordException - empty string
     */
    public Word(String word) throws EmptyWordException {
        if (word.isEmpty()) {
            throw new EmptyWordException();
        }
        this.word = new ArrayList();
        for (char c : word.toCharArray()) {
            this.word.add(new Symbol(c));
        }
    }

    public List<Symbol> getWord() {
        return word;
    }
    /**
     * Return length of word
     * @return length of word
     */
    public int length() {
        return word.size();
    }
  
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Symbol s : word) {
            sb.append(s.toString());
        }
        return sb.toString();
    }

    /**
     * Returns first consonant symbol in word
     * Returns null - no consonant symbols in word
     * @return s - first consonant symbol
     */
    public Symbol getFirstConsonant() {
        for (Symbol sym : word) {
            if (!sym.isVowel()) {
                return sym;
            }
        }
        return null;
    }

    /**
     * Returns first symbol in word
     * @return s - first consonant symbol
     */
    public Symbol getFirstSymbol() {
        return word.get(0);
    }

    /**
     * Equals method for HashSet
     * @param obj Word for compare
     * @return result of equals operation
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Word other = (Word) obj;
        if (!Objects.equals(this.word, other.word)) {
            return false;
        }
        return true;
    }

    /**
     * Calculate hashcode
     * @return hashcode
     */
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.word);
        return hash;
    }
    
    
}