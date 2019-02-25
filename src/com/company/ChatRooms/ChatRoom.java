package com.company.ChatRooms;

import com.company.Message.Message;
import com.company.Message.MessageList;
import java.io.Serializable;

public class ChatRoom implements Serializable {
    private String uniqeID;
    private String name;
    private UsersOnlineList usersOnlineList;
    private MessageList chatHistory;
    private ChatOutputField chatOutputField;
    static final long serialVersionUID = 20;

    public ChatRoom(String name, String id) {
        this.name = name;
        this.uniqeID = id;
        this.usersOnlineList = new UsersOnlineList();
        chatHistory = new MessageList();

    }

    public void show(){
        new Thread(chatOutputField = new ChatOutputField(chatHistory)).start();
    }
    public void updateChatHistory(Message message){
        chatHistory.setMessagesList(message);
        chatOutputField.UpdateChatMessages(chatHistory);
    }

    public String getUniqeID() {
        return uniqeID;
    }

    public UsersOnlineList getUsersOnlineList() {
        return usersOnlineList;
    }
}
