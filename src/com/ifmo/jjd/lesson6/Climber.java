package com.ifmo.jjd.lesson6;

import java.util.UUID;

public class Climber {
    //свойства (поля, атрибуты - синонимы)
    private String fullName ;
    private int age ;
    private String email ;
    private UUID uuid ; // класс, который позволяет с уникальными идентификаторами

    //methods
    // методы, которые устанавливают значения свойств (с проверками) называют сеттеры
    public void setFullName(String fullName){
        if (fullName == null || fullName.trim().length() < 3) {
            throw new IllegalArgumentException("Значение fullName < 3") ;
        }
        this.fullName = fullName ;
    }

    public void setAge (int age) {
        if (age < 18) throw new IllegalArgumentException("Значение age 18 или больше!") ;
        this.age = age ;
    }

    //ALT + Inert или ALT + Fn + Insert или правая кнопка мыши

    public void setEmail(String email) {
        if (email == null || !email.trim().contains("@"))
            throw new IllegalArgumentException("Это не email") ;
        this.email = email ;
    }

    public void setUuid() {
        uuid = UUID.randomUUID();
    }

    public String getFullName() {
        return fullName ;
    }

    public int getAge() {
        return age ;
    }

    public String getEmail() {
        return email;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return "Climber{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", uuid=" + uuid +
                '}';
    }
}
