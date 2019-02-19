package com.company.ChatRooms;

import com.company.NetworkClient;
import com.company.Wrapper;

import java.io.Serializable;
import java.util.*;

public class ChatRoomList implements Serializable {
    private Map<String, String> chatRoomList;
    private static ChatRoomList _singleton = new ChatRoomList();
    static final long serialVersionUID = 30;

    public ChatRoomList() {
        chatRoomList = new HashMap<String, String>();
    }

    public static ChatRoomList get() {
        return _singleton;
    }

    public Map<String, String> getChatRooms() {
        return chatRoomList;
    }

    public void displayChatRooms() {
    }

    public void updateChatRoomList(Map<String, String> chatRoomList) {
        this.chatRoomList = chatRoomList;
        int index = 0;
        System.out.println("These are the chatRooms to choose from, type the name of the room you want");
        for (Map.Entry<String, String> chatRoom : this.chatRoomList.entrySet()) {
            System.out.println(index + ":" + chatRoom.getValue());
            index++;
        }
        Scanner scanner = new Scanner(System.in);
        String choosen = scanner.nextLine();
        getChoosenChatRoom(choosen);
    }

    public void getChoosenChatRoom(String nameOfRoom) {
        String key;
        for (Map.Entry<String, String> chatRoom : this.chatRoomList.entrySet()) {
            if (chatRoom.getValue().matches(nameOfRoom)) {
                NetworkClient.get().sendObjectToServer(new Wrapper(chatRoom.getKey()));
                break;
            }
        }
    }
}