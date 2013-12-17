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
public class View {
    private Train train;

    public View(Train train) {
        this.train = train;
    }

    public void updateView(String message) {
        System.out.println(message);
        System.out.println(train.toString());
        System.out.println();
    }
    public void updateView(String message, List<Wagon> train) {
        System.out.println(message);
        System.out.println(train.toString());
        System.out.println();
    }
    public void updateView(String message, int value) {
        System.out.println(message);
        System.out.println(value);
        System.out.println();
    }
}
