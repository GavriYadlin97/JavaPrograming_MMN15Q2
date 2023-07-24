package com.maman15q2.maman15q2;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class CarTrafficLight extends StackPane {
    private Circle redLight;
    private Circle yellowLight;
    private Circle greenLight;
    private Rectangle lightBox;


    public CarTrafficLight(double radius, int margin) {
        super();
        final int TAPER = 25;

        redLight = new Circle(radius, Color.RED);
        yellowLight = new Circle(radius, Color.YELLOW);
        greenLight = new Circle(radius, Color.GREEN);

        lightBox = new Rectangle((radius + margin) * 2, 3 * (2 * radius) + 4 * margin, Color.BLACK);
        lightBox.setArcWidth(TAPER);
        lightBox.setArcHeight(TAPER);

        redLight.setTranslateY(-(margin + 2 * radius));
        greenLight.setTranslateY(margin + 2 * radius);

        this.getChildren().addAll(lightBox, redLight, yellowLight, greenLight);
    }

    public Circle getGreenLight() {
        return greenLight;
    }

    public Circle getRedLight() {
        return redLight;
    }

    public Circle getYellowLight() {
        return yellowLight;
    }
}
