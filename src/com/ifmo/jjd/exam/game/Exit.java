package com.ifmo.jjd.exam.game;

public class Exit extends Command {

    public Exit(Menu menu) {
        this.menu = menu ;
        this.text = "Выйти из игры" ;
        this.id = "выйти" ;
        this.escape = true ;
    }

    @Override
    public boolean execute() {
        menu.exit() ;
        return escape ;
    }
}
