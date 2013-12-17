/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.epam.project1;

/**
 *
 * @author Dima
 */
public enum WagonType {

    BOX(0), RESERVED_SEAT(1), COUPE(2), SV(3);
    
    private Wagon wagon;
 
    WagonType(int type) {
        switch (type) {
            case 0: {
                wagon = new Wagon(0, Wagon.BOX_PACKAGE, Wagon.ComfortLevel.NONE);
                break;
            }
            case 1: {
                wagon = new Wagon(Wagon.RESERVED_SEAT_PASSENGER, 
                                  Wagon.RESERVED_SEAT_PACKAGE,
                                  Wagon.ComfortLevel.LOW);
                break;
            }
            case 2: {
                wagon = new Wagon(Wagon.COUPE_PASSENGER, 
                                  Wagon.COUPE_PACKAGE, 
                                  Wagon.ComfortLevel.MEDIUM);
                break;
            }
            case 3: {
                wagon = new Wagon(Wagon.SV_PASSENGER, 
                                  Wagon.SV_PACKAGE,
                                  Wagon.ComfortLevel.HIGH);
                break;
            }
            default:
                break;
        }
    }
    
    public Wagon getWagon() {
        return wagon;
    }
    
}
