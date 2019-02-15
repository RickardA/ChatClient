package com.company;
import com.company.ChatRooms.ChatRoom;
import com.company.ChatRooms.ChatRoomList;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientProgram{
    private StartPage startPage;
    private static ClientProgram _singelton = new ClientProgram();

    public ClientProgram() {
        Thread incommingPackage = new Thread(this :: checkIncommingPackage);
        incommingPackage.setDaemon(true);
        incommingPackage.start();
    }


    public void checkIncommingPackage() {
        while (true) {
            var serverResponse = NetworkClient.get().pollMessage();
            if (serverResponse != null) {
                if (serverResponse instanceof ChatRoomList) {
                    System.out.println("Recieving chatRoomList! (Object)");
                    System.out.println(((ChatRoomList) serverResponse).getChatRooms().get(0).getName());
                    ChatRoomList.get().updateChatRoomList(((ChatRoomList) serverResponse).getChatRooms());
                    userChooseChatRoom();
                } else if (serverResponse instanceof MessageList) {
                    System.out.println("Recieving messageList! (Object)");
                    ChatRoomList.get().getChatRooms().get(0).updateChatHistory(((MessageList) serverResponse));
                }
            }
        }
    }

    public static ClientProgram get(){
        return _singelton;
    }

    private void userChooseChatRoom(){
        System.out.println("These are the chat rooms to choose from: " +
                "Type in the number of the chat rooms you want to connect to:");
        for (int i = 0; i < ChatRoomList.get().getChatRooms().size(); i++) {
            System.out.println(i + ": "+ChatRoomList.get().getChatRooms().get(i).getName());
        }
        Scanner scanner = new Scanner(System.in);
        int chooise = scanner.nextInt();
        showChoosenChatRoom(chooise);
    }

    private void showChoosenChatRoom(int index){
        ChatRoom chatRoom = ChatRoomList.get().getChatRooms().get(index);
        chatRoom.show();
    }
}