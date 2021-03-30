package com.ifmo.jjd.hw7.school;

public class Application {
    public static void main(String[] args) {
        Student student1 = new Student("Вася Петров", 7, "maths") ;
        Student student2 = new Student("Маша Иванова", 6, "russian language") ;
        Student student3 = new Student("Дима Семенов", 8, "maths") ;
        Student student4 = new Student("Аня Кузнецова", 9, "russian language") ;
        Student student5 = new Student("Оля Фролова", 7, "music") ;
        Student student6 = new Student("Сеня Смирнов", 8, "maths") ;

        Teacher teacher1 = new Teacher("Марина Петровна", 47, "maths");
        Teacher teacher2 = new Teacher("Ольга Анатольевна", 61, "english language");
        Teacher teacher3 = new Teacher("Сергей Сергеевич", 47, "music");

        HeadMaster director = new HeadMaster("Иван асильевич", 70) ;

        School school1 = new School("Alma Mater", director,
                new Student[]{student1, student2, student3, student4, student5, student6},
                new Teacher[] {teacher1, teacher2, teacher3}) ;

        school1.dayInSchool();

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(student4);
        System.out.println(student5);
        System.out.println(student6);
    }
}
