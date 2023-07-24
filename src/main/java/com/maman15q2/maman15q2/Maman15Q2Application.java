package com.maman15q2.maman15q2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Maman15Q2Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Maman15Q2Application.class.getResource("Maman15Q2View.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Maman 15 Question 2");
        stage.setScene(scene);
        stage.show();

    }
    private static String [] _args;

    public static void main(String[] args) {
        _args = args;
        launch();
    }
    public static String[] getArgs() {
        return _args;
    }
}