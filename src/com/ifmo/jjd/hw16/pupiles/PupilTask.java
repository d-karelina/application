package com.ifmo.jjd.hw16.pupiles;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class PupilTask {
    public static void main(String[] args) {

       Pupil pupil = new Pupil("Alex", Pupil.Gender.MALE, LocalDate.parse("2005-11-19")) ;
       Pupil pupil2 = new Pupil("Tom", Pupil.Gender.MALE, LocalDate.parse("2015-05-29")) ;
       Pupil pupil3 = new Pupil("Alex", Pupil.Gender.MALE, LocalDate.parse("2015-05-29")) ;
       Pupil pupil4 = new Pupil("Mary", Pupil.Gender.FEMALE, LocalDate.parse("2004-10-13")) ;
       Pupil pupil5 = new Pupil("Ann", Pupil.Gender.FEMALE, LocalDate.parse("2009-01-04")) ;
       Pupil[] pupils = {pupil, pupil2, pupil3, pupil4, pupil5};

        // Используя Stream API:

        // 1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Pupil.Gender, ArrayList<Pupil>>

       Map<Pupil.Gender, ArrayList<Pupil>> twoGroups = Arrays.stream(pupils)
                .collect(Collectors.groupingBy(Pupil::getGender,
                        Collectors.toCollection(ArrayList::new))) ;


        System.out.println(twoGroups);
        // 2. Найти средний возраст учеников

        double avgAge = Arrays.stream(pupils)
                .collect(Collectors.averagingDouble(Pupil::getAge)) ;

        double avgAge2 = Arrays.stream(pupils)
                .mapToInt(Pupil::getAge)
                .average().getAsDouble() ;

        // 3. Найти самого младшего ученика

        System.out.println(avgAge);

        Pupil youngest = Arrays.stream(pupils)
                .min(Comparator.comparing(Pupil::getAge))
                .orElseGet(null);

        System.out.println("младший: " + youngest);

        // 4. Найти самого взрослого ученика

        Pupil oldest = Arrays.stream(pupils)
                .max(Comparator.comparing(Pupil::getAge))
                .orElseGet(null);

        System.out.println("старший: " + oldest);

        // 5. Собрать учеников в группы по году рождения

        Map<Integer, ArrayList<Pupil>> groupByYear = Arrays.stream(pupils)
                .collect(Collectors.groupingBy(date -> date.getBirth().getYear(),
                        Collectors.toCollection(ArrayList::new))) ;

        System.out.println(groupByYear);

        // 6. Оставить учеников с неповторяющимися именами,
        // имена и дату рождения оставшихся вывести в консоль.
        // Например, [Иван, Александра, Ольга, Иван, Ольга] -> [Иван, Александра, Ольга]

        Map<String, LocalDate> uniqueNames = Arrays.stream(pupils)
                .collect(Collectors.toMap(
                        key -> key.getName(),
                        date -> date.getBirth(),
                        (item1, item2) -> item1
                ));
        System.out.println(uniqueNames);


        // 7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)

        List<Pupil> sortByGenderDateName = Arrays.stream(pupils)
                .sorted(Comparator.comparing(Pupil::getGender).thenComparing(Pupil::getBirth)
                        .thenComparing((o1, o2) -> o2.getName().compareTo(o1.getName())))
                .collect(Collectors.toList());

        System.out.println(sortByGenderDateName);
        // 8. Вывести в консоль всех учеников в возрасте от N до M лет

        ArrayList ageInterval = Arrays.stream(pupils)
                .filter(age -> age.getAge() > 10 && age.getAge() < 14 )
                .collect(Collectors.toCollection(ArrayList::new)) ;

        System.out.println(ageInterval);
        // 9. Собрать в список всех учеников с именем=someName

        ArrayList<Pupil> names = Arrays.stream(pupils)
                .filter(pupil1 -> pupil1.getName().equals("Alex"))
                .collect(Collectors.toCollection(ArrayList::new)) ;

        System.out.println(names);

        // 10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола

        Map<Pupil.Gender, Integer> countAgeByGender = Arrays.stream(pupils)
                .collect(Collectors.groupingBy((Pupil::getGender),
                        Collectors.summingInt(Pupil::getAge))) ;

        System.out.println(countAgeByGender);
    }
}