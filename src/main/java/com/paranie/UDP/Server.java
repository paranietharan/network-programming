package com.paranie.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            // Step 1: Create a DatagramSocket on port 8080
            socket = new DatagramSocket(8080);
            byte[] buffer = new byte[256];

            // Step 2: Prepare a DatagramPacket to receive data from client
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            System.out.println("Server is waiting for a client packet...");

            // Step 3: Receive packet from client
            socket.receive(packet);
            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received from client: " + received);

            // Step 4: Send a response back to the client
            String response = "Hello from the server!";
            byte[] responseData = response.getBytes();
            DatagramPacket responsePacket = new DatagramPacket(
                    responseData, responseData.length, packet.getAddress(), packet.getPort());
            socket.send(responsePacket);
            System.out.println("Response sent to client.");
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        } finally {
            // Step 5: Ensure the socket is closed even if an error occurs
            if (socket != null && !socket.isClosed()) {
                socket.close();
                System.out.println("Socket closed.");
            }
        }
    }
}
