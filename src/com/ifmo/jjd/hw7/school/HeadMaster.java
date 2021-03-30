package com.ifmo.jjd.hw7.school;

public class HeadMaster extends Human{

    public HeadMaster (String fullName, int age) {
        super (fullName, age) ;
    }

    public void startLessons (){
        System.out.println("начало занятий");
    }
    public void finishLessons () {
        System.out.println("конец занятий");
    }
}
