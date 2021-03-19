package lesson1;
// однострочный комментарий
/* начало
многострочного
комментария
 */
// ctrl + / - однострочный комментарий
/*многострочный
комментарий: ctrl + shift + /*/

public class FirstClass {
    //    точка входа
    public static void main(String[] args) {
//        psvm - сокращение для точки входа
//        консольный вывод sout
        System.out.println("консольный вывод");

        //      git --version - на вкладке "Терминал" или командной строке

//        объявление переменных
        int count = 98234;
        int length = 122, width = 301, height = 501;
        int size, page;
        size = 6;
        page = 9;
//        внутри одной области видимости не должно быть одинаковых переменных. Дважды объявить одну переменную нельзя.
//        обращение к переменной происходит по её имени
        System.out.println(size);
        int bill = 1_000_000; // для удобство в целочисленных переменных можно разделять _ просто для улучшения читабельности
        float pi = 3.14F; // при работе с типом float нужно явно указывать в конце значения переменной букву "F" при первом присвоении значения
        long veryBig = 67_000_000_000_000L; //аналогично с типом long

//        деление на 0
//        ..целых чисел приведет к ошибке выполнения: java.lang.ArithmeticException
//        count = length/0;
//        ..чисел с плавающей точкой = Infinity
//        System.out.println(pi / 0);
        double price = bill;
        byte miniPrice = (byte) bill; //явное приведение - с понижением контейнера может привести к непредсказуемым последствиям

        byte a = 12, b = 50;
        byte ab = (byte) (a + b); // для сохранения типа byte нужно явно указать приведение

        char simbol = 50;
        System.out.println(simbol);

        boolean isGood = false;

        // операторы
        // взятие остатка от деления
        width = 2;
        height = 13;
        System.out.println(height % width);

        height *= 2;
        height /= 3;
        System.out.println(height);
        height %= width;
        System.out.println(height);

        //операторы сравнения
        System.out.println(height >= width);

        width = 2;
        height = 13;

        int sum = (height >= width) ? height : width;
        System.out.println(sum);

        boolean status = false ;
        System.out.println( sum > 0 || status) ;

        int start = 3, end = 10 ;
        System.out.println(start < end && end < 100_000);

        System.out.println(!status);
        System.out.println(!(sum > 0 || status));

        System.out.println(sum > 0 ^ !status);

        height = 2 ;
        int result = height++ - ++height + height-- - ++height * ++height + --height ;
//      2 - 4 + 4 - 4 * 5 + 4 = -14
    }
}
