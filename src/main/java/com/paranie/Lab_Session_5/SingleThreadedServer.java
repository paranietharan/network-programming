package com.paranie.Lab_Session_5;

import java.io.*;
import java.net.*;

public class SingleThreadedServer {
    public static void main(String[] args) throws IOException {
        final int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Single-Threaded Server started on port: " + port);
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println("Received: " + inputLine);
                        out.println(inputLine); // Echo the message back to the client
                    }
                }
            }
        }
    }
}

