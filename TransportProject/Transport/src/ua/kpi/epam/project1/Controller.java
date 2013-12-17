/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.kpi.epam.project1;

import java.util.List;

/**
 *
 * @author Dima
 */
public class Controller {
    private Train train;
    private View view;

    public Controller(Train train, View view) {
        this.train = train;
        this.view = view;
    }
    public void sortWagonByComfort() {
        train.sortByComfortLevel();
        view.updateView("Wagons sorted by comfort level:");
    }
    public void findWagonWithPassCount(int minValue, int maxValue) {
        List<Wagon> wagons = train.findWagonsWithPassengerCount(minValue, maxValue);
        view.updateView("Wagons with passenger count in (" + minValue 
                         + "," + maxValue + ") range:", wagons);
    }
    public void getPassengerCount() {
        int passCount = train.getPassegersCount();
        view.updateView("Passengers count:", passCount);
    }
    public void getPackegesCount() {
        int packCount = train.getPackagesCount();
        view.updateView("Packedges count:", packCount);
    }
    public void showTrain() {
        view.updateView("Train:");
    }
}
