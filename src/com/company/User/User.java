package com.company.User;

import java.io.Serializable;
import java.net.SocketAddress;

public class User implements Serializable {

    static final long serialVersionUID = 12;
    private String userName;
    private String userID;
    private String channelID;
    private SocketAddress userSocketAddress;


    public User() {}

    public String getUserName() {
        return userName;
    }

    public String getChannelID() {
        return channelID;
    }
}


