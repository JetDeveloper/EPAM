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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // пустые классы
        Train trainModel = new Train();
        View consoleView = new View(trainModel);
        Controller trainController = new Controller(trainModel, consoleView);
        trainModel.initDefaultTrain();
        trainController.showTrain();
        trainController.getPackegesCount();
        trainController.getPassengerCount();
        trainController.findWagonWithPassCount(15, 80);
        trainController.sortWagonByComfort();
    }
    
}
