package hw19.imgSending;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private String ip ;
    private int port ;

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void startAndSend () {
        try {
            BufferedImage image = ImageIO.read(new File("test.jpg"));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", byteArrayOutputStream);
            Connect connection = new Connect(new Socket(ip, port)) ;
            connection.sendPicture(byteArrayOutputStream.toByteArray());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
