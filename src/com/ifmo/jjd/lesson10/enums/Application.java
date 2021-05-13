package com.ifmo.jjd.lesson10.enums;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Article article = new Article("Про Австралию");
        article.setText("текст статьи");

        article.setCountry(Article.Country.AUSTRALIA);

        Article ukArticle = new Article("Про Британию");
        ukArticle.setText("текст статьи");
        ukArticle.setCountry(Article.Country.UK);

        //методы enum
        //масс с элементами перечислениями
        Article.Country[] countries = Article.Country.values();
        System.out.println(Arrays.toString(countries));

        // индекс элемента перечисления
        System.out.println(Article.Country.USA.ordinal()); // 2

        for (Article.Country country : countries) {
            System.out.println(country.ordinal() + " " + country.name());
        }

        System.out.println(Article.Country.valueOf("USA")); //valueOf принимает на вход строку,
        // а возвращает объект (!) указанного типа.

        Priority priority = Priority.HIGH;
        priority.setCode(100);
        System.out.println(priority.getCode());

        Priority.MIDDLE.setCode(50);
        System.out.println(Priority.MIDDLE.getCode());

        for (Priority elem: Priority.values()) {
            System.out.println(elem.name() + " " +elem.getCode());
        }

        if (priority == Priority.HIGH) {
            System.out.println("Срочное сообщение");
        } else if (priority == Priority.LOW) {
            System.out.println("Не очень срочное сообщение");
        }

        Operation sum = Operation.SUM ;
        System.out.println(sum.action(5, 5));

        System.out.println(Operation.MULTI.action(5,5));


        for (Planet planet: Planet.values()){
            System.out.println(planet.name() + " " + planet.getWeight() + " " + planet.getRadius());
        }
    }
}
