package com.company.ChatRooms;

import com.company.Message;
import com.company.NetworkClient;

import java.util.ArrayList;

public class ChatOutputField {
    private ArrayList<Message> messages;
    private Thread myListeningThread;

    public ChatOutputField() {
        messages = new ArrayList<>();
    }

    public void show(){
        showMessages();
    }

    public void getChatMessages() {

    }

    public void setChatMessages(Message message) {
        
    }

    private void showMessages() {
            System.out.println("The chat history is:");
            messages.stream()
                    //.peek((Message::getTimeStamp))
                    .forEach(Message::getMessage);
            //System.out.println("Client recieved the Message: " + clientMsg.getMessage() + " from the server");
            }
    }

