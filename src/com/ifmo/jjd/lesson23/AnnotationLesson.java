package com.ifmo.jjd.lesson23;

import com.ifmo.jjd.lesson7.utils.Randoms;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class AnnotationLesson {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        //информацию об аннотациях веремени выполнения мы получаем с помощью рефлексии

        Class<Point> pointClass = Point.class ;
        Annotation[] annotations = pointClass.getAnnotations() ; //вернет аннотации самого класса, аннотации методов, полей и пр. у методов, полей и пр. соответственно
        System.out.println(Arrays.toString(annotations)) ;

        if (pointClass.isAnnotationPresent(Component.class)) {
            Component component = pointClass.getDeclaredAnnotation(Component.class) ; //ссылка на аннотацию. нужна, если нужно получить значение параметров
            System.out.println(component.fileName()) ;
            System.out.println(component.version()) ;
        }

        Field[] fields = pointClass.getDeclaredFields() ;
        for (Field field : fields) {
            if (field.isAnnotationPresent(Required.class)) {
                System.out.println(field.getType()) ;
                System.out.println(field.getName()) ;
            }
        }

        Properties properties = new Properties() ; //изначально объект с файлом никак не связан
        properties.setProperty("ip", "127.0.0.1") ;
        properties.setProperty("port", "8090") ;
        System.out.println(properties.getProperty("ip")) ; //127.0.0.1

        //выгрузка данных объекта из property-файла
        try (InputStream input = AnnotationLesson.class
                    .getClassLoader()
                    .getResourceAsStream("point.properties")){
            properties.load(input) ;
        } catch (IOException e) {
            System.out.println("невозможно прочитать файл");
            e.printStackTrace();
        }

        System.out.println(properties.get("x")) ;
        System.out.println(properties.get("y")) ;

        //если класс аннотирован Component, то (получаем конструктор без параметров) создать объект данного класса рефлексивно
        //если поле отмечено аннотацией Required установить значение данного поля (из properties файла, имя файла берем из аннотации компонента),
        // используя сеттер (метод класса)
        // не напрямую (находим сеттор =  если имя поля Х, то поле SetX) Аргумент - тип поля.
        if (pointClass.isAnnotationPresent(Component.class)) {
            Constructor<Point> pointConstructor = pointClass.getDeclaredConstructor();
            Point reflectPoint = pointConstructor.newInstance();
            Field[] declaredFields = pointClass.getDeclaredFields();
            ArrayList<Field> fieldArrayList = new ArrayList<>() ;
            for (int i = 0; i < declaredFields.length; i++) {
                if (declaredFields[i].isAnnotationPresent(Required.class)) fieldArrayList.add(declaredFields[i]) ;
            }
            Method[] declaredMethod = pointClass.getDeclaredMethods() ;
            for (Field field: declaredFields) {
                String methodName = String.join("", "set", AnnotationLesson.firstUpperCase(field.getName())) ;
                System.out.println(methodName);
                for (Method method: declaredMethod) {
                    if (method.getName().equals(methodName)) {
                        Properties properties1 = new Properties();
                        // InputStream input = AnnotationLesson.class
                        //        .getClassLoader()
                        //        .getResourceAsStream("point.properties") ;
                        // properties1.load(input) ;

                        //int a = (int) properties1.get(field.getName());
                        method.invoke(reflectPoint, Randoms.getRandomInt(100));
                    }
                }
            }
            System.out.println(reflectPoint.getX());
            System.out.println(reflectPoint.getY());

            /*Component component = pointClass.getDeclaredAnnotation(Component.class) ; //ссылка на аннотацию. нужна, если нужно получить значение параметров
            System.out.println(component.fileName()) ;
            System.out.println(component.version()) ;*/
        }

    }
    public static String firstUpperCase(String word){
        if(word == null || word.isEmpty()) return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}
