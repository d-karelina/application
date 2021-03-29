package com.ifmo.jjd.hw6.library;

public class Author {
    private String firstName ;
    private String lastName ;


    public void setFirstName(String firstName) {
        if (firstName == null) throw new IllegalArgumentException("имя = null") ;
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) throw new IllegalArgumentException("фамилия = null") ;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
