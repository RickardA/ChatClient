package com.company;

import java.io.Serializable;

public class UserSignUp implements Serializable {
    private String userName, password;

    public UserSignUp(String userName, String password){
        this.userName= userName;
        this.password= password;
    }

    public void setUserName(){
        ClientProgram.get().getUser().setUserName(this.userName);
    }

    public String getUserName() {
        return userName;
    }
}
