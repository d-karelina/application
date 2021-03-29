package com.ifmo.jjd.hw6.library;

import java.util.Arrays;
import java.util.UUID;

public class Storage {
    private UUID uuid ;
    private Book[] books = new Book[20];

    public Storage() {
        uuid = UUID.randomUUID();
    }

    public void addBook (Book book) {
        if (books[19] != null) {
            System.out.println("в хранилище нет места");
            return;
        }
       /* код для проверки повторного ввода книг

       for (int i = 0; i < books.length; i++) {
            if (books[i] == book) {
                System.out.println("такая книга уже есть");
                return;
            }
        }*/
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                return;
            }
        }
    }

    @Override
    public String toString () {
        return "Storage{" +
                "uuid=" + uuid +
                ", books=" + Arrays.toString(books) +
                '}';
    }
}
