package com.ifmo.jjd.hw6.library;

import java.util.Arrays;
import java.util.Scanner;

public class Book {
    private String bookTitle ;
    private int amountOfPages ;
    private int yearOfPublication ;
    private Author[] authors ;


    public void setBookTitle() {
        Scanner scan = new Scanner(System.in);
        System.out.println("введите название книги");
        String bookTitle = scan.nextLine();
        if (bookTitle == null)
            throw new IllegalArgumentException("Название не введено");
        this.bookTitle = bookTitle;
    }

    public void setAmountOfPages () {
        System.out.println("введите количество страниц");
        Scanner scan = new Scanner(System.in);
        int amountOfPages = scan.nextInt();
        if (amountOfPages < 3)
            throw new IllegalArgumentException("Количество страниц < 3");
        this.amountOfPages = amountOfPages;
    }

    public void setYearOfPublication () {
        System.out.println("Введите год издания");
        Scanner scan = new Scanner(System.in);
        int yearOfPublication = scan.nextInt();
        if (yearOfPublication < 1000 || yearOfPublication > 2021)
            throw new IllegalArgumentException("Год издания меньше 1000 или больше 2021");
        this.yearOfPublication = yearOfPublication;
    }

    public int setNumberOfAuthors (){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите количество авторов");
        int n = scan.nextInt();
        if (n<1) throw new IllegalArgumentException("Количество авторов не меньше 0!") ;
        authors = new Author[n] ;
        return n ;
    }

    public void setAuthors(int numberOfAuthors) {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < numberOfAuthors; i++) {
            authors[i] = new Author();
            System.out.println("введите фамилию автора " + (i+1));
            String lastName = scan.nextLine();
            authors[i].setLastName(lastName);
            System.out.println("введите имя автора "+ (i+1));
            String firstName = scan.nextLine() ;
            authors[i].setFirstName(firstName);
        }
    }


    @Override
    public String toString() {
        return "Book{" +
                "bookTitle='" + bookTitle + '\'' +
                ", amountOfPages=" + amountOfPages +
                ", yearOfPublication=" + yearOfPublication +
                ", authors=" + Arrays.toString(authors) +
                '}';
    }
    }