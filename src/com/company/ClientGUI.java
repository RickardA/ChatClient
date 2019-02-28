package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static com.company.ClientProgram.getChatRoomList;
import static com.company.Controller.setWindowDragListener;

public class ClientGUI extends Application {

    public static Stage primaryStage;
    public static Controller controller;
    private static Parent chatWindowRoot;
    private static FXMLLoader chatWindowLoader;



    public static void displayChatWindow() {
        controller = chatWindowLoader.getController();
        primaryStage.setScene(new Scene(chatWindowRoot, 685, 420));
        getChatRoomList().getChosenChatRoom("General");
        setWindowDragListener(chatWindowRoot);
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        ClientGUI.primaryStage = primaryStage;

        FXMLLoader loginWindowLoader = new FXMLLoader(getClass().getResource("XML/userLogin.fxml"));
        Parent loginWindowRoot = loginWindowLoader.load();
        controller = loginWindowLoader.getController();
        setWindowDragListener(loginWindowRoot);

        chatWindowLoader = new FXMLLoader(getClass().getResource("XML/chat.fxml"));
        chatWindowRoot = chatWindowLoader.load();
        chatWindowRoot.getStylesheets().add(getClass().getResource("style.css").toExternalForm());


        loginWindowRoot.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setUserData(controller);
        primaryStage.setResizable(false);
        primaryStage.setTitle("ChatApp");
        primaryStage.setScene(new Scene(loginWindowRoot, 350,220));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }
}
