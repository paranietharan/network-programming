package com.paranie.Lab_Session_5;

import java.io.*;
import java.net.*;

public class TCP_Client {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 8080;
        long startTime = System.currentTimeMillis();
        try {
            for (int i = 1; i <= 1000; i++) {
                Socket socket = new Socket(serverAddress, serverPort);
                PrintWriter out = new
                        PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new
                        InputStreamReader(socket.getInputStream()));
                String message = "Message " + i;
                out.println(message); // Send a message
                String response = in.readLine(); // Receive server
                System.out.println("Server response: " + response);
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total time for 1000 requests: " + (endTime -
                startTime) + " ms");
    }
}