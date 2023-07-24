package com.maman15q2.maman15q2;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Maman15Q2Controller {

    @FXML
    private GridPane grid;

    @FXML
    private MyHBox west;

    @FXML
    private MyHBox north;

    @FXML
    private MyHBox east;

    @FXML
    private MyHBox south;


    public void initialize() {
        final int size = 25;
        final int firstArg = 0;
        final int secondArg = 1;

        String[] args = Maman15Q2Application.getArgs();
        checkArgs(args);

        grid.add(north = new MyHBox(size), 1, 0);
        grid.add(west = new MyHBox(size), 0, 1);
        grid.add(south = new MyHBox(size), 1, 2);
        grid.add(east = new MyHBox(size), 2, 1);
        runBlinker(getTimes(args[firstArg]), getTimes(args[secondArg]));
    }

    public void runBlinker(long waitTime, long goTime) {
        BlinkTask northSouthTask = new BlinkTask(north, east, south, west, waitTime, goTime);
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(northSouthTask);
        executorService.shutdown();
    }

    private int getTimes(String args) {
        try {
            return Integer.parseInt(args);
        } catch (NumberFormatException e) {
            System.err.println("Cannot resume with given arguments");
            System.exit(-1);
        }
        return 0;
    }

    private void checkArgs(String[] args) {
        if (args.length != 2) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Missing arguments!");
            alert.showAndWait();
            System.exit(-1);
        }
    }
}