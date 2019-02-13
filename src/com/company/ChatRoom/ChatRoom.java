package com.company.ChatRoom;

import java.util.ArrayList;

public class ChatRoom {
    private String uniqeID;
    private String name;
    private ArrayList<Object> usersInChatRooom;
    private ArrayList<Object> chattHistory;
    private UsersOnlineList usersOnlineList;
    private ChatRoomList chatRoomList;
    private ChatOutputField chatRoomOutputField;
    private UserInputField userInputField;

    public ChatRoom(String name){
        usersInChatRooom = new ArrayList<>();
        userInputField = new UserInputField();
        chatRoomOutputField = new ChatOutputField();
        chattHistory = new ArrayList<>();
        this.name = name;
    }

    public void addUserToChatRoom(Object user){

    }

    public void removeUserFromChatRoom(Object user){

    }

    public void checkUsersInChatRoom(){

    }

    public void addMessage(){

    }
}
