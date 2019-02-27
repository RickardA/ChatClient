package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    public static Stage primaryStage;
    public static Controller controller;
    public static Parent chatWindowRoot;
    public static FXMLLoader loader1;

    private AnchorPane anchorPane;



    @Override
    public void start(Stage primaryStage) throws Exception{
        Main.primaryStage = primaryStage;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("XML/userLogin.fxml"));
        Parent root = loader.load();
        controller = loader.getController();
        primaryStage.initStyle(StageStyle.UNDECORATED);

        loader1 = new FXMLLoader(getClass().getResource("XML/chat.fxml"));
        chatWindowRoot = loader1.load();
        chatWindowRoot.getStylesheets().add(getClass().getResource("style.css").toExternalForm());



        root.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setUserData(controller);
        primaryStage.setResizable(false);
        primaryStage.setTitle("ChatApp");
        primaryStage.setScene(new Scene(root, 380,175));
        primaryStage.show();



        ClientProgram.get();

    }

    public static void displayChatWindow(){
        controller = loader1.getController();
        primaryStage.setScene(new Scene(chatWindowRoot,685,388));

    }


    public static void main(String[] args) {
        //hej hopp
        launch(args);
    }
}
