package com.ifmo.jjd.hw6.library;

import java.util.Arrays;

public class Book {
    private String bookTitle ;
    private int amountOfPages ;
    private int yearOfPublication ;
    private Author[] authors ;


    public Book(String bookTitle, int amountOfPages, int yearOfPublication, Author[] authors) {
        setBookTitle(bookTitle);
        setAmountOfPages(amountOfPages);
        setYearOfPublication(yearOfPublication);
        setAuthors(authors);
    }

    public void setBookTitle(String bookTitle) {
        if (bookTitle == null)
            throw new IllegalArgumentException("Название не введено");
        this.bookTitle = bookTitle;
    }

    public void setAmountOfPages (int amountOfPages) {
        if (amountOfPages < 3)
            throw new IllegalArgumentException("Количество страниц < 3");
        this.amountOfPages = amountOfPages;
    }

    public void setYearOfPublication (int yearOfPublication) {
        if (yearOfPublication < 1000 || yearOfPublication > 2021)
            throw new IllegalArgumentException("Год издания меньше 1000 или больше 2021");
        this.yearOfPublication = yearOfPublication;
    }

    public void setAuthors(Author... authorOfBook) {
        this.authors = authorOfBook ;
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