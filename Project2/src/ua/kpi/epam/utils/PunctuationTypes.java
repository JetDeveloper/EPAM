/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.epam.utils;

/**
 * Enumeration of punctuation types
 * @author Dima
 */
public enum PunctuationTypes {
   COMMA(','), DOT('.'), WHITESPACE(' '), NEW_LINE('\n');
   private char symbol;
   private PunctuationTypes(char symbol){
       this.symbol = symbol;
   }
   private static char[] all ;
   static{
       all = new char[PunctuationTypes.values().length];
    //for(PunctuationTypes t : PunctuationTypes.values()){
    //    all[]
    //}   
   }
   
   public static char[] getAll(){
       return all;
   }
}
