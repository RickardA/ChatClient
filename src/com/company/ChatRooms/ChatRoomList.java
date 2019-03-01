package com.company.ChatRooms;

import com.company.ClientGUI;
import com.company.MessageSendingClasses.ChosenChatRoomMessage;
import com.company.NetworkClient;
import javafx.application.Platform;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import static com.company.ClientProgram.getLoggedInUser;

public class ChatRoomList implements Serializable {
    private Map<String, String> chatRoomList;
    static final long serialVersionUID = 30;


    public ChatRoomList() {
        chatRoomList = new HashMap<>();
    }

    public void updateChatRoomList(Map<String, String> chatRoomList) {
        this.chatRoomList = chatRoomList;
        Platform.runLater(() -> {
            for (String room : chatRoomList.values()) {
                ClientGUI.controller.roomListBox.getItems().add(room);
            }
        });
    }

    public void getChosenChatRoom(String nameOfRoom) {
        for (Map.Entry<String, String> chatRoom : this.chatRoomList.entrySet()) {
            if (chatRoom.getValue().matches(nameOfRoom)) {
                NetworkClient.get().sendObjectToServer(new ChosenChatRoomMessage(chatRoom.getKey(), getLoggedInUser()));
                break;
            }
        }
    }
}