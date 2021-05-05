package hw19;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Server {
    private int port;
    private Connection connection;
    private int countConnection = 0 ;

    public  Server(int port) {
        this.port = port ;
    }

    public void start () {
        try (ServerSocket serverSocket = new ServerSocket(port)) { //Ожидание клиентских подключений
            System.out.println("сервер запущен") ;
            while (true) {
                Socket newClient = serverSocket.accept() ; //момент установки соединения с клиентом
                countConnection ++ ;
                connection = new Connection(newClient) ;
                SimpleMessage message = connection.readMessage() ;
                System.out.println(message);
                switch (message.getText()) {
                    case "/help":
                        connection.sendMessage(SimpleMessage.getMessage("сервер",
                                "/help - пользователь хочет узнать список доступных команд\n" +
                                "    /count - пользователь хочет узнать количество клиентов, которые подключались к серверу\n" +
                                "    /ping - пользователь хочет узнать время за которое сообщение доходит до сервера и возвращается обратно\n" +
                                "    /exit - пользователь хочет выйти из программы (завершение программы)")) ;
                        break ;
                    case "/count":
                        connection.sendMessage(SimpleMessage.getMessage("сервер", String.valueOf(countConnection))) ;
                        break ;
                    case "/ping" :
                        connection.sendMessage(SimpleMessage.getMessage("сервер",
                                String.valueOf(Duration.between(message.getDateTime(), LocalDateTime.now()).toMillis()))) ;
                        break ;
                    case "/exit" :
                        connection.sendMessage(SimpleMessage.getMessage("сервер", "пока!")) ;
                        countConnection -- ;
                        break ;
                    default:
                        throw new IllegalStateException("Unexpected value: " + message.getText());
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка сервера");;
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка чтения сообщения - класс написан неправильно!");;
        }
    }
}
