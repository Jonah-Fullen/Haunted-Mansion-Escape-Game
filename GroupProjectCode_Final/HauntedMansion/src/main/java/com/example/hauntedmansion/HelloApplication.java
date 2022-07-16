/**
 * HAUNTED MANSION ESCAPE
 * BY: Jonah Fullen, Rachel Keiter, Courtney Rogers, Hannah Vuncannon, and Audrey Warrene
 *
 * Game Initialization
 * Run this file to play the Haunted Mansion Escape Game.
 */

package com.example.hauntedmansion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Haunted Mansion");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}