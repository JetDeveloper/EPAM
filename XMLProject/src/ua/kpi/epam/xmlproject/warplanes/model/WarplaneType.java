/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.epam.xmlproject.warplanes.model;

/**
 * Emum of supported warplane types
 * @author Dima
 */
public enum WarplaneType {

    NONE, SUPPORT, ESCORT, DESTROYER, INTERCEPTOR, SECRET_SERVICE_AGENT;

    public static WarplaneType parse(String type) {
        switch (type) {
            case "Поддержка":
                return SUPPORT;
            case "Сопровождение":
                return ESCORT;
            case "Истребитель":
                return DESTROYER;
            case "Перехватчик":
                return INTERCEPTOR;
            case "Разведчик":
                return SECRET_SERVICE_AGENT;
            default:
                return NONE;
        }
    }
    public static String getName(WarplaneType type) {
         switch (type) {
            case SUPPORT:
                return "Поддержка";
            case ESCORT:
                return "Сопровождение";
            case DESTROYER:
                return "Истребитель";
            case INTERCEPTOR:
                return "Перехватчик";
            case SECRET_SERVICE_AGENT:
                return "Разведчик";
            default:
                return "Неизвестный";
        }
    }
}
