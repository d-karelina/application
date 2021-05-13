package com.ifmo.jjd.exam.game;

public class Download extends Command {

    public Download(Menu menu) {
        this.menu = menu ;
        this.text = "Загрузить игру" ;
        this.id = "загрузить" ;
        this.escape = false ;
    }

    @Override
    public boolean execute() {
        menu.download() ;
        return escape ;
    }
}
