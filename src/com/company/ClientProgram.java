package com.company;

import com.company.ChatRooms.ChatRoom;
import com.company.ChatRooms.ChatRoomList;

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
                if (serverResponse instanceof ChatRoomList) {
                    System.out.println(((ChatRoomList) serverResponse).getChatRooms().size());
                    ChatRoomList.get().updateChatRoomList(((ChatRoomList) serverResponse).getChatRooms());
                } else if (serverResponse instanceof Message) {
                    ChatRoomList.get().getChatRooms().get(0).updateChatHistory(((Message) serverResponse));
                }else if (serverResponse instanceof Wrapper){
                    System.out.println("Wrapper recieved ");
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

    private void showChoosenChatRoom(String chatRoomID) {
        ChatRoom chatRoom = ChatRoomList.get().getChatRooms().get("1");
        chatRoom.show();
    }

    private void sendUserJoinedChatRoomToServer() {
        System.out.println("Sending to server... User " + NetworkClient.get().getSocketAdress() + " joined the channel "
                + ChatRoomList.get().getChatRooms().get(0).getUniqeID());
        NetworkClient.get().sendObjectToServer( ChatRoomList.get().getChatRooms().get(0).getUniqeID());
    }
}