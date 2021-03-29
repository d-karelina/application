package hwArray;

import java.util.Arrays;

/*Создайте массив из 11 случайных целых чисел из отрезка [-1;1], выведите массив в консоль.
        Определите какой элемент встречается в массиве чаще всего
        и выведите информацию об этом в консоль.*/
public class Array11 {
    public static void main(String[] args) {
        int [] numbers = new int[11] ;
        int mOne = 0, zero = 0, one = 0 ;

        for (int i = 0; i < 11; i++) {
            numbers[i] = (int)(Math.random()*3)-1;
            switch (numbers[i]) {
                case -1 :
                    mOne++ ;
                    break ;
                case 0 :
                    zero++ ;
                    break ;
                case 1 :
                    one++ ;
                    break ;
            }
        }
        System.out.println(Arrays.toString(numbers));
        if (mOne != zero && mOne != one && zero!= one) {
            if (mOne > zero && mOne > one) System.out.println("Больше всего значений -1: " +mOne);
            if (zero > mOne && zero > one) System.out.println("Больше всего значений 0: " +zero);
            if (one > zero && one > mOne) System.out.println("Больше всего значений -1: " +one);
        } else {
            System.out.println("Ничья!");
            if (mOne==zero) System.out.println("Значений -1 и 0 поравну: " +mOne);
            if (mOne==one) System.out.println("Значений -1 и 1 поравну: " +mOne);
            if (one==zero) System.out.println("Значений 1 и 0 поравну: " +mOne);
        }

    }
}
