package com.ifmo.jjd.hw7.school;

public class Human {
    protected String fullName ;
    protected int age ;

    public Human (String fullName, int age) {
        if (fullName == null || age < 5 ) throw  new IllegalArgumentException("fullName == null or age<5");
    }

}
