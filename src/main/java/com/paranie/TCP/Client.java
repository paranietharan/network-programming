package com.paranie.TCP;

import java.io.IOException;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);

            // Send data to server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello, Server!");

            // Receive data from server
            //BufferedReader is a class in Java used to read the text from
            // an input stream (like a file or a socket) efficiently.
            // It buffers the characters to provide efficient reading of characters,
            // arrays, and lines. This reduces the number of I/O operations
            // by reading larger chunks of data at once and storing them in an internal buffer.
            BufferedReader in = new BufferedReader(new
                    InputStreamReader(socket.getInputStream()));
            String response = in.readLine();
            System.out.println("Server says: " + response);

            // Close the socket
            socket.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
