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
    public TextArea inputbox, outputbox;
    public ListView userBox, channels;
    public TextField userNameBox;
    public PasswordField passwordBox;
    public Label errorMessageBox;
    public static double xOffset;
    public static double yOffset;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (inputbox != null) {
            inputbox.setTextFormatter(new TextFormatter<String>(change ->
                    change.getControlNewText().length() <= 140 ? change : null));

        }
    }

    @FXML
    public void enterPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            sendMessage(inputbox.getText());
        }
    }

    @FXML
    public void loginEnterKey(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            sendUserInfo();
        }
    }

    @FXML
    public void tabToPwField(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.TAB) {
            passwordBox.requestFocus();
        }
    }

    @FXML
    public void sendButtonPressed(ActionEvent event) {
        sendMessage(inputbox.getText() + "\n");
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
        inputbox.clear();
        inputbox.requestFocus();
    }

    @FXML
    public void printMessage(String message) {
        outputbox.appendText(message);
    }

    @FXML
    public void getUserInfo(ActionEvent event) {
        sendUserInfo();
    }

    @FXML
    public void sendUserInfo() {
        Platform.runLater(() -> errorMessageBox.setText(""));
        Pattern userNamePattern = Pattern.compile("[a-zA-Z ]{2,10}+");
        Matcher userNameMatcher = userNamePattern.matcher(userNameBox.getText());
        Pattern passwordPattern = Pattern.compile(".{2,20}");
        Matcher passwordMatcher = passwordPattern.matcher(passwordBox.getText());

        if (userNameMatcher.matches()) {
            if(passwordMatcher.matches()){
                NetworkClient.get()
                        .sendObjectToServer(new LogInRequestMessage(userNameBox.getText(),passwordBox.getText()));
            }else{
                Platform.runLater(() -> errorMessageBox.setText("Kontrollera lösenordet: Minst 2 karaktärer Max 20"));
            }
        } else {
            Platform.runLater(() -> errorMessageBox.setText("Kontrollera användarnamnet: Endast bokstäver, minst 2 max 10"));
        }
    }

    @FXML
    public void goToChatRoom() {
        String chosenRoom = channels.getSelectionModel().getSelectedItems().toString();
        chosenRoom = chosenRoom.substring(1);
        chosenRoom = chosenRoom.substring(0, chosenRoom.length() - 1);
        getChatRoomList().getChosenChatRoom(chosenRoom);
    }

    @FXML
    protected void exitApp(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    protected void handleMinimize(ActionEvent event) {
        primaryStage.setIconified(true);

    }
}
