package com.ifmo.jjd.hw14;

import java.util.*;

public class MapTask {

    @Override
    public String toString() {
        return "MapTask{}";
    }

    public static void listOfCities (HashMap<String, String> map, String city) {
        List<String> cityArrayList = new ArrayList<>();

        for (Map.Entry <String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(city))
                cityArrayList.add(entry.getKey()) ;
        }

        //алгоритм вроде бы отрабатывает правильно, но выводит какой-то бред... почему так?
        System.out.println(cityArrayList);
    }

    public static Map<String, Integer> repeatCount (List<String> words){
        Map<String, Integer> wordsHashMap = new HashMap<>();
        int count = 0 ;

        for (String word : words) {
            if (!wordsHashMap.containsValue(word)) {
                count = 0 ;
                for (String tmp : words) {
                    if (tmp.equals(word)) {
                        count ++ ;
                    }
                }
                wordsHashMap.put(word, count) ;
            }
        }

        System.out.println(wordsHashMap.entrySet());
        return wordsHashMap;
    }

    public static Map<String, Customer> customersIn (HashMap<String, Customer> map, int min, int max) {
        Map<String, Customer> newCustomers = new HashMap<>();
        for (Map.Entry <String, Customer> customer: map.entrySet()) {
            if (customer.getValue().getAge() > min && customer.getValue().getAge() < max)
                newCustomers.put(customer.getKey(), customer.getValue());
        }

        System.out.println(newCustomers.entrySet());
        return  newCustomers;
    }


    public static void main(String[] args) {
        // TODO:: написать статический метод, который принимает на вход мапу (firstTaskMap) и город (city)
        //  и формирует список (List) логинов, которые соответствуют переданному городу

        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");

        String city = "Тверь";

        MapTask.listOfCities(firstTaskMap, city);



        // TODO:: дан список слов (words).
        //  Написать метод, который будет возвращать количество одинаковых слов с списке
        //  в виде Map<String, Integer>, где String - слово и Integer - количество повторений

        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");

        MapTask.repeatCount(words) ;



        // TODO:: дана мапа (customerMap).
        //  Написать метод, который принимает на вход аргументы int from и int to и возвращает
        //  новую мапу, в которую войдут все покупатели,
        //  возраст которых находится в диапазоне [from, to)

        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("Павел", "1", 23));
        customerMap.put("2", new Customer("Олег", "2", 17));
        customerMap.put("3", new Customer("Максим", "3", 48));
        customerMap.put("4", new Customer("Евгения", "4", 67));


        MapTask.customersIn(customerMap, 18, 60) ;


        // в тексте содержатся только буквы и пробельные символы
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";

        System.out.println(wordFrequency("it", text)) ;
        groupingByLetters(text);
        topTenWords(text);
        lettersFrequency(text);
    }
    // TODO:: Задания по тексту (text). На каждый пункт - минимум один метод:
    //  4. вывести частоту встречаемости букв английского алфавита в данном тексте. Вывести в процентах для каждой буквы
    public static void lettersFrequency (String text) {
        text = text.toLowerCase().replaceAll(" ", "").replaceAll("-", "");
        char[] characters = new char[text.length()] ;
        int oneHundredPercent = text.length();

        for (int i = 0; i < characters.length; i++) {
            characters[i] = text.charAt(i) ;
        }

        HashMap<Character, Double> charMap = new HashMap<>();

        for (char chr: characters) {
            if (charMap.containsKey(chr)) {
                for (Map.Entry<Character, Double> entry : charMap.entrySet()) {
                    if (entry.getKey().equals(chr))
                        entry.setValue(entry.getValue() + 1);
                }
            } else charMap.put(chr, (double)1) ;
        }

        for (Map.Entry<Character, Double> entry : charMap.entrySet())  {
            entry.setValue(entry.getValue()*100/oneHundredPercent);
        }

        System.out.println(charMap);
    }

    //  3. написать метод, который выводит в консоль топ 10 самых частых слов
    public static void topTenWords (String text) {
        String[] words = text.toLowerCase().split(" ");
        HashMap<String, Integer> uniqWords = new HashMap<>() ;

        for (String word: words) {
            if (uniqWords.containsKey(word)) {
                for (Map.Entry<String, Integer> entry: uniqWords.entrySet() ) {
                    if (entry.getKey().equals(word))
                        entry.setValue(entry.getValue() + 1) ;
                }
            } else uniqWords.put(word, 1) ;
        }

        System.out.println(uniqWords);

        String[] topTen = new String[10] ;
        int max ;
        for (int i = 0; i < topTen.length; i++) {
            max = 0 ;
            for (Map.Entry<String, Integer> entry : uniqWords.entrySet()) {
                if (max < entry.getValue()) max = entry.getValue() ;
            }
            for (Map.Entry<String, Integer> entry : uniqWords.entrySet()) {
                if (max == entry.getValue()) {
                    topTen[i] = entry.getKey();
                    entry.setValue(0) ;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(topTen));

        /*Comparator<Map.Entry<String, Integer>> comparator1 = new Comparator<>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return Integer.compare(o1.getValue(), o2.getValue());
            }
        };
        TreeMap<String, Integer> sortedUniqueWords = new TreeMap(comparator1);
        sortedUniqueWords.putAll(uniqWords);*/

        //System.out.println(sortedUniqueWords);
    }

    //  2. написать метод, который собирает все слова в группы
    //  по количеству букв:
    //  например, в одну группу попадут слова:
    //  3 - [the, war, jar, get, met...],
    //  в другую 2 - [on, up, no, of...]
    //  результат сохранить в Map<Integer, ArrayList>


    public static void groupingByLetters (String text) {
        Map<Integer, ArrayList<String>> groupsOfWords = new HashMap<>();

        ArrayList<String> words = new ArrayList<>(Arrays.asList(text.split(" "))) ;


        //перебираем все слова
        for (String word: words) {
            //если слово с такой длинной уже есть в мапе
            if (groupsOfWords.containsKey(word.length())) {
                //перебираем записи мапы
                for (Map.Entry <Integer, ArrayList<String>> entry : groupsOfWords.entrySet())
                    //находим конкретную запись, где ключ - длина слова
                    if (entry.getKey().equals(word.length()))
                        //в имеющееся значение добавляем слово
                        entry.getValue().add(word);
            } else {
                //создаем новую запись в мапе
                groupsOfWords.put(word.length(), new ArrayList<String>(Collections.singleton(word)));
            }
        }

        System.out.println(groupsOfWords);
    }

    //  1. написать метод, принимающий на вход слово и возвращающий частоту
    //  встречаемости данного слова в тексте
    public static int wordFrequency (String word, String text) {
        int freq = 0;

        String[] words = text.toLowerCase().split(" ");

        for (String wordOfString : words) {
            if (wordOfString.equals(word)) freq++;
        }
        return freq ;
    }
}


