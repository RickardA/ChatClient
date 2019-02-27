package com.company.Message;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.company.ClientProgram.getLoggedInUser;

public class Message implements Serializable {

    private String message;
    private String senderName;
    private String timeStamp;
    private String channelID;
    static final long serialVersionUID = 50;


    public Message(String message,String channelID) {
        this.message = message;
        this.senderName = getLoggedInUser().getUserName();
        this.timeStamp = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
        this.channelID = channelID;
    }

    public String getMessage() {
        return message;
    }


    public String getSenderName() {
        return senderName;
    }


    public String getTimeStamp() {
        return timeStamp;
    }
}
