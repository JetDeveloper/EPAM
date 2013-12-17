/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.epam.xmlproject;
import ua.kpi.epam.xmlproject.mvc.Controller;
import ua.kpi.epam.xmlproject.mvc.Model;
import ua.kpi.epam.xmlproject.mvc.View;


/**
 * Main class of project
 * @author Dima
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        Model xmlModel = new Model("C:/Users/Dima/Desktop/EPAM/XML/planes.xml",
                "C:/Users/Dima/Desktop/EPAM/XML/planes.xsd");
        View consoleView = new View(xmlModel);
        Controller controller = new Controller(xmlModel, consoleView);
        if (controller.validate()) {
            controller.loadWithJAXB();
            controller.loadWithDOM();
            controller.loadWithSAX();
            controller.loadWithSTAX();
            controller.saveToXML("C:/Users/Dima/Desktop/EPAM/XML/planes2.xml");
        }

    }
}
