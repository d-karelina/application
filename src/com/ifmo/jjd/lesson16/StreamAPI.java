package com.ifmo.jjd.lesson16;

import com.ifmo.jjd.lesson15.education.Course;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {//позволяет работать с потоками данных, стрим позволяет фильровать, сортировать,

    //изменять потоки данных, но сами данные хранит, должны где-то сохранить промежуточные операции, которые преобразуют данные
    //1. создаем поток
    //2. проебразуем поток (промежуточная операция, их может быть сколько угодно)
    //3. сохраняем данные
    public static void main(String[] args) {

        Stream<Integer> ints = Stream.of(8, -90, 12, -453, 0, 3321, 88, -90, 112);
        ints.filter(n -> n > 0)
                .map(n -> n * n)
                .limit(2)
                .forEach(System.out::println); //закрывающа операция, после нее со стримом делать нельзя.

        ints = Stream.of(-7, 43, 66, 66, -90, -90, 22);
        ints.distinct()
                .sorted()
                .forEach(System.out::println);

        //anyMatch
        ints = Stream.of(-7, 43, 66, 66, -90, -90, 22);
        System.out.println(ints.anyMatch(n -> n > 50)); //true

        ints = Stream.of(-7, 43, 66, 66, -90, -90, 22);
        System.out.println(ints.allMatch(n -> n > 50)); //false

        ints = Stream.of(-7, 43, 66, 66, -90, -90, 22);
        System.out.println(ints.noneMatch(n -> n > 100)); //true

        //findFirst (первый элемент потока),
        // findAny (производльные элемент потока) - конечные методы, терминальные -
        // возвращают элементы в Optional-контейнеры
        String[] colors = {"red", "yellow", "blue", "black"};
        Optional<String> first = Arrays.stream(colors).findFirst();
        // String elem = first.get() ; // NoSuchElementException
        String elem = first.orElse("while");
        boolean isPresent = first.isPresent(); //возвращает true,если внутри Optional не null и false, если null

        //делаем из массива поток
        //skip создает новый стрим без первых скольких-то элементов
        Arrays.stream(colors)
                .skip(2)
                .filter(str -> str.endsWith("k"))
                .forEach(System.out::println);

        List<Course> courses = Course.getInstances(15);

        // min, max - методы стрима, на вход принимают компоратор, возвращают в Optional-контейнере
        Course min = courses.stream()
                .min(Comparator.comparing(Course::getPrice))
                .orElse(Course.getInstance());
        //orElse - метод Optional возвращает минимальный или другой
        //getInstance() - наш метод из курсов, который возвращает любой курс

        System.out.println(min);

        Course maxByDuration = courses.stream() // Stream<Course>
                .max(Comparator.comparing(Course::getDuration)) //Optional<Course>
                .orElse(Course.getInstance()); // Course
        System.out.println(maxByDuration);

        // массив курсов, стоимость которых более 20000
        Course[] coursesArr = courses.stream()
                .filter(course -> course.getPrice() > 20000)
                //.toArray - собирает элементы стрима в массив, закрывает операцию. если метод без аргументов,
                // то возвращает массив типа Object[]
                .toArray(Course[]::new); //Course::new - ссылка на контруктор курса

        System.out.println(Arrays.toString(coursesArr));

        List<Course> courseList = courses.stream()
                .filter(course -> course.getDuration() < 4)
                .peek(course -> course.setPrice(course.getPrice() + 10000))
                .collect(Collectors.toList());

        //метод collect принимает на вход коллектор, который создает или set или list или map - закрывающий
        // map (3, 1, 0, -2) - создает новый стрим, берёт элемент из нового стрима
        // peek (3, 1, 0, -2) - меняет существующие

        Set<Course> courseSet = courses.stream()
                .filter(course -> course.getDuration() < 4)
                .collect(Collectors.toSet());

        //ArrayList

        ArrayList<Course> courseArrayList = courses.stream() //создали поток
                .distinct() //оставили только уникальные
                .sorted(Comparator.comparing(Course::getDuration).thenComparing(Course::getPrice)) //отсортировали по продолжительности и стоимости
                .collect(Collectors.toCollection(ArrayList::new)); //преобразовали к коллекции ArrayList

        //.distinct() - оставляет только уникальные курсы
        //.sorted() - метод сортировки, перегруженный при остуствии данных на входе сортирует через compareTo

        colors = new String[]{"blue", "yellow", "black", "white"} ;
        Map<String, Integer> colorMap = Arrays.stream(colors)
                .collect(Collectors.toMap(
                        Function.identity(), //правила создания ключей color -> color
                        color -> color.length(), // правила создания значений, String::length
                        (item1, item2) -> item1 // что делать, если ключи одинаковые
                ));

        //map, flatmap
        String[][] strings = {
                {"67", "33", "0", "1"},
                {"554", "900", "33"},
                {"67", "67", "47111"},
        } ;

        String[][] strings1 = Arrays.stream(strings)
                .map(arr -> Arrays.stream(arr).distinct().sorted().toArray(String[]::new))
                .toArray(String[][]::new) ;

        System.out.println(Arrays.deepToString(strings1));

        String[] strings2 = Arrays.stream(strings)
                .flatMap(arr -> Arrays.stream(arr).distinct())
                .sorted()
                .toArray(String[]::new) ;

                //flatMap - собирает элементы из подмассивов в один общий поток

        System.out.println(Arrays.toString(strings2));




    }

}
