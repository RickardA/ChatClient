package sample.ChatRoom;

import java.util.ArrayList;

public class ChatRoom {
    private String uniqeID;
    private ArrayList<Object> usersInChatRooom;
    private ArrayList<Object> chattHistory;
    private UsersOnlineList usersOnlineList;
    private ChatRoomList chatRoomList;
    private ChatOutputField chatRoomOutputField;
    private UserInputField userInputField;

    public ChatRoom(){
        usersInChatRooom = new ArrayList<>();
        chattHistory = new ArrayList<>();
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
