/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.epam.utils;

/**
 *
 * @author Dima
 */
public class EmptyWordException extends Exception {

    public EmptyWordException() {
        super("Введено пустое слово");
    }
}
