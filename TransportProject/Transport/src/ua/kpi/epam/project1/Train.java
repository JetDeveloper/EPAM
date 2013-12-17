/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kpi.epam.project1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Dima
 */
public class Train {

    List<Wagon> wagons = new ArrayList<Wagon>();

    /**
     * Create default rain
     */
    public void initDefaultTrain() {
        wagons.add(WagonType.BOX.getWagon());
        wagons.add(WagonType.RESERVED_SEAT.getWagon());
        wagons.add(WagonType.RESERVED_SEAT.getWagon());
        wagons.add(WagonType.RESERVED_SEAT.getWagon());
        wagons.add(WagonType.COUPE.getWagon());
        wagons.add(WagonType.SV.getWagon());
    }

    /**
     * Get passengers count in train
     * @return passengers count
     */
    public int getPassegersCount() {
        int count = 0;
        for (Wagon w : wagons) {
            count += w.getPassengerCount();
        }
        return count;
    }

    /**
     * Get packages count in train
     * @return packages count
     */
    public int getPackagesCount() {
        int count = 0;
        for (Wagon w : wagons) {
            count += w.getPackageCount();
        }
        return count;
    }
    
    /**
     * Sort wagons in train by confort level value
     */
    public void sortByComfortLevel() {
        Collections.sort(wagons, new Comparator<Wagon>() {
            @Override
            public int compare(Wagon t, Wagon t1) {
                // sort HIGH -> LOW 
                if (t.getComfortLevel().getLevel()
                        > t1.getComfortLevel().getLevel()) {
                    return -1;
                } else if (t.getComfortLevel().getLevel()
                        < t1.getComfortLevel().getLevel()) {
                    return 1;
                }
                return 0;
            }
        });

    }
    /**
     * Get List of Wagon with passengers count in range (minCount,maxCount)
     * @param minCount min value in range
     * @param maxCount max value in range
     * @return 
     */
    public List<Wagon> findWagonsWithPassengerCount(int minCount, int maxCount) {
        List<Wagon> outWagons = new ArrayList<Wagon>();
        for (Wagon wagon : wagons) {
            if (wagon.getPassengerCount() > minCount
                    && wagon.getPassengerCount() < maxCount) {
                outWagons.add(wagon);
            }
        }
        return outWagons;
    }

    @Override
    public String toString() {
        StringBuffer outString = new StringBuffer();
        for (Wagon w : wagons) {
            outString.append(w.toString());
            outString.append("\n");
        }
        return "Train{ " + "wagons=" + outString + '}';
    }

}
