package com.company.ChatRooms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ChatRoomList implements Serializable {
    private Map<String,String> chatRoomList;
    private static ChatRoomList _singleton = new ChatRoomList();
    static final long serialVersionUID = 30;

    public ChatRoomList() {
        chatRoomList = new HashMap<String,String>();
    }

    public static ChatRoomList get() {
        return _singleton;
    }

    public Map<String, String> getChatRooms() {
        return chatRoomList;
    }

    public void displayChatRooms() {

    }
    public void updateChatRoomList (Map<String,String> chatRoomList) {
        this.chatRoomList = chatRoomList;
        //here will Mathias + Chan countine erite code
    }
}
