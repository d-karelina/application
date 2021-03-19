package hwAwway;

import java.util.Arrays;

/*Заполните массив на N элементов случайным целыми числами
         и выведете максимальное,
         минимальное и среднее значение*/
public class ArrayMax {
    public static void main(String[] args) {
        int array[] = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*100);
            }
        System.out.println(Arrays.toString(array));

        int max = array[0], min = array[0], sum=array[0];
        int i;
        for (i=0 ; i< array.length-1; i++) {
            if (max<array[i+1]) max = array[i+1] ;
            if (min > array[i+1]) min = array[i+1] ;
            sum += array[i+1] ;
        }
        System.out.println("максимальное значение = " + max + " минимальное значение = " + min + " среднее значение массива =" + sum/ array.length);

    }
}
