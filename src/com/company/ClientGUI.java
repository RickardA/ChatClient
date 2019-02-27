package com.company;

import com.company.ChatRooms.ChatRoomList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ClientGUI extends Application {

    public static Stage primaryStage;
    public static Controller controller;
    private static Parent chatWindowRoot;
    private static FXMLLoader chatWindowLoader;
    private static double yOffset;
    private static double xOffset;


    public static void displayChatWindow() {
        controller = chatWindowLoader.getController();
        primaryStage.setScene(new Scene(chatWindowRoot, 685, 420));
        ChatRoomList.get().getChosenChatRoom("General");
        setWindowDragListener(chatWindowRoot);
    }

    private static void setWindowDragListener(Parent root) {

        root.setOnMousePressed(event -> {
            xOffset = primaryStage.getX() - event.getScreenX();
            yOffset = primaryStage.getY() - event.getScreenY();
        });

        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() + xOffset);
            primaryStage.setY(event.getScreenY() + yOffset);

        });


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ClientGUI.primaryStage = primaryStage;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("XML/userLogin.fxml"));
        Parent root = loader.load();
        controller = loader.getController();
        setWindowDragListener(root);

        chatWindowLoader = new FXMLLoader(getClass().getResource("XML/sample.fxml"));
        chatWindowRoot = chatWindowLoader.load();
        chatWindowRoot.getStylesheets().add(getClass().getResource("style.css").toExternalForm());


        root.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setUserData(controller);
        primaryStage.setResizable(false);
        primaryStage.setTitle("ChatApp");
        primaryStage.setScene(new Scene(root, 350,220));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
        ClientProgram.get();
    }
}
