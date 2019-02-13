package com.company;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Message implements Serializable {

    private String message;
    private String senderID;
    private String timeStamp;

    public Message(String message, String senderID, String timeStamp) {
        this.message = message;
        this.senderID = senderID;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        System.out.println("User " + timeStamp + ": " + message);
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
