package com.paranie.Java_Secure_Socket_Extension;

import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class SecureServer {
    public static void main(String[] args) throws Exception {
        // Load the keystore
        KeyStore keyStore = KeyStore.getInstance("JKS");
//        keyStore.load(new FileInputStream("keystore.jks"), "password".toCharArray());
        keyStore.load(new FileInputStream("C:/Users/Paranie/Desktop/Codes/network-programming/src/main/java/com/paranie/Java_Secure_Socket_Extension/keystore.jks"), "changeit".toCharArray());

        // Initialize KeyManagerFactory
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
        keyManagerFactory.init(keyStore, "changeit".toCharArray());

        // Initialize SSLContext
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory.getKeyManagers(), null, null);

        // Create SSLServerSocket
        SSLServerSocketFactory serverSocketFactory = sslContext.getServerSocketFactory();
        SSLServerSocket serverSocket = (SSLServerSocket) serverSocketFactory.createServerSocket(8443);

        System.out.println("Server started and waiting for client...");
        SSLSocket socket = (SSLSocket) serverSocket.accept();

        // Communicate with the client
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        writer.println("Hello from secure server!");
        System.out.println("Client says: " + reader.readLine());

        socket.close();
    }
}
