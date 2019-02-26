package com.company.ChatRooms;

import com.company.Main;
import com.company.NetworkClient;
import com.company.User.User;
import javafx.application.Platform;
import com.company.MessageSendingClasses.chatRoomIDMessage;

import java.io.Serializable;
import java.util.*;

public class ChatRoomList implements Serializable {
    private Map<String, String> chatRoomList;
    private User user;
    static final long serialVersionUID = 30;
    private static ChatRoomList _singleton = new ChatRoomList();


    public ChatRoomList() {
        chatRoomList = new HashMap<>();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<String, String> getChatRooms() {
        return chatRoomList;
    }

    public static ChatRoomList get() {
        return _singleton;
    }

    public void updateChatRoomList(Map<String, String> chatRoomList) {
        this.chatRoomList = chatRoomList;
        Platform.runLater(() -> {
            for (String room : chatRoomList.values()) {
                Main.controller.channels.getItems().add(room);
            }
        });
    }

    public void getChosenChatRoom(String nameOfRoom) {
        for (Map.Entry<String, String> chatRoom : this.chatRoomList.entrySet()) {
            if (chatRoom.getValue().matches(nameOfRoom)) {
                user.setChannelID(chatRoom.getKey());
                NetworkClient.get().sendObjectToServer(new chatRoomIDMessage(chatRoom.getKey(), user));
                break;
            }
        }
    }
}