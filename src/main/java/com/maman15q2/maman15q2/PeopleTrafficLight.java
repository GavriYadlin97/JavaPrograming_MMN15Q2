package com.maman15q2.maman15q2;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.io.File;

public class PeopleTrafficLight extends StackPane {
    private Circle redLight;
    private Circle greenLight;
    private Circle walkingPedestrian;
    private Circle standingPedestrian;
    private Rectangle lightBox;

    public PeopleTrafficLight(double radius, int margin) {
        super();
        final int TAPER = 25;

        redLight = new Circle(radius, Color.RED);
        greenLight = new Circle(radius, Color.GREEN);
        walkingPedestrian = new Circle(radius);
        standingPedestrian = new Circle(radius);
        lightBox = new Rectangle((radius + margin) * 2, 2 * (2 * radius) + 3 * margin, Color.BLACK);
        try {
            standingPedestrian.setFill(new ImagePattern(new Image("D:\\standingPedestrian.png")));
            walkingPedestrian.setFill(new ImagePattern(new Image("D:\\walkingPedestrian.png")));
        }
        catch (Exception e){
            Alert alert =new Alert(Alert.AlertType.ERROR,"Missing the following:\nD:\\standingPedestrian.png\nand\\or\nD:\\walkingPedestrian.png\nProgram cannot resume!");
            alert.showAndWait();
            System.exit(-1);
        }
        lightBox.setArcWidth(TAPER);
        lightBox.setArcHeight(TAPER);

        redLight.setTranslateY(-((double) margin / 2 + radius));
        standingPedestrian.setTranslateY(-((double) margin / 2 + radius));
        greenLight.setTranslateY((double) margin / 2 + radius);
        walkingPedestrian.setTranslateY((double) margin / 2 + radius);

        getChildren().addAll(lightBox, redLight, greenLight,walkingPedestrian,standingPedestrian);
    }

    public Circle getGreenLight() {
        return greenLight;
    }

    public Circle getRedLight() {
        return redLight;
    }
}
