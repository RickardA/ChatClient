package com.company.ChatRooms;

import com.company.Message;
import com.company.NetworkClient;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class UserInputField implements Runnable{
    private boolean stopTyping = false;

    public UserInputField() {
        new Thread(this::getTextFromInput).start();
    }

    @Override
    public void run() {

    }

    public void getTextFromInput() {
        System.out.println("Please input your messages below!");
        while (!stopTyping) {
            String message;
            Scanner userInput = new Scanner(System.in);
            message = userInput.nextLine();
            System.out.println(message);
            createMessage(message);
            // debug purpose
            if (message.equals("stop")) {
                stopTyping = true;
            }
        }
    }

    public void createMessage(String message) {
        //Here we should create an object of message to send
        // Alternative format "yyyyMMdd_HHmmss"
        String timeStamp = new SimpleDateFormat("yy-MM-dd HH:mm").format(Calendar.getInstance().getTime());
        Message messageObject = new Message(message, "19234212313");
        sendMessageToServer(messageObject);
    }

    public void sendMessageToServer(Message message) {
        //System.out.println("Sending message object to server from user input field");
        //Should take in a Message object instead of string
        //But for test purposes we do this :)
        //System.out.println("Sending message to server");
        NetworkClient.get().sendObjectToServer(message);

    }
}
