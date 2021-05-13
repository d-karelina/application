package com.ifmo.jjd.lesson19.socketstream;

public class ClientApplication {
    public static void main(String[] args) {
        new Client("127.0.0.1", 8999).start();
    }
}
