package com.company.ChatRooms;

import com.company.Message.MessageList;

import java.io.Serializable;

public class ChatRoom implements Serializable {
    private String uniqueID;
    private String name;
    private UsersOnlineList usersOnlineList;
    private MessageList chatHistory;
    private ChatOutputField chatOutputField;
    static final long serialVersionUID = 20;

    public ChatRoom(String name, String id) {
        this.name = name;
        this.uniqueID = id;
        this.usersOnlineList = new UsersOnlineList();
        chatHistory = new MessageList();

    }

    public void createChatOutputField(){
        new Thread(chatOutputField = new ChatOutputField(chatHistory)).start();
    }

    public UsersOnlineList getUsersOnlineList() {
        return usersOnlineList;
    }

    public ChatOutputField getChatOutputField() {
        return chatOutputField;
    }
}
