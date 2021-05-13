package com.ifmo.jjd.exam.game;
//класс - приемник команд - receiver

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Menu {
    // перечень команд, которые будут у нас меню
    ArrayList<Command> commands = new ArrayList<>() ;
    // переменная для отслеживания запуска меню до первой игры
    boolean atFirst = true;
    // переменная для считывания и записи необходимого параграфа меню. Стартовое значение параграфа "0"
    int saveNode = 0 ;
    // список параграфов
    ArrayList<Node> nodes = new ArrayList<>() ;

    //конструктор формирует список меню с командами
    public Menu() {
        commands.add(new Start(this)) ;
        commands.add(new Exit(this)) ;
        commands.add(new Download(this)) ;
        commands.add(new Save(this)) ;
    }

    //методы выводит меню
    public void printMenu() {
        int num = 1;
        for (Command command : commands) {
            // выводим все команды, кроме команды "сохранить"
            if (!(command.getID().equals("сохранить"))) {
                System.out.println(num + ". " + command.getText());
                num++;
            }
        }
        // если первая игра уже состоялась, то добавляем к выходу "сохранить"
        if (!atFirst) {
            for (Command command : commands) {
                if (command.getID().equals("сохранить")) System.out.println(num + ". " + command.getText());
            }
        }
    }

    // метод, который считываем команды меню
    public Command readCommand(int commandNum) {
        //проверяем, существует ли команда
        if (!(commandNum >= 1 && commandNum <= 4)) {
            System.out.println("нет такой комманды") ;
        }
        else switch (commandNum) {
            case 1 :
                return commands.get(0) ;
            case 2 :
                return commands.get(1) ;
            case 3:
                return commands.get(2) ;
            case 4:
                // проверяем, состоялась ли уже первая игра
                if (!atFirst) return commands.get(3) ;
                else System.out.println("команда недоступна") ;
        }
        return null;
    }

    // метод, который создаем параграфы из файла и записывает их в ArrayList
    private void createGameNodes () {
        nodes = Node.createNodes("nodes.txt") ;
    }

    //запуск игры
    public void start () {
        // создаем параграфы, если они ещё не были созданы
        if (nodes.isEmpty()) createGameNodes() ;

        // запускаем игру с нужного параграфа
        saveNode = Node.startGame(nodes, this, saveNode) ;
    }

    // сохранение игры
    public void save () {
        try (FileWriter file = new FileWriter("save.txt", false)){
            file.write(Integer.toString(saveNode)) ;
            file.flush() ;
        } catch (IOException e) {
            e.printStackTrace() ;
        }
        System.out.println("сохранение выполнено успешно");
    }

    //загрузка из файла
    public void download () {
        Path filePath = Path.of(("save.txt"));
        if (Files.exists(filePath)) {
            try {
                byte[] bytes = Files.readAllBytes(filePath) ;
                saveNode = Integer.parseInt(new String(bytes)) ;
            } catch (IOException e) {
                e.printStackTrace() ;
            }
        }
        else {
            System.out.println("нет достпуных загрузок");
            return ;
        }
        System.out.println("загрузка выполнена успешно, можете запускать игру") ;
    }

    // выход из игры
    public void exit() {
        System.out.println("До свидания...") ;
    }


}

