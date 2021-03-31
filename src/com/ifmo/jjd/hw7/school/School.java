package com.ifmo.jjd.hw7.school;

public class School {
    final private String schoolTitle ;
    private HeadMaster director ;
    private Teacher[] teachers ;
    private Student[] students ;

    public School(String schoolTitle, HeadMaster director, Student[] students, Teacher[] teachers) {
        if (schoolTitle == null || director == null) throw new IllegalArgumentException("schoolTitle == null " +
                "or director == null") ;
        this.schoolTitle = schoolTitle;
        this.director = director ;
        this.students = students ;
        this.teachers = teachers ;
    }

    public void dayInSchool () {
        director.startLessons();
        for (int i = 0; i < teachers.length; i++) {
            for (int j = 0; j < students.length; j++) {
                if (students[j].getSubjectToStudy() == teachers[i].getSubjectToTeach()) {
                    teachers[i].teach(students[j]);
                }
            }
        }
        director.finishLessons();
    }
}
