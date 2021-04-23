package com.ifmo.jjd.hw14;

import com.ifmo.jjd.hw13.message.Message;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Customer {
    private String name;
    private String uuid;
    private int age;

    public Customer(String name, String uuid, int age) {
        this.name = name;
        this.uuid = uuid;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void loginList (Map<String, String> map, String city) {

    }



    // TODO: переопределить все необходимые методы
}