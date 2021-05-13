package com.ifmo.jjd.lesson21.patterns.builder;
//билдер - это отдельный класс, который будет заниматься созданием объекта нужного нам класса
public class NutritionFacts {
    // обязательные параметры
    private final int servings ;

    // необязательные параметры
    private final int caloties ;
    private final int fat ;

    private NutritionFacts(Builder builder) {
        servings = builder.servings ;
        caloties = builder.calories ;
        fat = builder.fat ;
    }

    public static class Builder {
        //обяазетльные параметры отмечаем как final
        private final int servings ;
        // необязательные параметры инициализируются со значением по умолчанию
        private int calories = 1 ;
        private int fat ; //0

        //значение обязательных параметров передаются в конструктор
        public Builder(int servings) {
            this.servings = servings;
        }

        //для остальных сеттеры
        public Builder calories (int count) {
            calories = count ;
            return this ;
        }

        public Builder fat (int count) {
            fat = count ;
            return this ;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this) ;
        }
    }
}
