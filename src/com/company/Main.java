package com.company;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        /*Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Macrosoft Skajp");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();*/
        Controller controller = new Controller();
        controller.startClient();
    }


    public static void main(String[] args) {
        //hej hopp
        launch(args);
    }
}