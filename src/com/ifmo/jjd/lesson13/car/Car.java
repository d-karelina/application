package com.ifmo.jjd.lesson13.car;

import com.ifmo.jjd.lesson13.Student;

import java.util.Comparator;

public class Car {
    private String color;
    private String brand;
    private int price;

    public Car(String color, String brand, int price) {
        this.color = color;
        this.brand = brand;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static class PriceComparator implements Comparator<Car> {
        //наличие интерфейса компоратора у класс заставляет его реализовать метод compare

        // отрицательное - если o1 меньше
        // 0 - если объекты равны
        // положительное - если o2 меньше
        @Override
        public int compare(Car o1, Car o2) {
            return Integer.compare(o1.price, o2.price);
        }
    }

    public static class ColorComparator implements Comparator<Car> {

        @Override
        public int compare(Car o1, Car o2) {
            return o1.getColor().compareTo(o2.color);
        }
    }

    public static class BrandComparator implements Comparator<Car> {

        @Override
        public int compare(Car o1, Car o2) {
            return o1.getBrand().compareTo(o2.brand);
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}