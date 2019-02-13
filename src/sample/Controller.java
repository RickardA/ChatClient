package sample;

import sample.ChatRoom.ChatRoom;

public class Controller {
    NetworkClient client;
    ViewController viewController;

    public Controller(){
        client = new NetworkClient();
    }

    public void startClient(){
       new Thread(client).start();
       viewController = new ViewController(client);
    }
}
