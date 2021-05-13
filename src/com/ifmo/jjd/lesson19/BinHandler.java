package com.ifmo.jjd.lesson19;

import java.io.*;

public class BinHandler {
    private File file ;

    public BinHandler(File file) {
        this.file = file ;
    }

    public <T> boolean writeToFile(T object) {
        boolean result = false ;
        try (FileOutputStream fileOutput = new FileOutputStream(file);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)) {
            //ObjectOutputStream - делает из объекта последовательность байт
            //FileOutputStream - записывает в файл

            objectOutput.writeObject(object);
            result = true ;
        } catch (IOException e) {
            System.out.println("ошибка записи в файл");
        }
        return result ;
    }
    public <T> T readFromFile() {
        Object o = null ;
        try (FileInputStream fileInput = new FileInputStream(file);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {
            o = objectInput.readObject(); //метод readObject всегда возвращает тип Object
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("ошибка исключения ");;
        }
        return (T) o ;
    }

}
