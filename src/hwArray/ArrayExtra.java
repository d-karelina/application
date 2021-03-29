package hwArray;

import java.util.Arrays;
import java.util.Scanner;

/* создать массив из случайных целых чисел общее количество элементов 10.
 скопировать (методом) первые пять элементов в другой массив. отсортировать (методом).
 ввести с клавиатуры число. методом поиска проверить, есть ли такое число в массиве.
 с помощью цикла for each вывести результат*/
public class ArrayExtra {
    public static void main(String[] args) {

//        объявление массива:
        int [] array = new int[10];

//        наполнение значениями
        for (int i=0 ; i<10; i++) {
            array [i] = (int)(Math.random()*100) ;
        }

//        вывод получившегося массива строкой
        System.out.println(Arrays.toString(array)) ;

//        копирование первых 5 элементов массива в новый массив
        int [] array2 = Arrays.copyOf(array, 5) ;
        System.out.println(Arrays.toString(array2)) ;

//        сортировка нового массива
        Arrays.sort(array2);
        System.out.println(Arrays.toString(array2)) ;

//        ввод числа из консоли
        Scanner enter = new Scanner(System.in);
        int num = enter.nextInt();

//        проверка наличия числа в массиве
       for (int i = 0; i < 5; i++) {
           if (num == array2[i]) {
               System.out.println( "есть такое число!" );
               break;
           }
       }

        for (int j:array2 ) {
            System.out.println(j);
        }

    }
}
