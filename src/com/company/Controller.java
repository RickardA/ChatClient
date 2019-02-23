package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    public TextArea inputbox, outputbox;
    public ListView userBox, channels;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //get and print UsersOnlineList here? syntax: userbox.getItems().add("Sean");
        //get and print chat history here?

        // Limits the number of characters that is allowed to be typed in the message/inputbox
        inputbox.setTextFormatter(new TextFormatter<String>(change ->
                change.getControlNewText().length() <= 140 ? change : null));
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
        //ChatRoomList.get().getChosenChatRoom(chosenRoom);
    }



}
//ChatRoomList.get().getChosenChatRoom(channels.getSelectionModel().getSelectedItems().toString());
