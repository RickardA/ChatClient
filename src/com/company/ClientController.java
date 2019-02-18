package com.company;

public class ClientController {
    ClientProgram clientProgram;


    public ClientController(Controller controller){
        NetworkClient.get().declareController(controller);
    }

    public void startClient(){
       NetworkClient.get();
       User test = new User("Test");
       test.setUserSocketAddress();
       NetworkClient.get().sendObjectToServer(test);
       clientProgram = new ClientProgram();
    }
}
