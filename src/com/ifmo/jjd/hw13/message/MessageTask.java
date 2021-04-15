package com.ifmo.jjd.hw13.message;

import java.util.*;

public class MessageTask {

    // TODO:  Подсчитать количество сообщений для каждого приоритела
    //  Ответ в консоль
    public static void countEachPriority(List<Message> messageList) {
        System.out.println("количество сообщений для каждого приоритета:") ;
        int l = 0, h = 0, m = 0, u = 0 ;
        for (Message message: messageList) {
            switch (message.getPriority()) {
                case LOW:
                    l++;
                    break;
                case HIGH:
                    h++;
                    break;
                case MEDIUM:
                    m++;
                    break;
                case URGENT:
                    u++;
                    break;
            }
        }
        System.out.println("URGENT:" + u + " HIGH:" + h + " MEDIUM:" + m + " LOW:" +l);
    }

    // TODO: Подсчитать количество сообщений для каждого кода сообщения
    //  Ответ в консоль
    public static void countEachCode(List<Message> messageList) {
        System.out.println("количество сообщений для каждого кода:") ;

        int[] count = new int [10] ;
        for (int i = 0; i < count.length; i++) {
            count[i] = 0 ;
        }
        for (Message message: messageList) {
            count[message.getCode()] ++ ;
        }
        int j = 0;
        for (int i: count ) {
            System.out.println("'"+ j+ "':" +i);
            j++ ;
        }
    }

    // TODO: Подсчитать количество уникальных сообщений
    //  Ответ в консоль
    public static void uniqueMessageCount(List<Message> messageList) {
        HashSet<Message> messageHashSet = new HashSet<>(messageList) ;
        System.out.println(messageHashSet.size());
    }

    // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
    //  в котором они встретились в первоначальном списке
    //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
    //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {
        LinkedHashSet<Message> messageLinkedHashSet = new LinkedHashSet<>(messageList) ;
        ArrayList<Message> messageList1 = new ArrayList<>(messageLinkedHashSet);

        return messageList1;
    }

    // TODO: создать коллекцию и передать в нее ссылки на каждое сообщение с заданным приоритетом
    //  метод должен вернуть новую коллекцию
    public static List<Message> copyEach(List<Message> messageList, Message.MessagePriority priority) {
        ArrayList<Message> messageArrayList = new ArrayList<>();

        for (Message message: messageList) {
            if (message.getPriority().equals(priority))
                messageArrayList.add(message) ;
        }
        return messageArrayList;
    }

    // TODO: создать коллекцию и передать в нее ссылки на все сообщения, кроме тех, которые имеют заданный приоритет
    //  метод должен вернуть новую коллекцию
    public static List<Message> copyOther(List<Message> messageList, Message.MessagePriority priority) {
        ArrayList<Message> messageArrayList = new ArrayList<>();
        for (Message message: messageList) {
            if (!(message.getPriority().equals(priority)))
                messageArrayList.add(message) ;
        }
        return messageArrayList;
    }

    public static void main(String[] args) {
        List<Message> messages = Message.MessageGenerator.generate(34);
        System.out.println(messages);
        // вызов методов

        System.out.println("______________________________");
        countEachPriority(messages);
        System.out.println("______________________________");
        countEachCode(messages);
        System.out.println("______________________________");
        uniqueMessageCount(messages);
        System.out.println("______________________________");
        System.out.println(uniqueMessagesInOriginalOrder(messages)) ;
        System.out.println("______________________________");
        System.out.println(copyEach(messages, Message.MessagePriority.LOW));
        System.out.println("______________________________");
        System.out.println(copyOther(messages, Message.MessagePriority.LOW));
    }
}