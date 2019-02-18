package com.company.ChatRooms;

import com.company.Main;
import com.company.MessageList;
import javafx.application.Platform;

public class ChatOutputField implements Runnable {
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

    public void showMessages() {
//        System.out.println("The chat history is:");
//        for (int i = 0; i < messages.getMessagesList().size(); i++) {
//            System.out.println(messages.getMessagesList().get(i).getMessage() + " Timestamp: " + messages.getMessagesList().get(i).getTimeStamp());
//
//            NetworkClient.get().fxController.recieveMessage("Hej Sean");
//
//
//        }
//        messages.getMessagesList().get(messages.getMessagesList().size()).getMessage()

        Platform.runLater(()-> Main.controller.recieveMessage(messages.getMessagesList().get(messages.getMessagesList().size()-1).getMessage()));

//        Platform.runLater(()-> Main.controller.recieveMessage(messages.getMessagesList().get(messages.getMessagesList().size()-1).getMessage()));
    }
}


