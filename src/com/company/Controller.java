package com.company;

public class Controller {
    ViewController viewController;

    public Controller(){

    }

    public void startClient(){
        System.out.println("Pringing from controller");
       NetworkClient.get();
       User test = new User("Test");
       test.setUserSocketAddress();
       NetworkClient.get().sendObjectToServer(test);
       viewController = new ViewController();
    }
}
