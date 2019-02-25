package com.company;

import com.company.ChatRooms.ChatRoom;
import com.company.ChatRooms.ChatRoomList;
import javafx.stage.WindowEvent;

import java.util.Map;

import static com.company.Main.primaryStage;

public class ClientProgram{
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

    private void checkIncommingPackage() {
        while (true) {
            var serverResponse = NetworkClient.get().pollMessage();
            if (serverResponse != null) {
                if (serverResponse instanceof ChatRoom) {
                    showChoosenChatRoom((ChatRoom)serverResponse);
                } else if (serverResponse instanceof Message) {
                    chatRoom.updateChatHistory((Message)serverResponse);
                }
                else if (serverResponse instanceof Wrapper){
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
        ChatRoomList chatRoomList = new ChatRoomList(user);
        chatRoomList.updateChatRoomList(chatRoomsList);
    }

    private void showChoosenChatRoom(ChatRoom chatRoomObject){
        this.chatRoom = chatRoomObject;
        this.chatRoom.show();
    }
}