package hwString;
/*Заполнить массив
        Задать массив на N слов.
        В цикле считывать с консоли слова (scanner.nextLine()), и добавлять их в массив (добавлять новое слово в массив можно только, если в нем его еще нет).
        В итоге в массиве будут только уникальные слова.
        Выход их программы по слову exit (его в массив не добавлять) или если массив заполнен
        Перед завершением программы, вывести получившийся массив в консоль*/
import java.util.Arrays;
import java.util.Scanner;

public class ArrayOfString {
    public static void main(String[] args) {
        int N = 5 ;
        String tmp = new String();

        String [] array = new String [N] ;
        Scanner enter = new Scanner(System.in) ;
        for (int i = 0; i < N; i++) {
            System.out.println( "введите слово №" + (i+1));
            tmp = enter.nextLine() ;
            if (tmp.equals("exit")) break ;
            else {
                array[i] = tmp;
                for (int j = 0; j < i; j++) {
                    if (array[i].equals(array[j])) {
                        System.out.println("повтор!");
                        i--;
                        break;
                    }
                }
            }
        }
        if (array[N-1] != null && !array[N-1].isEmpty())
            // ????? я не понимаю, в чем отличие этих частей сравнения и почему не работает вторая без первого..
            System.out.println(Arrays.toString(array));
        else System.out.println("массив не заполнен");
    }
}
