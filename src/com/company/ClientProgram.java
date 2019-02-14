package com.company;
import com.company.ChatRooms.ChatRoom;
import com.company.ChatRooms.ChatRoomList;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientProgram {
    private StartPage startPage;
    private ChatRoomList chatRooms;
    private static ClientProgram _singelton = new ClientProgram();

    public ClientProgram() {}

    public void checkIncommingPackage() {
        var serverResponse = NetworkClient.get().pollMessage();
        if (serverResponse != null){
            if (serverResponse.getClass().getSimpleName().equals("ArrayList")) {
                System.out.println("Recieving chatRooms! (Array)");
                ChatRoomList.get().updateChatRoomList((ArrayList<ChatRoom>) serverResponse);
                userChooseChatRoom();
            }
            else if (serverResponse instanceof Message){
                System.out.println("Recieving message! (Object)");

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