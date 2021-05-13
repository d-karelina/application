package com.ifmo.jjd.lesson15;

import com.ifmo.jjd.lesson15.education.Course;
import com.ifmo.jjd.lesson15.education.University;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaWithCollections {
    public static void main(String[] args) {
        University university = new University();
        university.addCourses(Course.getInstances(15));

        // перебор коллекции - метод foreach()
        // принимает на вход Consumer - void accept (T t)

        Consumer<Course> courseConsumer = course -> System.out.println(course) ;

        courseConsumer = System.out::println; //передача ссылки на метод
        university.getCourses().forEach(courseConsumer);

        university.getCourses().forEach(course -> course.setPrice(course.getPrice() * 1.1)) ;
        university.getCourses().forEach(course -> System.out.println(course.getName())) ;

        //удаление из коллекции метод removeIf
        //принимает на вход Predicate - boolean test(T t);
        //удалить курсы, стоимость курсов меньше 15 000

        university.getCourses().removeIf(course -> course.getPrice() < 15000) ;

        // написать в классе University реализацию
        // метода getFilteredCourses(Predicate<Course> condition)
        // который принимает на вход Predicate и возвращает новый список (List),
        // в который войдут курсы, которые удавлетворяют условию condition

        //курсы стоимость меньше 20000
        Predicate<Course> costUnder = x -> x.getPrice() < 20000 ;

        //курсы 3 месяца и короче
        Predicate<Course> lengthUnder = x -> x.getDuration() <= 3 ;

        //курсы с названием JJD
        Predicate<Course> nameJJD = x -> x.getName().equals("JJD") ;

        //получить список курсов, продолжительностью 3 месяца и меньше и стоимость менее 20000
        List<Course> filtered2 = university.getFilteredCourses(costUnder.and(lengthUnder)) ;

        //получить список курсов, продолжительностью 3 месяца и названием JJD
        List<Course> filtered = university.getFilteredCourses(lengthUnder.and(nameJJD)) ;

        // Компараторы int compare(T o2, T o2);
        Comparator<Course> byName = (course1, course2) ->
                course1.getName().compareToIgnoreCase(course2.getName()) ;

        Comparator<Course> byPrice = (course1, course2) -> Double.compare(course1.getPrice(), course2.getPrice());

        university.getCourses().sort(byName.thenComparing(byPrice)) ;

        //метод Comparator.comparing
        //принимает на вход Function  и возвращает компоратор

        byName = Comparator.comparing(course -> course.getName()) ; //compareTo
        byPrice = Comparator.comparing(course -> course.getPrice()); //compare

        byName = Comparator.comparing(Course::getName) ;
        byPrice = Comparator.comparing(Course::getPrice) ;

        Comparator<Course> courseComparator = Comparator.comparing(Course::getName)
                .thenComparing(Course::getPrice)
                .thenComparing(Course::getDuration) ;

        university.getCourses().sort(courseComparator);


    }
}