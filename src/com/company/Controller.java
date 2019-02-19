package com.company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;


public class Controller implements Initializable {


    @FXML
    public TextArea inputbox, outputbox;
    public ListView userbox;





    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //get and print UsersOnlineList
        userbox.getItems().add("Sean");
        userbox.getItems().add("Johan");
        userbox.getItems().add("Rickard");
        userbox.getItems().add("Rami");
        userbox.getItems().add("Mathias");
        //get and print chat history
    }

    @FXML
    public void onEnter(KeyEvent ke){
        System.out.println("Key Pressed: " + ke.getCode());
//        sendMessage(ae);
    }


    @FXML
    public void sendMessage(ActionEvent event) {
// Skapa message object här istället?
        String timeStamp = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
        NetworkClient.get().sendObjectToServer(new Message(inputbox.getText()));
        inputbox.clear();
    }

    @FXML
    public void recieveMessage(String message) {
        outputbox.appendText(message+"\n");
    }
}
