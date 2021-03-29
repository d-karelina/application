package hwString;

import java.util.Scanner;

/*2. Найти количество вхождений одной строки в другую.
        Например, строка "дом" встречается в строке "дом домик домой одомашненный" 4 раза*/
public class StringCompare {
    public static void main(String[] args) {
        String subWord = "дом";
        String word = null;

        Scanner scan = new Scanner(System.in) ;

        word = scan.nextLine() ;
        int i = 0, count = 0 ;

        while ((word.indexOf(subWord, i) >= 0)) {
            count ++ ;
            i = (word.indexOf("дом", i)) + 1;
        }
        System.out.println(count);
    }
}
