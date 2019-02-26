package com.company;

import com.company.ChatRooms.ChatRoom;
import com.company.ChatRooms.ChatRoomList;
import com.company.ChatRooms.UsersOnlineList;
import com.company.Message.Message;
import com.company.MessageSendingClasses.ChatRoomListMessage;
import com.company.User.User;

import java.util.Map;

public class ClientProgram {
    private static ClientProgram _singleton = new ClientProgram();
    private ChatRoom chatRoom;
    private User user;


    public ClientProgram() {
        NetworkClient.get();
        user = new User("TestUser");
        user.setUserSocketAddress();
        NetworkClient.get().sendObjectToServer(user);

        Thread incomingPackage = new Thread(this::checkIncomingPackage);
        incomingPackage.setDaemon(true);
        incomingPackage.start();
    }

    private void checkIncomingPackage() {
        while (true) {
            var serverResponse = NetworkClient.get().pollMessage();
            if (serverResponse != null) {
                if (serverResponse instanceof ChatRoom) {
                    showChosenChatRoom((ChatRoom) serverResponse);
                } else if (serverResponse instanceof UsersOnlineList) {
                    updateUsersInRoom((UsersOnlineList) serverResponse);
                } else if (serverResponse instanceof Message) {
                    chatRoom.getChatOutputField().printMessage((Message) serverResponse);
                } else if (serverResponse instanceof ChatRoomListMessage) {
                    updateChatRoomList(((ChatRoomListMessage) serverResponse).getChatRoomOptions());
                } else if (serverResponse instanceof User) {
                    user = (User) serverResponse;
                }
            }
        }
    }

    public User getUser() {
        return user;
    }

    public static ClientProgram get() {
        return _singleton;
    }

    private void updateUsersInRoom(UsersOnlineList usersOnlineList) {
        this.chatRoom.getUsersOnlineList().setUsersOnlineList(usersOnlineList.getUsersOnlineList());
    }

    private void updateChatRoomList(Map<String, String> chatRoomsList) {
        ChatRoomList.get().setUser(user);
        ChatRoomList.get().updateChatRoomList(chatRoomsList);
    }

    private void showChosenChatRoom(ChatRoom chatRoomObject) {
        this.chatRoom = chatRoomObject;
        this.chatRoom.createChatOutputField();
        this.chatRoom.getUsersOnlineList().updateUsersInChatRoom();
    }
}