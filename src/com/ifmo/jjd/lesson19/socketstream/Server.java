package com.ifmo.jjd.lesson19.socketstream;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;
    private Connection connection;

    public  Server(int port) {
        this.port = port ;
    }

    public void start () {
        try (ServerSocket serverSocket = new ServerSocket(port)) { //Ожидание клиентских подключений
            System.out.println("сервер запущен") ;
            while (true) {
                Socket newClient = serverSocket.accept() ; //момент установки соединения с клиентом
                connection = new Connection(newClient) ;
                SimpleMessage message = connection.readMessage() ;
                System.out.println(message);
                connection.sendMessage(SimpleMessage.getMessage("сервер", "сообщение получено"));
            }
        } catch (IOException e) {
            System.out.println("Ошибка сервера");;
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка чтения сообщения - класс написан неправильно!");;
        }
    }
}
