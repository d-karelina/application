package com.ifmo.jjd.lesson6;

public class Mountain {
    private String name ;
    private int height ;

    //конструктор
    public Mountain(String name, int height){
        setName(name);
        setHeight(height);
    }

    public Mountain(){
        //вызов конструктора
        this ("Гора по умолчанию", 300);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() < 2)
            throw new IllegalArgumentException() ;
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    private void setHeight(int height) {
        if (height < 100)
            throw new IllegalArgumentException("height меньше 100") ;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
