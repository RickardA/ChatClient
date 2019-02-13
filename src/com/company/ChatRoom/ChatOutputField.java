package com.company.ChatRoom;

import com.company.Message;
import com.company.NetworkClient;

import java.net.SocketAddress;
import java.util.ArrayList;

public class ChatOutputField {
    private ArrayList<Message> messages;
    private Thread myListeningThread;

    public ChatOutputField() {
        messages = new ArrayList<Message>();
        myListeningThread = new Thread(()->{
            while(true) {
                checkClientIncomingMessages();

                // Without this 1 CPU core will constantly be at 100%
                try { Thread.sleep(1); }
                catch (Exception e) { break; }
            }
        });
        myListeningThread.start();
    }

    public void getChatMessages(){

    }

    public void displayChatMessages(){

    }

    private void checkClientIncomingMessages(){
        var clientMsg = (Message)NetworkClient.get().pollMessage();
        if (clientMsg  != null) {
            if (clientMsg instanceof Message) {
                System.out.println("Client recieved the Message: " + clientMsg.getMessage() + " from the server");
            } else {
                System.out.println("Client recieved some string: " + clientMsg.toString() + " from the server");
            }
        }
    }
}
