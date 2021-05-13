package com.ifmo.jjd.lesson12;

public class GenericInMethods {
    public static void main(String[] args) {
        String[] colors = {"red", "blue", "yellow"} ;
        Integer[] nums = {23, -90, 111, 56, -500} ;

        System.out.println(GenericUtils.inArray(colors, "red"));
        System.out.println(GenericUtils.<Integer>inArray(nums, 100));

        int a = 23 ;
        double b = 500.56 ;
        System.out.println(GenericUtils.<Integer, Double>compareNumbersHashCode(a, b));
    }
}
