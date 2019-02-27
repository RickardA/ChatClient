package com.company.ChatRooms;

import com.company.ClientGUI;
import com.company.User.User;
import javafx.application.Platform;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UsersOnlineList implements Serializable {
    private Map<String, User> usersOnlineList;
    static final long serialVersionUID = 260;

    public UsersOnlineList() {
        usersOnlineList = new HashMap<>();
        updateUsersInChatRoom();
    }

    public void updateUsersInChatRoom() {
        Platform.runLater(() -> {
            ClientGUI.controller.userBox.getItems().clear();
            for (Map.Entry<String, User> user : usersOnlineList.entrySet()) {
                ClientGUI.controller.userBox.getItems().add(user.getValue().getUserName());
            }
        });
    }

    public void setUsersOnlineList(Map<String, User> usersOnlineList) {
        this.usersOnlineList = usersOnlineList;
        updateUsersInChatRoom();
    }

    public Map<String, User> getUsersOnlineList() {
        return usersOnlineList;
    }
}
