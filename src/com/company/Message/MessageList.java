package com.company.Message;

import com.company.Message.Message;

import java.io.Serializable;
import java.util.ArrayList;

public class MessageList implements Serializable{
    private ArrayList<Message> messagesList;
    private Message welcomeMessage;
    static final long serialVersionUID = 30;

    public MessageList() {
        messagesList = new ArrayList<>();
        welcomeMessage = new Message();
  }

    public ArrayList<Message> getMessagesList() {
        return messagesList;
    }

    public Message getWelcomeMessage() {
        return welcomeMessage;
    }
}



