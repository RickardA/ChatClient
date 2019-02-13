package com.company.ChatRoom;

import com.company.Message;
import com.company.User;

import java.util.ArrayList;

public class ChatRoom {
    private String uniqeID;
    private String name;
    private ArrayList<User> usersInChatRooom;
    private ArrayList<Message> chatHistory;
    private UsersOnlineList usersOnlineList;
    private ChatRoomList chatRoomList;
    private ChatOutputField chatRoomOutputField;
    private UserInputField userInputField;

    public ChatRoom(String name){
        this.name = name;
        usersInChatRooom = new ArrayList<>();
        userInputField = new UserInputField(name);
        chatRoomOutputField = new ChatOutputField();
        chatHistory = new ArrayList<>();
    }

    public void addUserToChatRoom(ArrayList<User> user){

    }

    public void removeUserFromChatRoom(ArrayList<User> user){

    }

    public void checkUsersInChatRoom(){

    }

    public void addMessage(){

    }
}
