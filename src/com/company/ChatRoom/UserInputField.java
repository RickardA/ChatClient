package com.company.ChatRoom;

import com.company.Message;
import com.company.NetworkClient;
import javafx.scene.Parent;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class UserInputField {
    //Some variables might be needed
    private boolean stopTyping = false;
    private Thread updateChannelThread;
    private String channelName;


    public UserInputField(String channelName) {
        this.channelName = channelName;
        updateChannelThread = new Thread(this::getTextFromInput);
        updateChannelThread.start();
    }

    public void getTextFromInput() {
        System.out.println("Welcome to the " + channelName + " channel, please input your messages below!");
        while (!stopTyping) {

            String message;
            Scanner userInput = new Scanner(System.in);
            message = userInput.nextLine();
            createMessage(message);
            if (message.equals("stop")) {
                stopTyping = true;
            }
        }
    }

    public void createMessage(String message) {
        //Here we should create an object of message to send
        // Alternative format "yyyyMMdd_HHmmss"
        String timeStamp = new SimpleDateFormat("yy-MM-dd HH:mm").format(Calendar.getInstance().getTime());
        Message messageObject = new Message(message, "19234212313", timeStamp);
        sendMessageToServer(messageObject);
    }

    public void sendMessageToServer(Message message) {

        //Should take in a Message object instead of string
        //But for test purposes we do this :)
        //System.out.println("Sending message to server");
        NetworkClient.get().sendObjectToServer(message);

    }
}
