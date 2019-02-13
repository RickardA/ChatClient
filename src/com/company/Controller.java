package com.company;

public class Controller {
    ViewController viewController;

    public Controller(){

    }

    public void startClient(){
       NetworkClient.get();
       viewController = new ViewController();
    }
}
