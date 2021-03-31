package hwString;

import java.util.Arrays;

/*Написать функцию, которая проверяет, является ли строка палиндромом.
        Палиндром — это число, буквосочетание, слово или текст, которые одинаково читаются по буквам или по словам как слева направо, так и справа налево.
        Например, 202 - палиндром / fafaf - палиндром / а роза упала на лапу Азора - палиндром*/
public class Palindrom {
    public static void checkPalindrom (String str) {

        String str2 = str;

        StringBuilder str3 = new StringBuilder(str);
        str3.reverse();
        str3.toString() ;

        //char[] reversStr = new char[str.length()] ;

        for (int i = 0; i < str.length() ; i++) {
            //reversStr[str.length()-1-i] = str.charAt(i) ;
            //str2.replace(str2.charAt(i), str.charAt(str.length() - i)) ;
        }
        //System.out.println(Arrays.toString (reversStr));
        //String str2 = Arrays.toString (reversStr);
        System.out.println(str) ;
        System.out.println(str2) ;
        //System.out.println(str.equals(str2)) ;
    }
    public static void main(String[] args) {
        checkPalindrom("123321");
    }
}
