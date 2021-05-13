package com.ifmo.jjd.lesson22;

public class ConsoleLogger implements ILogger{

    @Override
    public void log(String message) {
        System.out.println(message) ;
    }
}
