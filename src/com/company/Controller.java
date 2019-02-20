package com.company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Controller implements Initializable {
    @FXML
    public TextArea inputbox, outputbox;
    public ListView userbox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //get and print UsersOnlineList
       /* userbox.getItems().add("Sean");
        userbox.getItems().add("Johan");
        userbox.getItems().add("Rickard");
        userbox.getItems().add("Rami");
        userbox.getItems().add("Mathias");*/
        //get and print chat history
    }

    @FXML
    public void enterPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER)  {
            sendMessage(inputbox.getText());
        }
    }

    @FXML
    public void sendButtonPressed(ActionEvent event) {
    sendMessage(inputbox.getText()+"\n");
    }

    @FXML
    public void sendMessage(String message) {
        Pattern p = Pattern.compile("^\\s*");
        Matcher m = p.matcher(message);
        System.out.println(p);
        System.out.println(m);

        if(!m.matches()) {
            System.out.println(message);
            NetworkClient.get().sendObjectToServer(new Message(message));
        }
            inputbox.clear();
            inputbox.requestFocus();
    }

    @FXML
    public void recieveMessage(String message) {
        outputbox.appendText(message);
    }
}