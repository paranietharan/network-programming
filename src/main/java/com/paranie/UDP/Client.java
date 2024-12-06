package com.paranie.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            // Step 1: Create a DatagramSocket
            socket = new DatagramSocket();

            // Step 2: Send packet to the server
            String message = "Hello, Server!";
            byte[] buffer = message.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length,
                    InetAddress.getByName("localhost"), 8080);
            socket.send(packet);

            // Step 3: Receive response from the server
            byte[] responseBuffer = new byte[256];
            DatagramPacket responsePacket = new DatagramPacket(responseBuffer,
                    responseBuffer.length);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0,
                    responsePacket.getLength());
            System.out.println("Server response: " + response);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();  // Step 4: Close socket
            }
        }
    }
}
