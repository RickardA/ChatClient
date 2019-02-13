package sample;

import java.util.UUID;

public class User {

    private String userName;
    private String userID;

    public User() {
        //Creates a uniqe id and sets it to userID;
        userID = UUID.randomUUID().toString();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
