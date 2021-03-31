package com.ifmo.jjd.hw7.school;

public class Teacher extends Human implements CanTeach {
    private String subjectToTeach ;

    public Teacher (String fullName, int age, String subjectToTeach) {
        super (fullName, age);
        if (subjectToTeach == null) throw new IllegalArgumentException("subject to study == null") ;
        this.subjectToTeach= subjectToTeach ;
    }

    public String getSubjectToTeach() {
        return subjectToTeach;
    }

    @Override
    public void teach(Student students) {
            students.study();

    }


}
