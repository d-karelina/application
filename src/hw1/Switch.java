package hw1;
/*2. Задача на switch
        Пользователь вводит 3 числа:
        1е - первый операнд
        2e - второй операнд
        3е - оператор
        В зависимости от третьего введенного числа нужно вывести в консоль:
        сумму, разность, умножение, деления чисел, которые ввел пользователь.
        Если 3е введенное число 3, нужно найти сумму,
        если 5 - разность,
        если 7 - результат умножения,
        если 9 - результат деления.*/

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        double numA, numB;
        int numC;
        Scanner enter = new Scanner(System.in);
        System.out.println("Введите первое число");
        numA = enter.nextInt() ;
        System.out.println("Введите второе число");
        numB = enter.nextInt();
        System.out.println("Введите третье число");
        numC = enter.nextInt();
        switch (numC) {
            case 3 :
                System.out.println("Сумма чисел =" + (numA + numB));
                break;
            case 5 :
                System.out.println("Разность чисел =" + (numA - numB));
                break;
            case 7 :
                System.out.println("Произведение чисел = " + (numA * numB));
                break;
            case 9 :
                System.out.println("Число 1 / Число 2 =" + (numA/numB));
                break;
            default:
                System.out.println("ничего не произошло");
                break;
        }
    }
}
