package com.company;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Wrapper implements Serializable {
    private Map<String,String> chatRoomOptions = new HashMap<>();
    private String chatRoomID;
    private User user;
    static final long serialVersionUID = 80;

    public Wrapper() {
    }

    public Wrapper(Map<String, String> chatRoomOptions) {
        this.chatRoomOptions = chatRoomOptions;
    }

    public Wrapper (String chatRoomID,User user){
        this.user = user;
        this.chatRoomID = chatRoomID;
    }

    public User getUser(){
        return user;
    }

    public Map<String, String> getChatRoomOptions() {
        return chatRoomOptions;
    }
}