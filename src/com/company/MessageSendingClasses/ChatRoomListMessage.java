package com.company.MessageSendingClasses;

import java.util.HashMap;
import java.util.Map;

public class ChatRoomListMessage {
    private Map<String,String> chatRoomOptions = new HashMap<>();

    public ChatRoomListMessage(Map<String, String> chatRoomOptions) {
        this.chatRoomOptions = chatRoomOptions;
    }

    public Map<String, String> getChatRoomOptions() {
        return chatRoomOptions;
    }

}
