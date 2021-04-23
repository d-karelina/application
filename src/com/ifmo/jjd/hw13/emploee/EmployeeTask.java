package com.ifmo.jjd.hw13.emploee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class EmployeeTask {
    public static void main(String[] args) {
        List<Employee> employees = Employee.employeeGenerator(20);
        // Дописать метод employeeGenerator и
        // отсортировать его по:
        // имени
        // имени и зарплате
        // имени, зарплате, возрасту и компании

        System.out.println(employees);

        Comparator<Employee> comparator = new Employee.NameComparator() ;
        Comparator<Employee> comparator2 = new Employee.NameComparator().thenComparing(new Employee.SalaryComparator()) ;
        Comparator<Employee> comparator3 = new Employee.NameComparator().thenComparing(new Employee.SalaryComparator())
                .thenComparing(new Employee.AgeComparator()).thenComparing(new Employee.CompanyComparator()) ;

        TreeSet<Employee> employeeTreeSet = new TreeSet<>(comparator) ;
        TreeSet<Employee> employeeTreeSet2 = new TreeSet<>(comparator2) ;
        TreeSet<Employee> employeeTreeSet3 = new TreeSet<>(comparator3) ;

        // с первым TreeSet какая-то проблема... он почему-то выкидываем все записи с повторящимися именами...
        // я посмотрела, что второй TreeSet не выкидываем записи, где одинакомые имена и компания...
        // не получается разрбаться - почему...
        employeeTreeSet.addAll(employees) ;
        employeeTreeSet2.addAll(employees) ;
        employeeTreeSet3.addAll(employees) ;

        employees.sort(comparator);
        employees.forEach(System.out::println);

        //System.out.println(employeeTreeSet) ;
        // employeeTreeSet2.forEach(System.out::println);
        //System.out.println(employeeTreeSet2) ;
        //System.out.println(employeeTreeSet3) ;

    }
}