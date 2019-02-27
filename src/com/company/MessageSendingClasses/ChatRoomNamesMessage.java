package com.company.MessageSendingClasses;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ChatRoomNamesMessage implements Serializable {
    static final long serialVersionUID = 180;

    private Map<String,String> chatRoomNames = new HashMap<>();

    public ChatRoomNamesMessage(Map<String, String> chatRoomNames) {
        this.chatRoomNames = chatRoomNames;
    }

    public Map<String, String> getChatRoomNames() {
        return chatRoomNames;
    }

}
