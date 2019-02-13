package com.company;

import com.company.ChatRoom.ChatRoom;

public class ViewController {
    private StartPage startPage;
    private ChatRoom chatRoom;

    public ViewController() {
        //startPage = new StartPage();
        chatRoom = new ChatRoom("General");
    }

    public void changeView(){
        //Call method primarystage.show and show startpage / chatroom
    }
}
