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
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < chatHistory.getMessagesList().size(); i++) {
                    Main.controller.recieveMessage(chatHistory.getMessagesList().get(i).getSenderName() + " "
                            + chatHistory.getMessagesList().get(i).getTimeStamp() + "   "
                            + chatHistory.getMessagesList().get(i).getMessage());
                }

            }
        });
    }

    public void printMessage(Message message) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Main.controller.recieveMessage(message.getSenderName() + " "
                        + message.getTimeStamp() + "   "
                        + message.getMessage());
            }
        });
    }
}

