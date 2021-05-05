package hw19.imgSending;

import hw19.SimpleMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connect implements AutoCloseable {
    private Socket socket ;
    private ObjectInputStream input ; //объекты в байт
    private ObjectOutputStream output ; //байты в объект

    public Connect(Socket socket) throws IOException {
        this.socket = socket ;

        output = new ObjectOutputStream(socket.getOutputStream()) ;
        input = new ObjectInputStream(socket.getInputStream());
    }

    public void sendPicture (byte[] data) throws IOException {
        output.writeObject(data);
        output.flush();
    }

    public byte[] readPicture () throws IOException, ClassNotFoundException {
        return (byte[]) input.readObject() ;
    }

    @Override
    public void close() throws Exception {
        input.close() ;
        output.close() ;
        socket.close() ;
    }
}
