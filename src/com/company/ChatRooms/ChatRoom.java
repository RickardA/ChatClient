package com.company.ChatRooms;

import com.company.*;
import javafx.application.Platform;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class ChatRoom implements Serializable {
    private String uniqeID;
    private String name;
    private ArrayList<User> usersInChatRoom = new ArrayList<>();
    private MessageList chatHistory;
    private ChatOutputField chatOutputField;
    static final long serialVersionUID = 20;

    public ChatRoom() {
        updateUsersInChatRoom();
    }

    public ChatRoom(String name, String id) {
        this.name = name;
        this.uniqeID = id;
        usersInChatRoom = new ArrayList<>();
        chatHistory = new MessageList();
    }

    public void show() {
        new Thread(chatOutputField = new ChatOutputField(chatHistory)).start();
    }

    public void updateChatHistory(Message message) {
        chatHistory.setMessagesList(message);
        chatOutputField.UpdateChatMessages(chatHistory);
    }

    public void updateUsersInChatRoom() {
        System.out.println(usersInChatRoom);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                for (User user : usersInChatRoom) {
                    Main.controller.userBox.getItems().add(user.getUserName());
                }
            }
        });
    }

    public String getUniqeID() {
        return uniqeID;
    }
}
