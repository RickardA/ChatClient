package sample;

import sample.ChatRoom.ChatRoom;

public class ViewController {
    StartPage startPage;
    ChatRoom chatRoom;

    public ViewController(NetworkClient client) {
        startPage = new StartPage();
        chatRoom = new ChatRoom("General",client);
    }

    public void changeView(){
        //Call method primarystage.show and show startpage / chatroom
    }
}
