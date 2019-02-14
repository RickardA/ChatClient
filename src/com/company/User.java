package com.company;

import java.io.Serializable;
import java.net.SocketAddress;
import java.util.UUID;

public class User implements Serializable {

    static final long serialVersionUID = 12;
    private String userName;
    /*  private String userID;*/
    private SocketAddress userSocketAddress;


    public User(String name) {
        //Creates a uniqe id and sets it to userID;
        userName = name;
        //userID = UUID.randomUUID().toString();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

   /* public String getUserID() {
        return userID;
    }*/
/*
    public void setUserID(String userID) {
        this.userID = userID;
    }*/

    public SocketAddress getUserSocketAddress() {
        return userSocketAddress;
    }

   public void setUserSocketAddress() {
        this.userSocketAddress = NetworkClient.get().getSocketAdress();
    }
}