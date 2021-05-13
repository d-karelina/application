package com.ifmo.jjd.lesson18;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Optional;

public class ImgHandler extends FileHandler{
    public ImgHandler (File file) {
        setFile(file) ;
    }

    public void setFile(File file) {
        this.file = file ;
    }

    private String getExtension() {
        return Optional.of(file.getName())
                .filter(s -> s.contains("."))
                .map(s -> s.substring(file.getName().lastIndexOf(".")+1))
                .orElse("png") ;
    }

    @Override
    public boolean writeToFile(byte[] data) throws IOException {
        try (ByteArrayInputStream stream = new ByteArrayInputStream(data)) {
            //всё, что связано с чтением картинки закрывается самостоятельно, в try класть не нужно ????? видимо, это не так.....
            BufferedImage bufferedImage = ImageIO.read(stream) ;
            return ImageIO.write(bufferedImage, "png", file);
        }
    }

    @Override
    public byte[] readFromFile() throws IOException {
        BufferedImage bufferedImage = ImageIO.read(file) ;
        ByteArrayOutputStream stream = new ByteArrayOutputStream() ;
        ImageIO.write(bufferedImage, "png", stream) ;
        return stream.toByteArray() ;
    }
}
