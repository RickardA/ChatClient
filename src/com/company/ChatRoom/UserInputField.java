package com.company.ChatRoom;

import com.company.Message;
import com.company.NetworkClient;

import java.util.Scanner;

public class UserInputField{
    //Some variables might be needed


    public UserInputField() {
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
        Message messageObject = new Message(message,"19234212313","2019-02-13 19:23:12");
        sendMessage(messageObject);
    }

    public void sendMessage(Message message){
        //Should take in a Message object instead of string
        //But for test purposes we do this :)
        System.out.println("Sending message to server");
        NetworkClient.get().sendObjectToServer(message);
    }
}
