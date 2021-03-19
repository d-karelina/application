package hw1;

/*3. Задача на цикл while
        Считать с консоли количество тарелок и количество моющего средства
        Моющее средство расходуется из расчета 0.5 на 1 тарелку
        В цикле выводить сколько моющего средства осталось после мытья каждой тарелки.
        В конце вывести сколько тарелок осталось, когда моющее средство закончилось или наоборот.*/
import java.util.Scanner;

public class WashingPlates {
    public static void main(String[] args) {
        Scanner enter = new Scanner(System.in);
        int plates;
        double soap ;
        System.out.println("Сколько у вас тарелок?");
        plates = enter.nextInt() ;
        System.out.println("Сколько у вас моющего средства?");
        soap = enter.nextInt();
        if (plates <0 || soap < 0) System.out.println( "некорректный ввод");

        while ((plates > 0) && (soap >= 0.5)) {
            plates-- ;
            soap = soap - 0.5;
            System.out.println("осталось " + soap + " моющего средства");
        }
        if (plates == 0) System.out.println("Все тарелки вымыли и осталось моющее средство в количестве " + soap);
        else System.out.println("моющее средство кончилось, но остались тарелки в количестве " + plates + " шт.");

    }
}
