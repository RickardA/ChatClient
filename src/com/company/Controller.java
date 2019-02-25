package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.company.ChatRooms.ChatRoomList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    public TextArea inputbox, outputbox;
    public ListView userBox, channels;
    public TextField userNameBox, userPasswordBox;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //get and print UsersOnlineList here? syntax: userbox.getItems().add("Sean");
        //get and print chat history here?

        // Limits the number of characters that is allowed to be typed in the message/inputbox
        if (inputbox != null) {
            inputbox.setTextFormatter(new TextFormatter<String>(change ->
                    change.getControlNewText().length() <= 140 ? change : null));
        }
    }

    @FXML   // Listens for an Enter key to be pressed
    public void enterPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            sendMessage(inputbox.getText());
        }
    }

    @FXML   // Listens for the Send button to be pressed
    public void sendButtonPressed(ActionEvent event) {
        sendMessage(inputbox.getText() + "\n");
    }

    @FXML  // Checks the beginning of the text for empty characters (including Enter). If none found, sends it.
    public void sendMessage(String message) {
        Pattern p = Pattern.compile("^\\s*");
        Matcher m = p.matcher(message);

        if (!m.matches()) {
            System.out.println(message);
            NetworkClient.get().sendObjectToServer(new Message(message, ClientProgram.get().getUser().getChannelID()));
        }
        inputbox.clear();
        inputbox.requestFocus();
    }

    @FXML   // Recives messages and puts them in the Chat/Outputbox
    public void recieveMessage(String message) {
        outputbox.appendText(message);
    }

    @FXML
    public void goToChatRoom() {
        String chosenRoom = channels.getSelectionModel().getSelectedItems().toString();
        chosenRoom = chosenRoom.substring(1);
        chosenRoom = chosenRoom.substring(0, chosenRoom.length() - 1);
        System.out.println(chosenRoom);
        ChatRoomList.get().getChosenChatRoom(chosenRoom);
    }

    @FXML
    public void getUserInfo(ActionEvent event)throws IOException {
        Pattern p = Pattern.compile("^\\s*");
        Matcher m = p.matcher(userNameBox.getText());

        if (m.matches()){
            Label label= new Label("neeej");

        }
        else {
            System.out.println("User name: "+ userNameBox.getText());
            NetworkClient.get().sendObjectToServer(new LogInRequestMessage(userNameBox.getText(), userPasswordBox.getText()));


            Parent chatView = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene scene = new Scene(chatView);
            Stage chatStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            chatStage.setScene(scene);
            chatStage.show();
        }

    }
}