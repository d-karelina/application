package com.ifmo.jjd.lesson23;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionLesson {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        /* Рефлексия - механизм, с помощью которого можно получать
         * информацию о классах, интерфейсах, полях и методах
         * во время выполнения программы.
         * Reflection API дает возможность создавать новые экземпляры классов,
         * получать и устанавливать значения свойств, вызывать методы. */

        //класс - дженерик, в уголвых скобках указываем тип данных, на который мы хотим получить ссылку
        Class<String> stringClass = String.class;
        System.out.println(stringClass);

        Class<Integer> intClass = int.class;
        System.out.println(intClass);

        Class<Text> textClass = Text.class;
        System.out.println(textClass);

        Text text = new Text("Refection");
        text.setText("some random text");

        Class<? extends Text> textClass2 = text.getClass();
        System.out.println(textClass2);

        System.out.println(textClass.getName()); //return String
        System.out.println(textClass.getSimpleName()); // return String
        System.out.println(textClass.getPackageName()); // return String

        //интерфейсы, которые имплементирует класс (но не его родители)
        Class<?>[] interfaces = textClass.getInterfaces(); // return array
        System.out.println(Arrays.toString(interfaces));

        //родительский класс
        System.out.println(textClass.getSuperclass()); //возвращает ссылку на класс родителя (Message)

        textClass = Text.class;

        //доступ к компонентам класса
        //у всех полей класса тип данных Field
        //поля java.reflect.Field

        Field[] fields = textClass.getFields(); //поля класса, метод возвращает массив с публичными полями класса, включая родительские
        System.out.println(Arrays.toString(fields));

        Field[] declaredFields = textClass.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields)); // вернет все поля класса, включая приватные, но не родительские

        // методы
        Method[] methods = textClass.getMethods(); // все методы класса, включая родительские с модификатором паблик
        System.out.println(Arrays.toString(methods));

        Method[] declaredMethods = textClass.getDeclaredMethods();
        System.out.println(Arrays.toString(declaredMethods));

        //конструкторы
        Constructor<?>[] declaredConstructor = textClass.getDeclaredConstructors();
        System.out.println(Arrays.toString(declaredConstructor));

        // создание объекта, метод получения одного конструктора с нуными входными аргументами
        Constructor<Text> textConstructor = textClass.getDeclaredConstructor(String.class);
        //Text text = new Text("Refection") ;
        Text reflectText = textConstructor.newInstance("Reflection");

        Field field = textClass.getDeclaredField("text"); //ссылка на поле, название которого text

        System.out.println(field.getType()); //вернет тип данных
        System.out.println(field.getName()); //вернет название поля

        field.setAccessible(true); //возможность установить или прочитать значение любого поля с любым модификатором, если классы защищены
        field.set(reflectText, "some random text"); // метод set вызывается у поля field и устанавлиаем значение строки для объекта reflectText

        System.out.println(field.get(reflectText)); // получить значение поля field (text) объекта reflectText

        Method method = textClass.getDeclaredMethod("setText", String.class); // получаем ссылку на метод по названию метода и типам аргументов

        method.setAccessible(true);

        method.invoke(reflectText, "Reflection API");

        System.out.println(method.getReturnType()); // тип возвращаемого значения
        System.out.println(Arrays.toString(method.getGenericParameterTypes())); //массив принимаемых аргементов
        System.out.println(Arrays.toString(method.getExceptionTypes())); //массив исключений метода

        Modifier.isPrivate(field.getModifiers()) ;
    }

    //написать рефлексивный статический метод toString(Object o)
    //obj: int, boolean. String, User, String[]
    public static void toString (Object o) {
        Field[] declaredFields = o.getClass().getDeclaredFields() ;
        for (int i = 0; i < declaredFields.length; i++) {
            if (declaredFields[i].getType().toString().equals("int")
                    || declaredFields[i].getType().toString().equals("boolean")
                    || declaredFields[i].getType().toString().equals("String")) {
                System.out.println(declaredFields[i]) ;
            } else toString(declaredFields[i]);
        }
        //метод проходит по всем свойствам объекта и вывести в консоль.
    }



}