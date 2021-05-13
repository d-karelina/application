package com.ifmo.jjd.lesson22.decorator;

import com.ifmo.jjd.lesson22.ILogger;

import java.time.LocalDateTime;

public class DataDecorator extends BaseDecorator{
    public DataDecorator(ILogger logger) {
        super(logger);
    }

    @Override
    public void log(String message) {
        String newMessage = message + "date" + LocalDateTime.now() ;
        super.log(newMessage);
    }
}
