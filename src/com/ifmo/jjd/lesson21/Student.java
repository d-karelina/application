package com.ifmo.jjd.lesson21;

import java.util.ArrayList;

public class Student {
    private  String name ;
    private ArrayList<Exam> exams ;

    public Student(String name) {
        this.name = name ;
        exams = new ArrayList<>() ;
    }

    public  void addExam (Exam exam) {
        exams.add(exam) ;
    }

    //вложенные классы (nested static class) - модификатор доступа static. Статическим может быть только вложенный класс.
    // Класс верхнего уровеня статическим быть не может.
    // Статические классы являются самостоятельными, не обязательно создать объект класса верхнего уровеня.
    // Может содержать статические и нестатические свойства и методы.
    // Из статического класса нельзя обратиться к свойствам класса верхнего уровня.
    // Области видимости вложенных классов - согласно их модификатору доступа.

    public static class Exam {
        private static final int MAX_MARK = 5 ;
        private  int mark ;
        private String examName ;

        public Exam(int mark, String examName) {
            this.mark = mark ;
            this.examName = examName ;
        }
    }
}
