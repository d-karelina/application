package com.ifmo.jjd.lesson23;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
    //аннотация может быть пустой - как интерфейс маркер. или у аннотации могут быть параметры.
    // в качестве параметров можно использовать только строки, примитивы и перечисления (enum)

    String fileName() ; // обязательный параметр
    long version() default 1 ; // необязательный параметр
}
