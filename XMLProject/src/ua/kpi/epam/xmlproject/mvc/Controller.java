/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.epam.xmlproject.mvc;

/**
 * Controller class 
 * @author Dima
 */
public class Controller {
    private Model xmlData;
    private View consoleView;

    public Controller(Model xmlData, View consoleView) {
        this.xmlData = xmlData;
        this.consoleView = consoleView;
    }
    /**
     * Validate xml 
     * @return true - is successful
     */
    public boolean validate() {
        boolean result = xmlData.validate();
        consoleView.printMessage("Валидация " +
                (result?"успешна!":"не успешна!"));
        return result;
        
    }
    /**
     * Parse xml with JAXB
     */
    public void loadWithJAXB() {
        consoleView.printMessage("\nПарсинг с помощью JAXB:\n");
        consoleView.printPlaneList(xmlData.loadWithJAXB());
    }
    /**
     * Parse xml with DOM
     */
    public void loadWithDOM() {
        consoleView.printMessage("\nПарсинг с помощью DOM:\n");
        consoleView.printPlaneList(xmlData.loadWithDOM());
    }
    /**
     * Parse xml with SAX
     */
    public void loadWithSAX() {
        consoleView.printMessage("\nПарсинг с помощью SAX:\n");
        consoleView.printPlaneList(xmlData.loadWithSAX());
    }
    /**
     * Parse xml with STAX
     */
    public void loadWithSTAX() {
        consoleView.printMessage("\nПарсинг с помощью STAX:\n");
        consoleView.printPlaneList(xmlData.loadWithSTAX());
    }
    /**
     * Serialize xml to file
     * @param fileName - file name
     */
    public void saveToXML(String fileName) {
        consoleView.printMessage("\nЗапись в файл:\n" + fileName);
        xmlData.saveToXML(fileName);
    }
}
