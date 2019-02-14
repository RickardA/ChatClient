package com.company.ChatRooms;

import java.util.ArrayList;

public class ChatRoomList {
    private ArrayList<ChatRoom> chatRoomList;
    private static ChatRoomList _singleton = new ChatRoomList();


    public ChatRoomList() {
        chatRoomList = new ArrayList<>();
    }

    public static ChatRoomList get() {
        return _singleton;
    }

    public ArrayList<ChatRoom> getChatRooms() {
        return chatRoomList;
    }

    public void displayChatRooms() {

    }

    public void updateChatRoomList (ArrayList<ChatRoom> chatRoomList) {
        this.chatRoomList = chatRoomList;
    }
}
