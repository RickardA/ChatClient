package com.company;

public class Controller {
    ClientProgram clientProgram;

    public Controller(){

    }

    public void startClient(){
       NetworkClient.get();
       User test = new User("TestUser");
       test.setUserSocketAddress();
       NetworkClient.get().sendObjectToServer(test);
       clientProgram = new ClientProgram();
    }
}
