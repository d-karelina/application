package com.ifmo.jjd.lesson22.decorator;

import com.ifmo.jjd.lesson22.ILogger;

public abstract class BaseDecorator implements ILogger {
    private ILogger logger ;

    public BaseDecorator(ILogger logger) {
        this.logger = logger ;
    }

    @Override
    public void log(String message) {
        logger.log(message);
    }
}
