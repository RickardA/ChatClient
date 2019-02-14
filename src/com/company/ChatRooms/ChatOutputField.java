package com.company.ChatRooms;

import com.company.Message;
import com.company.NetworkClient;

import java.util.ArrayList;

public class ChatOutputField {
    private ArrayList<Message> messages;
    private Thread myListeningThread;

    public ChatOutputField() {
        messages = new ArrayList<>();
        myListeningThread = new Thread(() -> {
            while (true) {
                checkClientIncomingMessages();

                // Without this 1 CPU core will constantly be at 100%
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    break;
                }
            }
        });
        myListeningThread.start();
    }

    public void getChatMessages() {

    }

    public void displayChatMessages() {

    }

    private void checkClientIncomingMessages() {
        var clientMsg = NetworkClient.get().pollMessage();
        if (clientMsg != null) {
            if (clientMsg instanceof Message) {
            messages = (ArrayList<Message>) clientMsg;

            System.out.println("The chat history is:");
            messages.stream()
                    //.peek((Message::getTimeStamp))
                    .forEach(Message::getMessage);
            //System.out.println("Client recieved the Message: " + clientMsg.getMessage() + " from the server");
            }
        }
    }

}
