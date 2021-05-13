package com.ifmo.jjd.lesson20;

import java.nio.ByteBuffer;

public class NIOBuffer {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        assert buffer.position() == 0; //не работают по умолчанию. в готовом приложении их быть не должно,
        // используются только при разработке. чтобы их включать vm options передать -ea
        // с помощью этой конструкции проверяются какие-то утверждения (правда/ложь). если утверждение неверно,
        // то при запуске на этом месте программа отвалится со ошибкой.

        assert buffer.capacity() == 16;
        assert buffer.limit() == 16;
        assert buffer.remaining() == 16;

        buffer.putInt(100);

        assert buffer.position() == 4; // позиция стала 4, т.к. любой инт - 4 байта
        assert buffer.remaining() == 12;

        buffer.putDouble(100.25); //позиция стала 12, т.к. double - это 8 байт

        assert buffer.position() == 12;
        assert buffer.remaining() == 4;

        buffer.flip(); // перемещает лимит на место позиции, а позицию - в ноль.
        // используется для подготовка буффера для чтения.

        assert buffer.position() == 0;
        assert buffer.limit() == 12;
        assert buffer.remaining() == 12;

        int anInt = buffer.getInt(); // после чтения позиция снова сместилась

        assert buffer.position() == 4;
        assert buffer.remaining() == 8;

        double aDouble = buffer.getDouble();

        assert buffer.position() == 12;
        assert buffer.remaining() == 0;

        buffer.rewind(); //для повторного чтения, подготавливает буффер к повторному чтению.
        // Лимит остается на прежнем месте, position перемещается в 0

        assert buffer.position() == 0;
        assert buffer.limit() == 12;
        assert buffer.remaining() == 12;

        assert anInt == buffer.getInt();
        assert aDouble == buffer.getDouble();

        buffer.clear(); //ничего из буффера не удаляет. перемещает лимит к емкости, а позицю - в ноль.
        // Для повторной записи.

        assert buffer.position() == 0;
        assert buffer.capacity() == 16;
        assert buffer.limit() == 16;
        assert buffer.remaining() == 16;

        buffer.compact(); // все непрочитанные байты копируются в начало буффера. Лимит устанавливается к ёмкости.
        // Позиция не меняется.
        //Даёт возможность дописывать в буффер
    }
}