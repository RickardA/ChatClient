package com.company.ChatRooms;

import com.company.*;

import java.beans.Transient;
import java.io.Serializable;
import java.net.SocketAddress;
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
        new Thread(new UserInputField()).start();
    }
    public void updateChatHistory(MessageList messageList){
        chatHistory = messageList;
        chatOutputField.UpdateChatMessages(chatHistory);
    }

    private void addUserToChatRoom(User user) {
        usersInChatRooom.add(user);
    }

    private void removeUserFromChatRoom(User user) {
        usersInChatRooom.remove(user);
    }

    private void checkUsersInChatRoom() {   }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
