package com.paranie.Addressing_and_Naming;


import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://user:password@www.example.com:8080/path/to/resource.html?query=java#section1");
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("User Info: " + url.getUserInfo());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Path: " + url.getPath());
            System.out.println("Query: " + url.getQuery());
            System.out.println("Fragment (Ref): " + url.getRef());
            System.out.println("Authority: " + url.getAuthority());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
