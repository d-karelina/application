package com.ifmo.jjd.exam.game;

public class Start extends Command {


    public Start(Menu menu) {
        this.menu = menu ;
        this.text = "Начать игру" ;
        this.id = "играть" ;
        this.escape = false ;
    }

    @Override
    public boolean execute() {
        menu.start() ;
        return escape ;
    }
}
