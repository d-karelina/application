package com.ifmo.jjd.lesson10.enums;

import java.time.LocalDateTime;

//enum - набор константных значений - наследуются от java.lang.Enum
// Перечисления не могут иемть родителей и наследников.
public class Article {
    private  final String title ;
    private String text;
    private final LocalDateTime created ;
    private Country country ;

    public Article(String title){
        this.title = title ;
        created = LocalDateTime.now();
    }

    public void setText(String text) {
        this.text = text;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    //объекты типа Country
    enum Country {
        AUSTRALIA, UK, USA
    }

}
