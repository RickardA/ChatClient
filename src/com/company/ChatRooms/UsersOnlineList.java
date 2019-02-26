package com.company.ChatRooms;

import com.company.Main;
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
            for (Map.Entry<String, User> user : usersOnlineList.entrySet()) {
                Main.controller.userBox.getItems().add(user.getValue().getUserName());
            }
        });
    }


}
