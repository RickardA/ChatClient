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

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        controller = loader.getController();

//        primaryStage.getProperties().put("controller", controller);

        primaryStage.setUserData(controller);

        primaryStage.setTitle("ChatApp");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();




        ClientController clientController = new ClientController(controller);
        clientController.startClient();
    }


    public static void main(String[] args) {
        //hej hopp
        launch(args);
    }
}
