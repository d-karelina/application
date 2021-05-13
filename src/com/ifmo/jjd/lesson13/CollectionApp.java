package com.ifmo.jjd.lesson13;

import org.w3c.dom.Node;

import java.util.*;

public class CollectionApp {

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String[] args) {
        Student student1 = new Student("Петр", "Алексеев", 29);
        Student student2 = new Student("Екатерина", "Еремина", 49);
        Student student3 = new Student("Олег", "Попов", 54);
        Student student4 = new Student("Алексей", "Попов", 54);

        ArrayList<Student> studentArrayList = new ArrayList<>() ;
        studentArrayList = new ArrayList<>(30) ;
        //ArrayList внутри хранит элементы в массиве, по умолчанию создается массив на 10 элементов
        //как только места в массиве не хватает, то емкости массива увеличивается.
        // внутри постоянное создание нового массива

        System.out.println(studentArrayList.size()) ; //возвращает количество элементов в коллекции
        studentArrayList.add(student1) ;
        studentArrayList.add(student2) ;
        studentArrayList.add(1, student3) ; //добавляет элемент на указанную позицию.
        // если элемент есть - то он будет сдвинут

        studentArrayList.addAll(Arrays.asList(student3, student4)) ; //asList преобразовывает элементы в коллекцию

        studentArrayList.trimToSize(); //урезает массив до количества элементов  коллекции

        studentArrayList.remove(student3) ;
        studentArrayList.remove(0) ; //удаляет элемент и сдвигает его

        System.out.println(studentArrayList.get(2)) ;

        for (Student student : studentArrayList) {
            student.setAge(student.getAge() + 1) ;
        }

        LinkedList<Student> studentLinkedList = new LinkedList<>() ;
        studentLinkedList.add(student1) ;
        studentLinkedList.addFirst(student3) ;
        studentLinkedList.addLast(student3) ;
        studentLinkedList.add(2, student2) ;

        /*studentLinkedList.remove(student4) ;
        studentLinkedList.remove(0) ;
        studentLinkedList.remove() ;
        studentLinkedList.removeFirst() ;
        studentLinkedList.removeLast() ;*/

        /*LinkedList -> Node(student3) <-> Node(student3) <-> Node(student3) -> null ;*/

        for (Student stud : studentLinkedList) {
            if (stud.getAge() < 40) {
                studentArrayList.add(stud) ;
                System.out.println("передал студента с возрастом "+ stud.getAge() );
            }
        }

        List<Student> sublist = studentLinkedList.subList(0, 2) ;

        //Set
        //HashSet
        //LinkedHashSet
        Student[] students = {student1, student2, student3, student4, student3} ;
        HashSet<Student> studentHashSet = new HashSet<>(Arrays.asList(students)) ;
        studentHashSet.add(student1) ;
        studentHashSet.add(student2) ;
        studentHashSet.remove(student3) ;

        //TreeSet
        //1. implements Comparable
        //2. объект Comparator в конструктор TreeSet - более гибкий вариант
        TreeSet<Student> studentTreeSet = new TreeSet<>() ;
        studentTreeSet.add(student1) ;
        studentTreeSet.add(student2) ;
        studentTreeSet.add(student4) ;

        Comparator<Student> comparator = new Student.AgeComparator().thenComparing(new Student.NameComparator()) ;
        TreeSet<Student> studentTreeSet2 = new TreeSet<>(comparator);
    }
}