package hw1;
/*6. Пользователь!!! загадывает число в диапазоне от [1 до 100]
        Программа пытается его угадать (используйте метод !!!бинарного поиска - деление отрезка на 2).
        Программа может задавать пользователю вопросы:
        Число равно ...? / Число больше ...? / Число меньше ...? и в зависимости от ответа пользователя принимать решения.
        !!! Вместо текстовых ответов ДА/НЕТ, используйте числа 0 - НЕТ и 1 - ДА*/
import java.util.Scanner;

public class SystemGuess {
    public static void main(String[] args) {
        // guess - переменная для угадывания числа системой, i - переменная для шага бинарного поиска
        int guess = 50, i = 50;
        Scanner enter = new Scanner(System.in);
        int result ;

        while (true) {
            System.out.println("Вы загадали число " + guess + " ?");
            result = enter.nextInt();
            if (result == 1) {
                System.out.println("Ура!");
                break;
            }
            else {
                i/=2 ;
                if (i == 0) i = 1 ; //для того, чтобы исключить погрешность отбрасывания отстатка целого числа
                System.out.println("число больше, чем " + guess + " ?");
                result = enter.nextInt();
                if (result == 1) guess = guess + i ;
                else guess = guess - i ;
            }

        }
    }
}
