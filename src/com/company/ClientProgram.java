package com.company;

import com.company.ChatRooms.ChatRoom;
import com.company.ChatRooms.ChatRoomList;

import java.util.Map;

public class ClientProgram{
    private StartPage startPage;
    private static ClientProgram _singelton = new ClientProgram();
    User user;


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
                    System.out.println("ChatRoom recivied: "+ serverResponse);
                    showChoosenChatRoom((ChatRoom)serverResponse);
                } else if (serverResponse instanceof Message) {
                    //ChatRoomList.get().getChatRooms().get(0).updateChatHistory(((Message) serverResponse));
                }else if (serverResponse instanceof Wrapper){
                    System.out.println("Wrapper recieved ");
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

    private void updateChatRoomList(Map<String, String> chatRoomsList){
        ChatRoomList chatRoomList = new ChatRoomList();
        chatRoomList.updateChatRoomList(chatRoomsList);
    }

    private void showChoosenChatRoom(ChatRoom chatRoomObject){
        ChatRoom chatRoom = chatRoomObject;
        chatRoom.show();
    }
}