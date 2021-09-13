package com.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class Main extends Application {


    @Override
    public void start(Stage stage) {

        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/com/gui/MainView.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Agenda - Check-UP | Clínica Médica");
            stage.setResizable(false);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public static void main(String[] args) {
        launch(args);
    }


}
