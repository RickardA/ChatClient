package com.company.ChatRooms;

import com.company.Main;
import com.company.Message.Message;
import com.company.Message.MessageList;
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
        Main.controller.outputbox.clear();
        Platform.runLater(() -> {
            for (Message msg : chatHistory.getMessagesList()) {
                Main.controller.recieveMessage(msg.getTimeStamp() + " " + msg.getSenderName() + " " + msg.getMessage());
            }
        });
    }

    public void printMessage(Message message) {
        Platform.runLater(() -> Main.controller.recieveMessage(message.getTimeStamp() + " "
                + message.getSenderName() + " "
                + message.getMessage()));
    }
}

