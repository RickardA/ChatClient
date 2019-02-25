package com.company.ChatRooms;

import com.company.*;
import com.company.Message.Message;
import com.company.Message.MessageList;
import com.company.User.User;
import javafx.application.Platform;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ChatRoom implements Serializable {
    private String uniqeID;
    private String name;
    private Map<String, User> usersInChatRooom;
    private MessageList chatHistory;
    private ChatOutputField chatOutputField;
    static final long serialVersionUID = 20;

    public ChatRoom() {
        updateUsersInChatRoom();
    }

    public ChatRoom(String name, String id) {
        this.name = name;
        this.uniqeID = id;
        usersInChatRooom = new HashMap<>();
        chatHistory = new MessageList();
    }

    public void show(){
        new Thread(chatOutputField = new ChatOutputField(chatHistory)).start();
    }
    public void updateChatHistory(Message message){
        chatHistory.setMessagesList(message);
        chatOutputField.UpdateChatMessages(chatHistory);
    }

    public void updateUsersInChatRoom() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                for (Map.Entry<String, User> user : usersInChatRooom.entrySet()) {
                    Main.controller.userBox.getItems().add(user.getValue().getUserName());
                }
            }
        });
    }

    public String getUniqeID() {
        return uniqeID;
    }
}
