package com.ifmo.jjd.lesson14;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MapExamples {
   
 
    public static void main(String[] args) {
    Map<Integer, String> users = new HashMap<>();
        users.put(1, "Ivan");//добавление элементов
        users.put(2, "Nataliya");
        users.put(3, "Anton");
        System.out.println(users.get(2));//получение по ключу
       
        System.out.println(users.containsKey(1));//проверка есть значение с таким ключем
        users.remove(1);//удаление по ключу
        System.out.println(users.containsKey(1));
       
        System.out.println(users.size());//размер мапы
       
        System.out.println(users.isEmpty());//проверка пустая ли мапа
       
        users.forEach((k, v) -> System.out.println(k + ": " + v));//элегантный вывод
    }
}