package com.company;

import com.company.ChatRooms.ChatRoom;
import com.company.ChatRooms.ChatRoomList;

import java.util.Map;

public class ClientProgram {
    private StartPage startPage;
    private static ClientProgram _singelton = new ClientProgram();
    private ChatRoom chatRoom;
    private User user;


    public ClientProgram() {
        NetworkClient.get();
        user = new User("TestUser");
        user.setUserSocketAddress();
        NetworkClient.get().sendObjectToServer(user);

        Thread incommingPackage = new Thread(this::checkIncommingPackage);
        incommingPackage.setDaemon(true);
        incommingPackage.start();
    }


    public void checkIncommingPackage() {
        while (true) {
            var serverResponse = NetworkClient.get().pollMessage();
            if (serverResponse != null) {
                if (serverResponse instanceof ChatRoom) {
                    System.out.println(((ChatRoom) serverResponse).getUniqeID());
                    showChoosenChatRoom((ChatRoom) serverResponse);
                    // only works here... why? It should work below :>
                    updateUsersInRoom();
                } else if (serverResponse instanceof User) {
                } else if (serverResponse instanceof Message) {
                    chatRoom.updateChatHistory((Message) serverResponse);
                } else if (serverResponse instanceof Wrapper) {
                    updateChatRoomList(((Wrapper) serverResponse).getChatRoomOptions());
                }
            }
        }
    }

    public User getUser() {
        return user;
    }

    public static ClientProgram get() {
        return _singelton;
    }

    private void updateUsersInRoom() {
        this.chatRoom.updateUsersInChatRoom();
    }

    private void updateChatRoomList(Map<String, String> chatRoomsList) {
        ChatRoomList.get().setUser(user);
        ChatRoomList.get().updateChatRoomList(chatRoomsList);
    }

    private void showChoosenChatRoom(ChatRoom chatRoomObject) {
        this.chatRoom = chatRoomObject;
        this.chatRoom.show();
    }


}