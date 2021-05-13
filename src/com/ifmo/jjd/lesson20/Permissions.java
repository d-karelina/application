package com.ifmo.jjd.lesson20;

public class Permissions {

    //маска: 1 - если есть права, 0 - если нет, например 1010 - есть права на работу с файлом и видео.
    // 0000 - ни с чем не может работать, 1111 - наличие всех разрешений

    public static final int PHOTO = 1 ; //0001
    public static final int VIDEO = 1 << 1 ; //0010
    public static final int AUDIO = 1 << 2 ; //0100
    public static final int FILE = 1 << 3; //1000
}
