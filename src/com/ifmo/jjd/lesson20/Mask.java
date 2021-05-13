package com.ifmo.jjd.lesson20;


public class Mask {
    public static void main(String[] args) {
        /*public static final int PHOTO = 1 ; //0001
        public static final int VIDEO = 1 << 1 ; //0010
        public static final int AUDIO = 1 << 2 ; //0100
        public static final int FILE = 1 << 3; //1000*/

        User user = new User();

        //установить разрешение на работу с файлами и фотографиями
        user.setPermissions(Permissions.FILE | Permissions.PHOTO) ;
        // побитовое ИЛИ
        // 1000
        // 0001
        // возвращает 1, если есть хотя бы одна единица. Возвращает 1 или 0 (а не правда/ложь) и рассматривает по битам

        // проверить наличие разрешений (пересечение масок)
        if ((user.getPermissions() & Permissions.AUDIO) != Permissions.AUDIO) {
            System.out.println("у вас нет разрешений на работу с аудио") ;
        } else {
            System.out.println("доступ открыт") ;
        }
        // 1001 user mask
        // 0100 audio mask

        if ((user.getPermissions() & Permissions.FILE) != Permissions.FILE) {
            System.out.println("у вас нет прав на работу с файлом") ;
        } else {
            System.out.println("доступ открыт") ;
        }

        // исключить разрешение на работу с файлма
        user.setPermissions(user.getPermissions() & ~Permissions.FILE) ;
        // 1001 user mask "~" - "тильда", инверсия:
        // 1000 -> 0111
        // 0001
    }
}
