package com.example.inventry_management_oop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.io.IOException;

public class Inventry_management extends Application {
    Userinterface userinterface = new Userinterface();

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(userinterface.createContent(), 320, 240);
        stage.setTitle("Book Store (Inventry management)");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}