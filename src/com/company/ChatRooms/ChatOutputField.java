package com.company.ChatRooms;

import com.company.Main;
import com.company.MessageList;
import javafx.application.Platform;

public class ChatOutputField implements Runnable{
    private MessageList messages;
    private Thread myListeningThread;

    public ChatOutputField(MessageList chatHistory) {
        messages = chatHistory;
        showMessages();
    }

    @Override
    public void run() {

    }

    public void getChatMessages() {

    }

    public void UpdateChatMessages(MessageList messageList) {
        messages = messageList;
        showMessages();
    }

    private void showMessages() {
//        for (int i = 0; i < messages.getMessagesList().size(); i++) {
//            System.out.println(messages.getMessagesList().get(i).getMessage() + " Timestamp: " + messages.getMessagesList().get(i).getTimeStamp());
//        }

        Platform.runLater(()-> Main.controller.recieveMessage(messages.getMessagesList().get(messages.getMessagesList().size()-1).getMessage()));
    }
}

