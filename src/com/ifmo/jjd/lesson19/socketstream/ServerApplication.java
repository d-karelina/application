package com.ifmo.jjd.lesson19.socketstream;

public class ServerApplication {
    public static void main(String[] args) {
        new Server(8999).start() ;
    }
}
