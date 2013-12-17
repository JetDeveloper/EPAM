/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.epam.project2;

import java.util.ListIterator;
import ua.kpi.epam.mvc.Controller;
import ua.kpi.epam.mvc.Text;
import ua.kpi.epam.mvc.View;


/**
 * Main class for the program
 * @author Dima
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Text text;
        if (args.length == 0) {
            text = new Text();          /* if no arguments use default text */
        } else {
            text = new Text(args[0]);   /* using text file in args[0]       */
        }
        View consoleView = new View(text);
        Controller controller = new Controller(text, consoleView);
        controller.displayText();
        controller.sortByFirstConsonant();
    }
}
