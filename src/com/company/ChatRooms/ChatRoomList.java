package com.company.ChatRooms;

import com.company.Main;
import com.company.NetworkClient;
import com.company.User;
import com.company.Wrapper;
import javafx.application.Platform;

import java.io.Serializable;
import java.util.*;

public class ChatRoomList implements Serializable {
    private Map<String, String> chatRoomList;
    private User user;
    static final long serialVersionUID = 30;

    public ChatRoomList(User user) {
        this.user = user;
        chatRoomList = new HashMap<String, String>();
    }

    public Map<String, String> getChatRooms() {
        return chatRoomList;
    }

    public void updateChatRoomList(Map<String, String> chatRoomList) {
        this.chatRoomList = chatRoomList;
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                for(String room : chatRoomList.values()) {
                    Main.controller.userbox.getItems().add(room);
                    //System.out.println(room);
                }
            }
        });
    }

    public void getChoosenChatRoom(String nameOfRoom) {
        for (Map.Entry<String, String> chatRoom : this.chatRoomList.entrySet()) {
            if (chatRoom.getValue().matches(nameOfRoom)) {
                user.setChannelID(chatRoom.getKey());
                NetworkClient.get().sendObjectToServer(new Wrapper(chatRoom.getKey(), user));
                break;
            }
        }
    }
}