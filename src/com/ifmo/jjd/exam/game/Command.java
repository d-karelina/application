package com.ifmo.jjd.exam.game;
//класс-команда

public abstract class Command {
    protected String id ;
    protected String text ;
    protected Menu menu;
    boolean escape ;

    protected Command() {
    }

    public boolean execute() {
        return escape ;
    }

    public String getID() {
        return id;
    }

    public String getText() {
        return text;
    }

}




