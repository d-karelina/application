package com.ifmo.jjd.lesson22;

public class ClassInProgram {
    private ILogger logger ;

    public ClassInProgram(ILogger logger) {
        this.logger = logger ;
    }

    public void setLogger(ILogger logger) {
        this.logger = logger ;
    }

    public  void action() {
        logger.log("Логирование действий");
    }

}
