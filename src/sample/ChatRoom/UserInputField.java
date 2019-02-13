package sample.ChatRoom;

import sample.Message;
import sample.NetworkClient;

import java.util.Scanner;

public class UserInputField {
    //Some variables might be needed
    NetworkClient client;

    public UserInputField(NetworkClient client) {
        this.client = client;
        getTextFromInput();
    }

    public void getTextFromInput(){
        String message;
        System.out.println("Please input your message");
        Scanner userInput = new Scanner(System.in);
        message = userInput.nextLine();
        createMessage(message);
    }

    public void createMessage(String message){
        //Here we should create an object of message to send
        sendMessage(message);
    }

    public void sendMessage(String message){
        //Should take in a Message object instead of string
        //But for test purposes we do this :)
        System.out.println("Sending message to server");
        try{
            client.sendMsgToServer(message);
        }catch (Exception e){

        }
    }
}
