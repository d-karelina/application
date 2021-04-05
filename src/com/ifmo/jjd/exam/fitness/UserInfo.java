package com.ifmo.jjd.exam.fitness;

public class UserInfo {
    private String firstName ;
    private String lastName ;
    private int yearOfBirth ;

    public UserInfo(String firstName, String lastName, int yearOfBirth) {
        if (firstName == null || lastName == null || yearOfBirth > 2015 || yearOfBirth < 1931) {
            throw new IllegalArgumentException("некорректные данные владельца абонимента") ;
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
    }
}
