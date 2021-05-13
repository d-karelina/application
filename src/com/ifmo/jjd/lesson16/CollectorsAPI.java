package com.ifmo.jjd.lesson16;

import com.ifmo.jjd.lesson15.education.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsAPI {
    public static void main(String[] args) {
        // группировки
        ArrayList<Course> courses = new ArrayList<>(Course.getInstances(20)) ;
        Map<String, List<Course>> byName = courses.stream()
                .collect(Collectors.groupingBy(course -> course.getName())); // Course::getName

        //создает такой коллектор, где ключ то, что будет указано в аргументе - в нашем случае "name",
        // значение (список) - перечень курсов с этим именем.
        //groupingBy по умолчанию создает List

        Map<Integer, ArrayList<Course>> byDuration = courses.stream()
                .collect(Collectors.groupingBy(course -> course.getDuration(), // Course::getDuration
                        Collectors.toCollection(ArrayList::new))) ;

        //мапа: название курсов и количество курсов с этим названием
        Map<String, Long> coursesCount = courses.stream()
                .collect(Collectors.groupingBy(Course::getName, Collectors.counting()));


        //мапа: название курсов - ключ, значение - средняя стоимость курсов с этим названием
        Map<String, Double> avgPrice = courses.stream()
                .collect(Collectors.groupingBy(course -> course.getName(),
                        Collectors.averagingDouble(course -> course.getPrice())));

        Map<String, Map<Integer, List<Course>>> byNameDuration = courses.stream()
                /*пример
                "java" =    3:(course1, course 2, course 3)
                            6:(course6, course 22)*/
                .collect(Collectors.groupingBy(
                        Course::getName,
                        Collectors.groupingBy(Course::getDuration)
                ));

                System.out.println(byNameDuration);


                //на основе коллекции курса создать список List из строк в отсортированном порядке

        List<String> names = courses.stream()
                .map(course -> course.getName())
                .distinct()
                .sorted()
                .collect(Collectors.toList());

                System.out.println(names);
    }
}
