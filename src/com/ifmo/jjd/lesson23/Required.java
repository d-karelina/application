package com.ifmo.jjd.lesson23;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD}) //аннотировать поля и методы
@Retention(RetentionPolicy.RUNTIME) //использоваться будет во время выполнения программы
public @interface Required {
}
