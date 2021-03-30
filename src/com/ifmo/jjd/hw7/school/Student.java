package com.ifmo.jjd.hw7.school;

public class Student extends Human implements CanStudy{
    private int eduLevel ;
    private String subjectToStudy ;

    public Student (String fullName, int age, String subjectToStudy) {
        super (fullName, age);
        if (subjectToStudy == null) throw new IllegalArgumentException("subject to study == null") ;
        this.subjectToStudy = subjectToStudy ;
    }

    public int getEduLevel() {
        return eduLevel;
    }

    public String getSubjectToStudy() {
        return subjectToStudy;
    }

    public void study () {
        eduLevel+=5 ;
    }

    @Override
    public String toString() {
        return "Student{" +
                "eduLevel=" + eduLevel +
                '}';
    }
}
