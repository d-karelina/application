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
        Author author1 = new Author("Эрих Мария", "Ремарк") ;
        Author author2 = new Author("Александр", "");

        Book book1 = new Book("три товарища", 400, 1963, new Author[]{author1, author2});
        book1.setBookTitle("Три товарища");
        book1.setAmountOfPages(400);
        book1.setYearOfPublication(1963);


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
