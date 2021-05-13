package com.ifmo.jjd.lesson15.education;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class University {
    private List<Course> courses = new ArrayList<>();

    public boolean addCourse(Course course) {
        return courses.add(Objects.requireNonNull(course));
    }
    public boolean addCourses(List<Course> courses) {
        return this.courses.addAll(Objects.requireNonNull(courses));
    }

    public List<Course> getCourses() {
        return courses;
    }

    // написать в классе University реализацию
    // метода getFilteredCourses(Predicate<Course> condition)
    // который принимает на вход Predicate и возвращает новый список (List),
    // в который войдут курсы, которые удавлетворяют условию condition

    public List getFilteredCourses(Predicate<Course> condition) {
        List<Course> resultList = new ArrayList<>();
        for (Course course: courses) {
            if (condition.test(course)) resultList.add(course) ;
        }

        return resultList ;

    }

}