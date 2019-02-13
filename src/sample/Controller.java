package sample;

public class Controller {
    NetworkClient client;

    public Controller(){
    }

    public void startClient(){
        new Thread(new NetworkClient()).start();
    }
}
