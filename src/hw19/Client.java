package hw19;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Client {
    private String ip ;
    private int port ;
    private Scanner scanner;

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
        scanner = new Scanner(System.in) ;
    }

    public void start() {
        System.out.println("Введите имя") ;
        String userName = scanner.nextLine() ;
        String command ;
        while (true) {
            System.out.println("введите команду") ;
            command = scanner.nextLine() ;
            if (!(command.equals("/help") || command.equals("/count") || command.equals("/ping")
                    || command.equals("/exit"))) {
                System.out.println("неверная команда") ;
                break ;
            } else if (command.equals("/exit")) {
                sendAndPrintMessage(SimpleMessage.getMessage(userName, command)) ;
                break ;
            } else if (command.equals("/ping")) {
                sendAndPrintMessage(SimpleMessage.getMessageWithDate(userName, command, LocalDateTime.now())) ;
            }
            sendAndPrintMessage(SimpleMessage.getMessage(userName, command)) ;
        }
    }

    public void sendAndPrintMessage (SimpleMessage message) {
        try (Connection connection = new Connection(new Socket(ip, port))){
            connection.sendMessage(message) ;
            SimpleMessage fromServer = connection.readMessage() ;
            System.out.println("от сервера: " + fromServer) ;
        } catch (UnknownHostException e) {
            System.out.println("Не смог соединиться..." + e.getMessage());
        } catch (IOException e) {
            System.out.println("Что-то с сервером случилось, наверное, обрыв соединения..." + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка чтения сообщения: с классом Simple Message совсем что-то не так... скорее всего его прост нет" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
