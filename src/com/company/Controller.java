package com.company;

import com.company.ChatRooms.UserInputField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;



public class Controller implements Initializable {


    @FXML
    public TextArea inputbox, outputbox; // userbox, inputbutton


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //get and print user list
//get and print chat history
        outputbox.appendText("History goes here...");
//        ChatRoom chatRoom = new ChatRoom();
    }

    @FXML
    public void sendMessage(ActionEvent event) {

        UserInputField userInputField = new UserInputField();

        userInputField.createMessage(inputbox.getText());
        inputbox.clear();

    }

    public void recieveMessage(ActionEvent event) {


        System.out.println("message got back");
//        startTask();                                               1

    }

//    @FXML
//    public void recieveMessage(String messageBack) {
//
//        Platform.runLater(new Runnable(){
//            @Override
//            public void run() {
//
//                outputbox.appendText("hejhej");
//
//            }
//        });


//        System.out.println(messageBack + "message got back");
//        outputbox.appendText(messageBack);
//
//
//    }




//    public void startTask()
//    {
//        // Create a Runnable
//        Runnable task = new Runnable()
//        {
//            public void run()
//            {
//                runTask();
//            }
//        };
//
//        // Run the task in a background thread
//        Thread backgroundThread = new Thread(task);
//        // Terminate the running thread if the application exits
//        backgroundThread.setDaemon(true);
//        // Start the thread
//        backgroundThread.start();
//    }
//
//    public void runTask()
//    {
//        for(int i = 1; i <= 10; i++)
//        {
//            try
//            {
//                // Get the Status
//                final String status = "Processing " + i + " of " + 10;
//
//                // Update the Label on the JavaFx Application Thread
//                Platform.runLater(new Runnable()
//                {
//                    @Override
//                    public void run()
//                    {
//                        outputbox.setText("ok, a start");
//                    }
//                });
//
//                textArea.appendText(status+"\n");
//
//                Thread.sleep(1000);
//            }
//            catch (InterruptedException e)
//            {
//                e.printStackTrace();
//            }
//        }
//    }
//


}
