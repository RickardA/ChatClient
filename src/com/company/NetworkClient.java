package com.company;

import java.io.*;
import java.net.*;
import java.util.concurrent.LinkedBlockingDeque;

public class NetworkClient {
    private final String SERVER_IP = "127.0.0.1";
    private final int SERVER_PORT = 8080;
    private final int MSG_SIZE = 1000000;

    private DatagramSocket socket;

    private LinkedBlockingDeque<Object> msgQueue = new LinkedBlockingDeque<>();
    private static NetworkClient _singleton = new NetworkClient();

    private NetworkClient() {
        try {
            socket = new DatagramSocket(0);
            socket.connect(InetAddress.getByName(SERVER_IP), SERVER_PORT);
            socket.setSoTimeout(100);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Thread t = new Thread(this::loop);
        t.setDaemon(true);
        t.start();
    }

    public static NetworkClient get() {
        return _singleton;
    }

    public Object pollMessage() {
        return msgQueue.pollFirst();
    }

    public void sendObjectToServer(Serializable object) {
        System.out.println("Sending to server....");
        ByteArrayOutputStream byteArrayStream = new ByteArrayOutputStream();
        try (ObjectOutputStream out = new ObjectOutputStream(byteArrayStream)) {
            out.writeObject(object);
        } catch (Exception e) {
            e.printStackTrace();
        }

        DatagramPacket request = new DatagramPacket(byteArrayStream.toByteArray(), byteArrayStream.size());
        try {
            socket.send(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loop() {
        while (true) {
                DatagramPacket serverRequest = new DatagramPacket(new byte[MSG_SIZE], MSG_SIZE);

                if (!receiveMessageFromServer(serverRequest)) {
                    continue;
                }

            System.out.println(serverRequest.getLength());
                Object msg = deserializeRequest(serverRequest);
                msgQueue.addLast(msg);
        }
    }

    private boolean receiveMessageFromServer(DatagramPacket serverRequest) {
        try {
            socket.receive(serverRequest);
            return true;
        } catch (SocketTimeoutException e) { // Ignore timeout
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    private Object deserializeRequest(DatagramPacket serverRequest) {
        try {
            try (ByteArrayInputStream bin = new ByteArrayInputStream(serverRequest.getData())) {
                try (ObjectInputStream ois = new ObjectInputStream(bin)) {
                    return ois.readObject();
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public SocketAddress getSocketAdress(){
        return _singleton.socket.getLocalSocketAddress();
    }
}