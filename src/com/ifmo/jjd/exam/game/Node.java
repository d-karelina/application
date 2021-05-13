package com.ifmo.jjd.exam.game;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Node {
        int id ;
        String title ;
        String text ;
        String optionOne ;
        String getOptionTwo ;
        boolean isLast;

        private void setTitle(String title) {
            this.title = title;
        }

        private void setText(String text) {
            this.text = text;
        }

        private void setId(int id) {
            this.id = id;
        }

        private void setOptionOne(String optionOne) {
            this.optionOne = optionOne;
        }

        private void setGetOptionTwo(String getOptionTwo) {
            this.getOptionTwo = getOptionTwo;
        }

        public void setLast(boolean last) {
            isLast = last;
        }

        private int getId() { return id ;    }

        private String getTitle() {
            return title;
        }

        private String getText() {
            return text;
        }

        private String getOptionOne() {
            return optionOne;
        }

        private String getOptionTwo() {
            return getOptionTwo;
        }

        private boolean isLast() {
            return isLast;
        }


        //метод, который создает параграфы из текста файла
        public static ArrayList<Node> createNodes(String file) {
            ArrayList<Node> nodes = new ArrayList<>();
            try {
                //считываем файл
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Cp1251")) ;
                String str;
                int i = -1;

                //построчно считываем файл
                while ((str = reader.readLine()) != null) {
                    //проверяем, что строка не пустая
                    if (!str.isEmpty()) {
                        //проверяем, нужно ли создавать новый параграф: если это первый параграф,
                        // если все поля последнего параграфа уже записаны.
                        if (i == -1 || nodes.get(i).isLast() || !(nodes.get(i).getOptionTwo == null)) {
                            nodes.add(new Node());
                            i++;
                            nodes.get(i).setId(i);
                            nodes.get(i).setTitle(str);
                        }
                        // если новый параграф не создается, проверяем заполнено ли поле текст. если нет, заполняем
                        else if (nodes.get(i).getText() == null) {
                            nodes.get(i).setText(str);

                            // если поле текст содежит информацию о завершении, устанавливаем значение конечного параграфа
                            if (str.contains("Игра завершилась")) {
                                nodes.get(i).setLast(true);
                            }
                        }
                        // устанавливаем значение вариантов 1 и 2.
                        else if (str.contains("1.")) nodes.get(i).setOptionOne(str);
                        else if (str.contains("2.")) nodes.get(i).setGetOptionTwo(str);
                    }
                }
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("файл не найден");
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            return nodes ;
        }

        public static int startGame (ArrayList<Node> nodes, Menu menu, int startNodeNum) {
            // определяем нужный параграф для запуска игры
            Node node = nodes.get(startNodeNum) ;
            Scanner scan = new Scanner(System.in) ;
            String str = null;
            boolean correctEnter  ;
            // устанавлием значение, что первая игра состоялась
            menu.atFirst = false ;

            // для текущего параграфа в цикле...
            while (true) {
                // выводим тект параграфа
                System.out.println(node.getText()) ;
                // проверяет, что параграф не конечный. Если конечный - выходим
                if (node.isLast()) {
                    System.out.println("игра окончена") ;
                    return node.getId() ;
                }
                // выводим доступные опции для неконечного параграфа
                System.out.println("выберите вариант ответа:") ;
                System.out.println(node.optionOne) ;
                System.out.println(node.getOptionTwo) ;
                System.out.println("3. выйти в меню") ;
                correctEnter = false ;

                // проверяем корректность ввода и запоминаем выбранное значение
                while (!correctEnter) {
                    switch (scan.nextLine()) {
                        case "1": {
                            // назначаем новый параграф
                            str = node.getOptionOne() ;
                            correctEnter = true ;
                            break;
                        }
                        case "2": {
                            // назначаем новый параграф
                            str = node.getOptionTwo();
                            correctEnter = true ;
                            break;
                        }
                        case "3": {
                            // возращаемся и передаем номер текущего параграфа.
                            return node.getId();
                        }
                        default: {
                            System.out.println("такого пункта в меню нет.");
                        }
                    }
                }


                // перебираем все параграфы и находим такой, название которого содерижтся в выбранном варианте действия.
                for (Node nextNode: nodes) {
                    assert str != null;
                    if (str.contains(nextNode.getTitle())) {
                        node = nextNode;
                        break;
                    }
                }

            }

        }



    @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", text='" + text + '\'' +
                    ", optionOne='" + optionOne + '\'' +
                    ", getOptionTwo='" + getOptionTwo + '\'' +
                    ", isWon=" + isLast +
                    '}';
        }
}
