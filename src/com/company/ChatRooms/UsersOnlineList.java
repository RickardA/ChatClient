package com.company.ChatRooms;

import com.company.User.User;

import java.util.ArrayList;

public class UsersOnlineList {
    private ArrayList<User> usersOnlineList = new ArrayList<>();

    public UsersOnlineList() {

    }

    public ArrayList<User> getUsersOnlineList() {
        return usersOnlineList;
    }

    public void addUser(User userToAdd) {
        this.usersOnlineList.add(userToAdd);
    }
}
