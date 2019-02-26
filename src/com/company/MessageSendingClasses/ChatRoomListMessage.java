package com.company.MessageSendingClasses;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ChatRoomListMessage implements Serializable {
    static final long serialVersionUID = 180;

    private Map<String,String> chatRoomOptions = new HashMap<>();

    public ChatRoomListMessage(Map<String, String> chatRoomOptions) {
        this.chatRoomOptions = chatRoomOptions;
    }

    public Map<String, String> getChatRoomOptions() {
        return chatRoomOptions;
    }

}
