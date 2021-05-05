package hw19.imgSending;

import hw19.Connection;
import hw19.SimpleMessage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;
    private Connect connection;

    public  Server(int port) {
        this.port = port ;
    }

    public void start () {
        try (ServerSocket serverSocket = new ServerSocket(port)) { //Ожидание клиентских подключений
            System.out.println("сервер запущен");
            Socket newClient = serverSocket.accept(); //момент установки соединения с клиентом
            connection = new Connect(newClient);
            byte[] message = connection.readPicture();


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
