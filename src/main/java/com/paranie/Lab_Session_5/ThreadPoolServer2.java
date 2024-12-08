package com.paranie.Lab_Session_5;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class ThreadPoolServer2 {
    public static void main(String[] args) throws IOException {
        final int port = 8080;
        ExecutorService threadPool = Executors.newFixedThreadPool(2); // Thread pool of size 2

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Thread Pool Server (Size 2) started on port: " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                threadPool.submit(() -> handleClient(clientSocket));
            }
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                out.println(inputLine); // Echo the message back to the client
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

