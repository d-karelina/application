package com.ifmo.jjd.hw6.cats;

public class Mouse {
    private int mousesSpeed ;

    public Mouse (int mousesSpeed){
        if (mousesSpeed<1) throw new IllegalArgumentException("mousesSpeed must be 1 or more") ;
        this.mousesSpeed = mousesSpeed ;
    }

    public int getMousesSpeed() {
        return mousesSpeed;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "mousesSpeed=" + mousesSpeed +
                '}';
    }
}
