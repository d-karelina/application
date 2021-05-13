package com.ifmo.jjd.lesson21;

public class User {
    private  Level level ;
    private  String login ;

    public User(Level level, String login) {
        this.level = level;
        this.login = login;
    }

    //внутренний класс
    // не могут содержать статические поля и методы, кроме final
    // внутренние классы могут обращаться к полям и методам внешнего класса.
    public  class Account {
        public static final double MAX_BALANCE = 1000 ;
        private double balance ;

        public  Account(double balance) {
            //обращение к свойствам внешнего класса
            //имя внешнего класса.this.имя свойства (или метода)
            this.balance = User.this.level.getCount();
        }

        public User getUser() {
            //ссылка на объект внешнего класса
            return User.this ;
        }
    }


    //вложенный
    public enum Level {
        HIGH(100), MEDIUM(50), LOW(10);

        private double count ;
        Level(double count) {
            this.count = count ;
        }

        public double getCount() {
            return this.count ;
        }
    }
}
