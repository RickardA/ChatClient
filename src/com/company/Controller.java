package com.company;

import com.company.ChatRooms.UserInputField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    public TextArea inputbox, outputbox;
    public ListView userbox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //get and print user list
        userbox.getItems().add("Sean");
        userbox.getItems().add("Johan");
        userbox.getItems().add("Rickard");
        userbox.getItems().add("Rami");
        userbox.getItems().add("Mathias");
        //get and print chat history
    }

    @FXML
    public void sendMessage(ActionEvent event) {
        UserInputField userInputField = new UserInputField();  // Fixa!

        userInputField.createMessage(inputbox.getText());
        inputbox.clear();
        NetworkClient.get().sendObjectToServer(new Message(inputbox.getText(), "ID", "HH:MM"));
    }

    @FXML
    public void recieveMessage(String message) {
        outputbox.appendText(message+"\n");
    }
}
