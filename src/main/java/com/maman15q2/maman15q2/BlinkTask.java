package com.maman15q2.maman15q2;

import javafx.concurrent.Task;

public class BlinkTask extends Task<Integer> {
    private MyHBox north;
    private MyHBox east;
    private MyHBox south;
    private MyHBox west;
    private long waitTime;
    private long goTime;
    private final double ON = 1;
    private final double OFF = 0.2;
    private final int BLINKS = 3;

    public BlinkTask(MyHBox north, MyHBox east, MyHBox south, MyHBox west, long waitTime, long goTime) {
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
        this.waitTime = waitTime;
        this.goTime = goTime;
        bindProperties(south, north);
        bindProperties(east, west);
    }

    @Override
    protected Integer call() {
        while (true) {
            PerformCycle(north);
            PerformCycle(west);
        }
    }

    private void PerformCycle(MyHBox direction) {
        try {
            pedestrianStop(direction);
            carPrepareToGo(direction);
            Thread.sleep(waitTime);
            carGo(direction);
            Thread.sleep(goTime);
            for (int i = 0; i < BLINKS; i++) {
                direction.getCarsLight().getGreenLight().setOpacity(OFF);
                Thread.sleep(waitTime);
                direction.getCarsLight().getGreenLight().setOpacity(ON);
                Thread.sleep(waitTime);
            }
            carPrepareToStop(direction);
            Thread.sleep(waitTime);
            carStop(direction);
            pedestrianGo(direction);
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            notifyAll();
        }
    }

    private void bindProperties(MyHBox firstDirection, MyHBox secondDirection) {
        firstDirection.getCarsLight().getGreenLight().opacityProperty().bind(secondDirection.getCarsLight().getGreenLight().opacityProperty());
        firstDirection.getCarsLight().getYellowLight().opacityProperty().bind(secondDirection.getCarsLight().getYellowLight().opacityProperty());
        firstDirection.getCarsLight().getRedLight().opacityProperty().bind(secondDirection.getCarsLight().getRedLight().opacityProperty());
        firstDirection.getPeoplesLight().getRedLight().opacityProperty().bind(secondDirection.getPeoplesLight().getRedLight().opacityProperty());
        firstDirection.getPeoplesLight().getGreenLight().opacityProperty().bind(secondDirection.getPeoplesLight().getGreenLight().opacityProperty());
    }

    private void carPrepareToGo(MyHBox direction) {
        direction.getCarsLight().getRedLight().setOpacity(ON);
        direction.getCarsLight().getYellowLight().setOpacity(ON);
        direction.getCarsLight().getGreenLight().setOpacity(OFF);
    }

    private void pedestrianStop(MyHBox direction) {
        direction.getPeoplesLight().getRedLight().setOpacity(ON);
        direction.getPeoplesLight().getGreenLight().setOpacity(OFF);
    }

    private void carGo(MyHBox direction) {
        direction.getCarsLight().getRedLight().setOpacity(OFF);
        direction.getCarsLight().getYellowLight().setOpacity(OFF);
        direction.getCarsLight().getGreenLight().setOpacity(ON);
    }

    private void carPrepareToStop(MyHBox direction) {
        direction.getCarsLight().getRedLight().setOpacity(OFF);
        direction.getCarsLight().getYellowLight().setOpacity(ON);
        direction.getCarsLight().getGreenLight().setOpacity(OFF);
    }

    private void carStop(MyHBox direction) {
        direction.getCarsLight().getRedLight().setOpacity(ON);
        direction.getCarsLight().getYellowLight().setOpacity(OFF);
        direction.getCarsLight().getGreenLight().setOpacity(OFF);
    }

    private void pedestrianGo(MyHBox direction) {
        direction.getPeoplesLight().getRedLight().setOpacity(OFF);
        direction.getPeoplesLight().getGreenLight().setOpacity(ON);
    }
}
