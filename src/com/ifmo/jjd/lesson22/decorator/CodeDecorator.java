package com.ifmo.jjd.lesson22.decorator;

import com.ifmo.jjd.lesson22.ILogger;

import java.util.UUID;

public class CodeDecorator extends BaseDecorator {
    public CodeDecorator(ILogger logger) {
        super(logger) ;
    }

    @Override
    public void log(String message) {
        String newMessage = message + " " + UUID.randomUUID() ;
        super.log(newMessage) ;
    }
}
