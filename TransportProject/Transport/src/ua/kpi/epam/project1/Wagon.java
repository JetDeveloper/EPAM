/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.epam.project1;

/**
 *
 * @author Dima
 */
public class Wagon {

    public static final int RESERVED_SEAT_PACKAGE = 500;
    public static final int RESERVED_SEAT_PASSENGER = 54;
    public static final int COUPE_PACKAGE = 600;
    public static final int COUPE_PASSENGER = 30;
    public static final int SV_PACKAGE = 800;
    public static final int SV_PASSENGER = 15;
    public static final int BOX_PACKAGE = 5000;
    /**
     * Enumerates all comfort levels
     */
    public enum ComfortLevel {

        NONE(0), LOW(1), MEDIUM(2), HIGH(3);

        private int comfortLevel;

        ComfortLevel(int comfortLevel) {
            this.comfortLevel = comfortLevel;
        }

        public int getLevel() {
            return comfortLevel;
        }

    };

    protected int passengerCount;
    protected int packageCount;
    protected ComfortLevel comfortLevel;
    protected int number;

    /**
     * Constructor of Wagon with wagon number
     * @param number - number of vagon
     */
    public Wagon(int number) {
        this.number = number;
    }
    
    /**
     * Constructor of Wagon with all param's
     * @param passengerCount - passenger count
     * @param packageCount - package count
     * @param comfortLevel - comfort level
     */
    public Wagon(int passengerCount, int packageCount, ComfortLevel comfortLevel) {
        this.passengerCount = passengerCount;
        this.packageCount = packageCount;
        this.comfortLevel = comfortLevel;
    }

    /**
     * Get passengers count in wagon
     * @return passengers count
     */
    public int getPassengerCount() {
        return passengerCount;
    }

    /**
     * Get package count in wagon
     * @return package count
     */
    public int getPackageCount() {
        return packageCount;
    }

    /**
     * Get comfort level of wagon
     * @return comfort level
     */
    public ComfortLevel getComfortLevel() {
        return comfortLevel;
    }

    @Override
    public String toString() {
        return  "Wagon {" + " number=" + number
                + " passengerCount=" + passengerCount + ", packageCount="
                + packageCount + ", comfortLevel=" + comfortLevel + '}';
    }

}
