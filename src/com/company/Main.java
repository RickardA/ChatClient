package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage primaryStage;
    public static Controller controller;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Main.primaryStage = primaryStage;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("XML/sample.fxml"));
        Parent root = loader.load();
        controller = loader.getController();

        root.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setUserData(controller);
        primaryStage.setResizable(false);
        primaryStage.setTitle("ChatApp");
        primaryStage.setScene(new Scene(root, 685, 388));
        primaryStage.show();


        ClientProgram.get();


    }


    public static void main(String[] args) {
        //hej hopp
        launch(args);
    }
}
