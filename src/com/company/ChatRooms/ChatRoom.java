package com.company.ChatRooms;

import com.company.Message;
import com.company.User;

import java.io.Serializable;
import java.util.ArrayList;

public class ChatRoom implements Serializable {
    private String uniqeID;
    private String name;
    private ArrayList<User> usersInChatRooom;
    private ArrayList<Message> chatHistory;
    private UsersOnlineList usersOnlineList;
    private ChatRoomList chatRoomList;
    private ChatOutputField chatRoomOutputField;
    private UserInputField userInputField;
    static final long serialVersionUID = 20;

    public ChatRoom(String name){
        this.name = name;
        usersInChatRooom = new ArrayList<>();
        userInputField = new UserInputField(name);
        chatRoomOutputField = new ChatOutputField();
        chatHistory = new ArrayList<>();
    }

    public void show(){
        System.out.println("Welcome to the group " + name);
        chatRoomOutputField.show();
    }

    public void addUserToChatRoom(ArrayList<User> user){

    }

    public void removeUserFromChatRoom(ArrayList<User> user){

    }

    public void checkUsersInChatRoom(){

    }

    public void addMessage(){

    }

    public String getName(){
        return name;
    }

}
