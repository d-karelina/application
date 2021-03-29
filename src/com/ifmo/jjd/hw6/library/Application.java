package com.ifmo.jjd.hw6.library;

/*1. Реализовать объектную модель:
Хранилище: книги, номер хранилища;
Книга: название, авторы, количество страниц, год издания (int);
Автор: имя, фамилия.
Книга может быть написана несколькоми авторами.
Каждое хранилище расчитано на 20 книг (максимум).
* Необходимо реализовать возможность добавления книг в хранилище по 1й.
* В одно хранилище не может быть добавлено несколько книг с одинаковым названием.*/

public class Application {
    public static void main(String[] args) {
        Storage storage1 = new Storage() ;


        Book book1 = new Book();
        book1.setBookTitle();
        book1.setAmountOfPages();
        book1.setYearOfPublication();
        int numberOfAuthors = book1.setNumberOfAuthors();
        book1.setAuthors(numberOfAuthors);

        System.out.println(book1);

        storage1.addBook(book1);
        storage1.addBook(book1);
        storage1.addBook(book1);
        storage1.addBook(book1);
        storage1.addBook(book1);
        storage1.addBook(book1);
        storage1.addBook(book1);
        storage1.addBook(book1);
        storage1.addBook(book1);
        storage1.addBook(book1);
        storage1.addBook(book1);
        storage1.addBook(book1);
        storage1.addBook(book1);
        storage1.addBook(book1);
        storage1.addBook(book1);
        storage1.addBook(book1);
        storage1.addBook(book1);
        storage1.addBook(book1);
        storage1.addBook(book1);
        storage1.addBook(book1);
        storage1.addBook(book1);

        System.out.println(storage1);
    }
}
