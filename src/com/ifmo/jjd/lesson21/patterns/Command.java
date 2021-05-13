package com.ifmo.jjd.lesson21.patterns;

import java.net.http.WebSocket;
import java.util.EventListener;


interface Voice {
    void voice() ;
}

class MewAction implements  Voice{
    @Override
    public void voice() {
        System.out.println("мау");
    }
}

class GavAction implements Voice {
    @Override
    public  void voice() {
        System.out.println("гав");
    }
}


