package com.company.ChatRooms;

import com.company.Main;
import com.company.MessageList;
import javafx.application.Platform;

public class ChatOutputField implements Runnable{
    private MessageList messages;
    private Thread myListeningThread;

    public ChatOutputField(MessageList chatHistory) {
        messages = chatHistory;
        showMessages();
    }

    @Override
    public void run() {

    }

    public void getChatMessages() {

    }

    public void UpdateChatMessages(MessageList messageList) {
        messages = messageList;
        showMessages();
    }

    private void showMessages() {



            if (messages.getMessagesList().isEmpty())
            {
                Platform.runLater(()-> Main.controller.recieveMessage("No server history..."));
            }
            else
            {
                Main.controller.outputbox.clear();
                Platform.runLater(new Runnable() {
                    @Override public void run() {
                        for (int i = 0; i < messages.getMessagesList().size(); i++) {
                            Main.controller.recieveMessage(messages.getMessagesList().get(i).getSenderID() + " " + messages.getMessagesList().get(i).getTimeStamp() + "   " + messages.getMessagesList().get(i).getMessage());
                        }

                    }
                });

            }
    }
}

