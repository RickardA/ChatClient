package com.company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    public TextArea inputbox, outputbox;
    public ListView userbox;
    public TextField userNameBox, userNamePasswordBox, repeatPasswordBox;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //get and print UsersOnlineList
        /*userbox.getItems().add("Sean");
        userbox.getItems().add("Johan");
        userbox.getItems().add("Rickard");
        userbox.getItems().add("Rami");
        userbox.getItems().add("Mathias");*/
        //get and print chat history
    }

    @FXML
    public void sendMessage(ActionEvent event) {
// Skapa message object här istället?
        String timeStamp = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
        NetworkClient.get().sendObjectToServer(new Message(inputbox.getText(),ClientProgram.get().getUser().getChannelID()));
        inputbox.clear();
    }

    @FXML
    public void recieveMessage(String message) {
        outputbox.appendText(message+"\n");
    }

    @FXML
    public void getUserInfo(ActionEvent event){
        ClientProgram.get().getUser().setUserName(userNameBox.getText());

    }
}
