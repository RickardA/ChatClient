package com.company.ChatRooms;

import com.company.Controller;
import com.company.MessageList;

public class ChatOutputField implements Runnable{
    private MessageList messages;
    private Thread myListeningThread;
Controller controller;
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
        System.out.println("The chat history is:");
//        for (int i = 0; i < messages.getMessagesList().size(); i++) {
//            System.out.println(messages.getMessagesList().get(i).getMessage() + " Timestamp: " + messages.getMessagesList().get(i).getTimeStamp());

//controller.recieveMessage()


        }

    }


