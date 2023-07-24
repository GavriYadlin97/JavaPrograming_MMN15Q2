package com.maman15q2.maman15q2;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

public class MyHBox extends HBox {
    CarTrafficLight cars;
    PeopleTrafficLight peoples;

    public MyHBox(double radius) {
        super(radius);
        final int MARGIN = 10;
        this.cars = new CarTrafficLight(radius, MARGIN);
        this.peoples = new PeopleTrafficLight(radius, MARGIN);
        this.getChildren().addAll(cars, peoples);
        setPadding(new Insets(radius / 2));
    }

    public synchronized CarTrafficLight getCarsLight() {
        return cars;
    }

    public synchronized PeopleTrafficLight getPeoplesLight() {
        return peoples;
    }
}
