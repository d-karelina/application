package com.ifmo.jjd.lesson17;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        //Edit Confiduration ->
        //Program Arguments - >
        //параметры, с которым запускается приложение
        //перечисляются через пробел
        //при запуске передаются в массив main
        System.out.println(Arrays.toString(args));

        //базовые классы запускаются при страрте. остальные запускают при требованиях
        // за загрузку классов отвечают три загрузчика:
        // bootstart - базовый загрузчик - отвечает за загрузку базовых классов, которые мы не импортируем.
        // загрузчик расширений - Extension, наследуется от базового, отвечает за загрузку java.util.Arrays и подобных
        // системный загрузчик (system/application), наследуютется от загрузчика расширений, за загрузку собственных классов
        //                  и за загрузку классов библиотек.
        // все загрузчики должны наследовать от класса java.lang.ClassLoader
        // ко всем загрузчикам, кроме базового есть доступ из программы:

        System.out.println(Application.class.getClassLoader());
        System.out.println(String.class.getClassLoader());

        System.gc();

        //информация о памяти должна быть в отдельном потоке
        long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() ;
        System.out.println(used);

    }
}
