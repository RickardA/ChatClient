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
    // Made it into singleton again for testing purpose.. change to static later (need help to not break code)
    private static ChatRoomList _singleton = new ChatRoomList();

    public ChatRoomList() {

    }

    public ChatRoomList(User user) {
        this.user = user;
        chatRoomList = new HashMap<String, String>();
    }


    public Map<String, String> getChatRooms() {
        return chatRoomList;
    }

    // temporary until I figure out how to make it static without breaking code below
    public static ChatRoomList get() {
        return _singleton;
    }

    public void updateChatRoomList(Map<String, String> chatRoomList) {
        this.chatRoomList = chatRoomList;
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                for(String room : chatRoomList.values()) {
                    Main.controller.channels.getItems().add(room);
                }
            }
        });
        getChosenChatRoom("General");
    }

    public void getChosenChatRoom(String nameOfRoom) {
        for (Map.Entry<String, String> chatRoom : this.chatRoomList.entrySet()) {
            if (chatRoom.getValue().matches(nameOfRoom)) {
                user.setChannelID(chatRoom.getKey());
                NetworkClient.get().sendObjectToServer(new Wrapper(chatRoom.getKey(), user));
                break;
            }
        }
    }
}