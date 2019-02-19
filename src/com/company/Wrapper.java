package com.company;

import com.company.ChatRooms.ChatRoom;
import com.company.ChatRooms.ChatRoomList;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Wrapper implements Serializable {
    private Map<String,String> chatRoomOptions = new HashMap<>();
    private String chatRoomID;
    static final long serialVersionUID = 80;

    public Wrapper() {
    }

    public Wrapper(Map<String, String> chatRoomOptions) {
        this.chatRoomOptions = chatRoomOptions;
    }

    public Wrapper (String chatRoomID){
        this.chatRoomID = chatRoomID;
    }

    public Map<String, String> getChatRoomOptions() {
        return chatRoomOptions;
    }
}