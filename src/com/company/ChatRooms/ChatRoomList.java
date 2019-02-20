package com.company.ChatRooms;

import com.company.NetworkClient;
import com.company.User;
import com.company.Wrapper;

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
        for (Map.Entry<String, String> chatRoom : this.chatRoomList.entrySet()) {
            if (chatRoom.getValue().matches(nameOfRoom)) {
                user.setChannelID(chatRoom.getKey());
                NetworkClient.get().sendObjectToServer(new Wrapper(chatRoom.getKey(),user));
                break;
            }
        }
    }
}