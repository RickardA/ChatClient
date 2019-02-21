/*package com.company.ChatRooms;

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
        Message messageObject = new Message(message);
        sendMessageToServer(messageObject);
    }

    public void sendMessageToServer(Message message) {
        NetworkClient.get().sendObjectToServer(message);
    }
}*/
