package com.company.ChatRooms;

import com.company.Message.Message;
import com.company.Message.MessageList;
import com.company.ClientGUI;
import javafx.application.Platform;

public class ChatOutputField implements Runnable {
    private MessageList chatHistory;

    public ChatOutputField(MessageList chatHistory) {
        this.chatHistory = chatHistory;
    }

    @Override
    public void run() {
        showMessageHistory();
    }

    private void showMessageHistory() {
        ClientGUI.controller.chatOutputBox.clear();
        Platform.runLater(() -> {
            for (Message msg : chatHistory.getMessagesList()) {
                ClientGUI.controller.printMessage(msg.getTimeStamp()
                        + " " + msg.getSenderName()
                        + ": " + msg.getMessage());
            }
            ClientGUI.controller.printMessage(chatHistory.getWelcomeMessage().getMessage());
        });
    }

    public void printMessage(Message message) {
        Platform.runLater(() -> ClientGUI.controller.printMessage(message.getTimeStamp() + " "
                + message.getSenderName() + ": "
                + message.getMessage()));
    }
}

