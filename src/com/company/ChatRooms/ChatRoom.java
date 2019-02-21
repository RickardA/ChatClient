package com.company.ChatRooms;

import com.company.*;

import java.io.Serializable;
import java.util.ArrayList;

public class ChatRoom implements Serializable {
    private String uniqeID;
    private String name;
    private ArrayList<User> usersInChatRooom;
    private MessageList chatHistory;
    private ChatOutputField chatOutputField;
    static final long serialVersionUID = 20;


    public ChatRoom(String name, String id) {
        this.name = name;
        this.uniqeID = id;
        usersInChatRooom = new ArrayList<>();
        chatHistory = new MessageList();
    }

    public void show(){
        new Thread(chatOutputField = new ChatOutputField(chatHistory)).start();
    }
    public void updateChatHistory(Message message){
        chatHistory.setMessagesList(message);
        chatOutputField.UpdateChatMessages(chatHistory);
    }

    public String getUniqeID() {
        return uniqeID;
    }
}
