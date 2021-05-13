package com.ifmo.jjd.lesson11;

import java.io.IOException;

public class ExeptionsLessons {
    public static void main(String[] args) {
        int a = 33 ;
        int b = 0 ;
        // int res = a / b; // java.lang.ArithmeticExeption: /by zero


        //обращение к несуществующему элементу массива
        int[] arr = new int[3];
        // arr[100] = 1; // java.lang.ArrayIndexOutOfBoundsException

        //если ссылка null
        String string = null ;
        //java.lang.NullPointerException

        //ошибка приведения типов
        Object data = "123" ;
        //Integer integer = (Integer) data ; // java.lang.ClassCastException
        Integer integer ;

        /*  try {
          Integer integer = (Integer) data ;
        }
        catch (ClassCastException e) {
            System.out.println("Обработка ClassCastException");
        }*/

        /*    try {
                if (System.currentTimeMillis() % 2 == 0) integer = (Integer) data;
                else arr[100] = 1;
            } catch (ClassCastException e) {
                System.out.println("Обработка ClassCastException");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Обработка ArrayIndexOutOfBoundsException");
            }

            try {
                if (System.currentTimeMillis() % 2 == 0) integer = (Integer) data;
                else arr[100] = 1;
            } catch (ClassCastException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Обработка ClassCast ArrayIndexOutOfBoundsException");
            }
*/
            try {
                if (System.currentTimeMillis() % 2 == 0) integer = (Integer) data;
                else arr[100] = 1;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
                System.out.println("Обработка RuntimeException");
            }
            finally {

            }
            withUnCheckedException(34);
        try {
            withCheckedException("some.txt");
        } catch (IOException e) {
            System.out.println("обработка IOException");
            throw new IllegalArgumentException(e.getMessage());
        }

        try {
            withCheckedException("some.tx");
        } catch (IOException ignored) {}

        Message message = new Message() ;
        try {
            message.setTitle("Срочное сообщение");
            message.setText("текст сообщения");
        } catch (AppException e) {
            e.printStackTrace();
        }
    }

        public static void withUnCheckedException (int age) {
            if (age < 18) {
                throw new IllegalArgumentException("age < 18");
            }
            System.out.println("age =" + age);
        }

        public static void withCheckedException (String fileName) throws IOException {
            if (fileName.startsWith("txt")) {
                throw new IOException("Ошибка файла");
            }
            System.out.println("fileName = " + fileName);
        }
}
