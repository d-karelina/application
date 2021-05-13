package com.ifmo.jjd.exam.game;

public class Save extends Command {

    public Save(Menu menu) {
        this.menu = menu ;
        this.text = "Сохранить игру" ;
        this.id = "сохранить" ;
        this.escape = false ;
    }

    @Override
    public boolean execute() {
        menu.save() ;
        return escape ;
    }
}
