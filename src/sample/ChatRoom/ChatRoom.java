package sample.ChatRoom;

import sample.NetworkClient;

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

    public ChatRoom(String name, NetworkClient client){
        usersInChatRooom = new ArrayList<>();
        userInputField = new UserInputField(client);
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
