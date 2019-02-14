package com.company.ChatRooms;

import com.company.Message;
import com.company.NetworkClient;

import java.util.ArrayList;

public class ChatOutputField implements Runnable{
    private ArrayList<Message> messages;
    private Thread myListeningThread;

    public ChatOutputField(ArrayList<Message> chatHistory) {
        messages = chatHistory;
        showMessages();
    }

    @Override
    public void run() {

    }

    public void getChatMessages() {

    }

    public void setChatMessages(Message message) {

    }

    private void showMessages() {
        System.out.println("The chat history is:");
        for (int i = 0; i < messages.size(); i++) {
            System.out.println(messages.get(i).getMessage() + " Timestamp: " + messages.get(i).getTimeStamp());
        }
    }
}

