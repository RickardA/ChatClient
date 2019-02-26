package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage primaryStage;
    public static Controller controller;
    public static Parent helllo;
    public static FXMLLoader loader1;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Main.primaryStage = primaryStage;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("XML/userLogin.fxml"));
        Parent root = loader.load();
        controller = loader.getController();

        loader1 = new FXMLLoader(getClass().getResource("XML/sample.fxml"));
        helllo = loader1.load();



        root.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setUserData(controller);
        primaryStage.setResizable(false);
        primaryStage.setTitle("ChatApp");
        primaryStage.setScene(new Scene(root, 380,175));
        primaryStage.show();


        ClientProgram.get();


    }

    public static void setScene(){
        controller = loader1.getController();
        primaryStage.setScene(new Scene(helllo,700,700));
    }

    public static void main(String[] args) {
        //hej hopp
        launch(args);
    }
}
