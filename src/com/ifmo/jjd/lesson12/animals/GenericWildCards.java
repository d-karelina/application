package com.ifmo.jjd.lesson12.animals;

import com.ifmo.jjd.lesson12.type.PairContainer;

public class GenericWildCards {
    public static void main(String[] args) {
        Animal animal = new Cat();
        Cat cat = new Cat();
        Dog dog = new Dog();

        PairContainer<Integer, Animal> animalC = new PairContainer<>(1, animal);

        PairContainer<Integer, Cat> catBox = new PairContainer<>(1, cat) ;

        copyValue(catBox, animalC) ;
       // GenericWildCards.<Animal>copyValue(animalC, catBox);


    }

    public static <T> void copyValue(
            //указывает на то, что передваемый тип должен быть типом Т и его потомки
            PairContainer<Integer, ? extends T> from,
            //указывает на то, что передваемый тип должен быть типом Т и его предки
            PairContainer<Integer, ? super T> to
    ) {
        to.setValue(from.getValue());
    }
}