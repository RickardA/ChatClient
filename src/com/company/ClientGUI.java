package com.company;

import com.company.ChatRooms.ChatRoomList;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClientGUI extends Application {

    public static Stage primaryStage;
    public static Controller controller;
    public static Parent chatWindowRoot;
    public static FXMLLoader loader1;


    @Override
    public void start(Stage primaryStage) throws Exception{
        ClientGUI.primaryStage = primaryStage;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("XML/userLogin.fxml"));
        Parent root = loader.load();
        controller = loader.getController();

        loader1 = new FXMLLoader(getClass().getResource("XML/sample.fxml"));
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
        ChatRoomList.get().getChosenChatRoom("General");
    }
}
