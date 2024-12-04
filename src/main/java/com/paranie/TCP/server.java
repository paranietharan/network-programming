package com.paranie.TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class server {
    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(8080);

            // Wait for client to connect
            //The accept() method blocks until a client attempts to connect to the server.
            // When a client connects, it returns a new Socket object that represents
            // the connection to that specific client.
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            // Receive data from client
            BufferedReader in = new BufferedReader(new
                    InputStreamReader(clientSocket.getInputStream()));
            String data = in.readLine();
            System.out.println("Client says: " + data);

            // Send data to client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Hello, Client!");

            // Close the socket
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
