package com.company;

import com.company.ChatRooms.ChatRoom;
import com.company.ChatRooms.ChatRoomList;
import com.company.ChatRooms.UsersOnlineList;
import com.company.Message.Message;
import com.company.MessageSendingClasses.ChatRoomNamesMessage;
import com.company.MessageSendingClasses.ErrorMessage;
import com.company.User.User;
import javafx.application.Platform;

import java.util.Map;

public class ClientProgram {
    private ChatRoom chatRoom;
    private static User loggedInUser;
    private static ChatRoomList chatRoomList = new ChatRoomList();

    public ClientProgram() {
        NetworkClient.get();

        Thread incomingPackage = new Thread(this::checkIncomingPackage);
        incomingPackage.setDaemon(true);
        incomingPackage.start();
    }

    public static ChatRoomList getChatRoomList() {
        return chatRoomList;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
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
                } else if (serverResponse instanceof ChatRoomNamesMessage) {
                    updateChatRoomList(((ChatRoomNamesMessage) serverResponse).getChatRoomNames());
                } else if (serverResponse instanceof User) {
                    loggedInUser = (User) serverResponse;
                    Platform.runLater(ClientGUI::displayChatWindow);
                }else if (serverResponse instanceof ErrorMessage){
                    Platform.runLater(() -> ClientGUI.
                            controller.errorMessageBox
                            .setText(((ErrorMessage) serverResponse)
                                    .getErrorMessage()));
                }
            }
        }
    }

    private void updateUsersInRoom(UsersOnlineList usersOnlineList) {
        this.chatRoom.getUsersOnlineList().setUsersOnlineList(usersOnlineList.getUsersOnlineList());
    }

    private void updateChatRoomList(Map<String, String> chatRoomsList) {
        chatRoomList.updateChatRoomList(chatRoomsList);
    }

    private void showChosenChatRoom(ChatRoom chatRoomObject) {
        this.chatRoom = chatRoomObject;
        this.chatRoom.createChatOutputField();
        this.chatRoom.getUsersOnlineList().updateUsersInChatRoom();
    }
}