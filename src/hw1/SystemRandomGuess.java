package hw1;

import java.util.Scanner;

public class SystemRandomGuess {

    /*Программа загадывает число в диапазоне [1;9]
    Пользователь вводит число с клавиатуры
    Программа в зависимости от введенного числа выводит в консоль следующее:
            "загаданное число больше"
            "загаданное число меньше"
            "Вы угадали" (программа завершает работу)
    если введен 0, выводит "выход из программы" (программа завершает работу)*/

    public static void main(String[] args) {
        int random = (int) (Math.random() * 10);
        int guess = 10;
        while (guess != 0) {
            System.out.println("отгадайте число от 1 до 9!");
            Scanner enter = new Scanner(System.in);
            guess = enter.nextInt();
            if (guess == random) {
                System.out.println("Ура! Верный ответ");
                break;
            }
            else System.out.println("Неверный ответ");
        }
    }
}
