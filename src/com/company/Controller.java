package com.company;

import com.company.Message.Message;
import com.company.MessageSendingClasses.LogInRequestMessage;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.company.ClientGUI.primaryStage;
import static com.company.ClientProgram.getChatRoomList;
import static com.company.ClientProgram.getLoggedInUser;

public class Controller implements Initializable {

    @FXML
    public TextArea chatInputBox, chatOutputBox;
    public ListView userListBox, roomListBox;
    public TextField loginNameBox;
    public PasswordField loginPasswordBox;
    public Label errorMessageBox;
    public static double xOffset;
    public static double yOffset;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (chatInputBox != null) {
            chatInputBox.setTextFormatter(new TextFormatter<String>(change ->
                    change.getControlNewText().length() <= 140 ? change : null));
        }
    }

    @FXML
    public void chatEnterPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            sendMessage(chatInputBox.getText());
        }
    }

    @FXML
    public void loginEnterPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            sendUserInfo();
        }
    }

    @FXML
    public void tabToPasswordBox(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.TAB) {
            loginPasswordBox.requestFocus();
        }
    }

    @FXML
    public void sendButtonPressed(ActionEvent event) {
        sendMessage(chatInputBox.getText() + "\n");
    }

    public static void setWindowDragListener(Parent root) {

        root.setOnMousePressed(event -> {
            xOffset = primaryStage.getX() - event.getScreenX();
            yOffset = primaryStage.getY() - event.getScreenY();
        });

        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() + xOffset);
            primaryStage.setY(event.getScreenY() + yOffset);
        });
    }

    @FXML
    public void sendMessage(String message) {
        Pattern p = Pattern.compile("^\\s*");
        Matcher m = p.matcher(message);

        if (!m.matches()) {
            NetworkClient.get().sendObjectToServer(new Message(message, getLoggedInUser().getUserID()));
        }
        chatInputBox.clear();
        chatInputBox.requestFocus();
    }

    @FXML
    public void printMessage(String message) {
        chatOutputBox.appendText(message);
    }

    @FXML
    public void getUserInfo(ActionEvent event) {
        sendUserInfo();
    }

    @FXML
    public void sendUserInfo() {
        Platform.runLater(() -> errorMessageBox.setText(""));
        Pattern userNamePattern = Pattern.compile("[a-zA-Z ]{2,10}+");
        Matcher userNameMatcher = userNamePattern.matcher(loginNameBox.getText());
        Pattern passwordPattern = Pattern.compile(".{2,20}");
        Matcher passwordMatcher = passwordPattern.matcher(loginPasswordBox.getText());

        if (userNameMatcher.matches()) {
            if(passwordMatcher.matches()){
                NetworkClient.get()
                        .sendObjectToServer(new LogInRequestMessage(loginNameBox.getText(), loginPasswordBox.getText()));
            }else{
                Platform.runLater(() -> errorMessageBox.setText("Kontrollera lösenordet: Minst 2 tecken Max 20"));
            }
        } else {
            Platform.runLater(() -> errorMessageBox.setText("Kontrollera användarnamnet: Endast bokstäver, minst 2 max 10"));
        }
    }

    @FXML
    public void goToChatRoom() {
        String chosenRoom = roomListBox.getSelectionModel().getSelectedItems().toString();
        chosenRoom = chosenRoom.substring(1);
        chosenRoom = chosenRoom.substring(0, chosenRoom.length() - 1);
        getChatRoomList().getChosenChatRoom(chosenRoom);
    }

    @FXML
    protected void handleExit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    protected void handleMinimize(ActionEvent event) {
        primaryStage.setIconified(true);
    }
}
