/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.epam.xmlproject.mvc;

import java.util.List;
import ua.kpi.epam.xmlproject.warplanes.WarplaneList;
import ua.kpi.epam.xmlproject.warplanes.WarplaneList.Warplane;
import ua.kpi.epam.xmlproject.warplanes.model.WarplaneType;

/**
 * Console view class
 * @author Dima
 */
public class View {

    private Model xmlModel;

    public View(Model xmlModel) {
        this.xmlModel = xmlModel;
    }
 
    /**
     * Print message to console
     * @param message String message
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Print plane with all characteristics 
     * @param plane Warplane
     */
    public void printPlane(Warplane plane) {
        printMessage("Название: " + plane.getName());
        printMessage("Страна производитель: " + plane.getOrigin());
        printMessage("Стоимость: " + String.valueOf(plane.getPrice()));
        printMessage("Характеристики:");
        printMessage("\tТип: " + plane.getChars().getType());
        printMessage("\tКоличество экипажа: "+ plane.getChars().getPlaces());
        if (plane.getChars().getRocket() != null) {
            printMessage("\tКоличество типов ракет: " 
                    + plane.getChars().getRocket());
        }
        printMessage("\tНаличие радара: " + 
                (plane.getChars().isRadar() ? "Есть" : "Нет"));
    }
    /**
     * Print plane with all characteristics 
     * @param plane Warplane
     */
    public void printPlane(ua.kpi.epam.xmlproject.warplanes.model.Warplane plane) {
        printMessage("Название: " + plane.getName());
        printMessage("Страна производитель: " + plane.getOrigin());
        printMessage("Стоимость: " + String.valueOf(plane.getPrice()));
        printMessage("Характеристики:");
        printMessage("\tТип: " + WarplaneType.getName(plane.getType()));
        printMessage("\tКоличество экипажа: "+ plane.getPlace());
        if (plane.getType() != WarplaneType.SECRET_SERVICE_AGENT) {
            printMessage("\tКоличество типов ракет: " 
                    + plane.getRocket());
        }
        printMessage("\tНаличие радара: " + 
                (plane.isRadar() ? "Есть" : "Нет"));
    }

    /**
     * Print planelist with all characteristics 
     * @param plane WarplaneList
     */
    public void printPlaneList(WarplaneList planeList) {
        for (Warplane plane : planeList.getWarplane()) {
            printPlane(plane);
        }
    }
    /**
     * Print planelist with all characteristics 
     * @param plane WarplaneList
     */
    public void printPlaneList(List<ua.kpi.epam.xmlproject.warplanes.model.Warplane> planeList) {
        for (ua.kpi.epam.xmlproject.warplanes.model.Warplane plane : planeList) {
            printPlane(plane);
        }
    }
}
