package com.paranie.Multithreading.TCP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadedTCP_Server {

    public static int COUNT = 0;

    public static void main(String[] args) {
        ExecutorService executor =
                Executors.newFixedThreadPool(5);

        try {
            ServerSocket serverSocket = new ServerSocket(8070);
            System.out.println("Server started at port 8070");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected!");

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        handleRequest(clientSocket);
                    }
                });

//                thread.start();
                executor.submit(thread);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket clientSocket) {
        BufferedReader in = null;

        try{
            in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream())
            );

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // read from client
            String clientMessage = in.readLine();
            System.out.println("Client received: " + clientMessage);

            int number = Integer.parseInt(in.readLine());

            // processing data
            synchronized (MultiThreadedTCP_Server.class){
                COUNT += number;
            }
            String serverMsg = "Count : " + COUNT;

            // Send reponse to client
            out.println(serverMsg);

            clientSocket.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
