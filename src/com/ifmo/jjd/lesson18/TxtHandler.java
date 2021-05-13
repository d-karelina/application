package com.ifmo.jjd.lesson18;

import javax.imageio.IIOException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

//.txt
public class TxtHandler extends FileHandler{

    public  TxtHandler(File file) {
        setFile(file);
    }

    public void setFile(File file) {
        if (file == null || !file.getName().endsWith("txt") || file.isDirectory()) {
            this.file = new File("default.txt") ;
        } else {
            this.file = file ;
        }
        try {
            if (this.file.createNewFile()) {
                System.out.println(this.file.getName() + " создан");
            } else {
                System.out.println(this.file.getName() + " файл уже существует");
            }
        } catch (IOException e) {
            System.out.println("Файл не был создан " + e.getMessage());
        }

        //createNewFile() - сли файл существует, то вернёт false, если не существует то создаст и вернёт true
    }


    @Override
    public boolean writeToFile(byte[] data) {
        boolean result = false ;
        // try with resources
        try (FileOutputStream outputStream = new FileOutputStream(file, true)){
            //true передается для выполнения дозаписи в конец файла, по умолчанию false - перезапись
            //если в круглых скобках try создается несколько объектов, то нужно ставить " ; "
            //в круглых скобках можно создавать любые объекты, классы которых имплементируют интерфейс: AutoCloseable
            //когда происходит имплеменация интерфейса - мы должны реализовать методов close
            //когда инструкции блока try завершатся или будет выброшено исключение,
            //у всех объектках, созданные в круглых скобках вызывается метод close

            outputStream.write(data);
            result = true;
        } catch (FileNotFoundException e) {
            System.out.println("Файл не был найден");
        } catch (IOException e) {
            System.out.println("ошибка записи в файл");
        }
        return result;
    }

    public boolean writeFromConsole() {
        boolean result = false;
        try (FileOutputStream fileoutput = new FileOutputStream(file, true);
             BufferedOutputStream buffer = new BufferedOutputStream(fileoutput)){

            //буффер - это динамически расширяемый массив. когда он (буффер) закончится,
            // то он передаст все данные в файл FileOutputStream и уже он записывает их в файл
            //..
            //конструктор буфера BufferedOutputStream принимает на вход какой-то OutputStream
            // (в который он дальше будет передавать данные)
            //всё, что наследуется от FilterOutputStream или FilterInputStream - классы обертки или декораторы
            //и они всегда является дополнением к основному функционалу: не могут сами передать.
            // Могут только преобразовать данные или накапливать.

            //все наследники FilterInputStream принимают на вход какой-нибудь inputStream

            Scanner scanner = new Scanner(System.in) ;
            while (true) {
                System.out.println("Введите данные или stop для входа") ;
                String userInput = scanner.nextLine() ;
                if (userInput.equals("stop")) break ;
                buffer.write((userInput + "\r\n").getBytes());
            }
            result = true ;
        } catch (FileNotFoundException e) {
            System.out.println("файл не удалось найти");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
        }
        return result ;
    }

    @Override
    public byte[] readFromFile() {
        byte[] result = null ;
        try (FileInputStream fileInput = new FileInputStream(file);
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream())   {

            //будем читать в массив кусочками. часть читаем складываем во временный массив на всю длинну массива
            //чтобы не потерять данные - перекладываем их в byteArray.
            // опять прочиталаи данные, положили во временный массив и т.д.
            // byteArray[]

            byte[] buf = new byte[512] ;

            int readCount ;
            while ((readCount = fileInput.read(buf)) != -1) {
                //метод read возращает количество прочитанных byte или -1, если читать больше нечего
                byteArray.write(buf, 0, readCount);
            }
            result = byteArray.toByteArray() ;
        } catch (FileNotFoundException e) {
            System.out.println("file is not found");
        } catch (IOException e) {
            System.out.println("reading error");
        }
        return result;
    }
}
