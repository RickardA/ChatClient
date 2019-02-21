package com.company;

import java.io.Serializable;

public class UserSignUp implements Serializable {
    private String userName, password;

    public UserSignUp(String userName){
        this.userName= userName;
        //this.password= password;
    }
    public String getUserName() {
        return userName;
    }
}
