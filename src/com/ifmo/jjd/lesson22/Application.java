package com.ifmo.jjd.lesson22;

import com.ifmo.jjd.lesson22.decorator.CodeDecorator;
import com.ifmo.jjd.lesson22.decorator.DataDecorator;

public class Application {
    public static void main(String[] args) {
        ClassInProgram inProgram = new ClassInProgram(new ConsoleLogger()) ;
        inProgram.action() ;

        inProgram.setLogger(new DataDecorator(new FileLogger("log.txt"))); //в качестве логгера объекта inProgram является DataDecorator,
        // у которого в свою очередь логгером является FileLogger
        inProgram.action() ;

        inProgram.setLogger(new CodeDecorator(new DataDecorator(new ConsoleLogger()))) ;
        inProgram.action() ;
    }
}
