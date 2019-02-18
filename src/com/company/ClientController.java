package com.company;

public class ClientController {
    ClientProgram clientProgram;


    public ClientController(){

    }

    public void startClient(){
       NetworkClient.get();
       User test = new User("Test");
       test.setUserSocketAddress();
       NetworkClient.get().sendObjectToServer(test);
       clientProgram = new ClientProgram();
    }
}
