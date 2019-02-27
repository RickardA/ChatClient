package com.company;

import com.company.ChatRooms.ChatRoomList;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ClientGUI extends Application {

    public static Stage primaryStage;
    public static Controller controller;
    public static Parent chatWindowRoot;
    public static FXMLLoader loader1;
    public double yOffset;
    public double xOffset;


    public static void displayChatWindow() {
        controller = loader1.getController();
        primaryStage.setScene(new Scene(chatWindowRoot, 685, 388));
        ChatRoomList.get().getChosenChatRoom("General");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
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
        primaryStage.setScene(new Scene(root, 350,220));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
        ClientProgram.get();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = primaryStage.getX() - event.getScreenX();
                yOffset = primaryStage.getY() - event.getScreenY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() + xOffset);
                primaryStage.setY(event.getScreenY() + yOffset);

            }
        });


    }
}
