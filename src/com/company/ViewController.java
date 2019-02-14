package com.company;

import com.company.ChatRoom.ChatRoom;
import com.company.ChatRoom.ChatRoomList;

import java.util.ArrayList;

public class ViewController {
    private StartPage startPage;
    private ChatRoomList chatRooms;

    public ViewController() {
        //startPage = new StartPage();
        Thread myListeningThread = new Thread(() -> {
            while (true) {
                getChatRoomsFromServer();

                // Without this 1 CPU core will constantly be at 100%
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    break;
                }
            }
        });
        myListeningThread.start();
        Thread getChatRoomThread = new Thread(() -> {
            ChatRoom chatRoom = ChatRoomList.get().getChatRooms().get(0);
        });
        getChatRoomThread.start();
    }

    private void getChatRoomsFromServer() {
        var serverResponse = NetworkClient.get().pollMessage();
        System.out.println(serverResponse);
        if (serverResponse != null) {
            if (serverResponse instanceof ChatRoom) {
                ChatRoomList.get().updateChatRoomList((ArrayList<ChatRoom>) serverResponse);
            }
        }
    }

    public void changeView() {
        //Call method primarystage.show and show startpage / chatroom
    }
}
