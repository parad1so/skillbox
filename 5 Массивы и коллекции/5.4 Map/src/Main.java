/*
Цель задания

Научиться работать с коллекцией Map.

Что нужно сделать

1. Напишите программу, которая будет работать как телефонная книга:

    Если пишем новое имя, программа просит ввести номер телефона и запоминает его. Если новый номер телефона — просит ввести имя и также запоминает.
    Если вводим существующее имя или номер телефона, программа выводит всю информацию о контакте.
    При вводе команды LIST программа печатает в консоль список всех абонентов в алфавитном порядке с номерами.

2. Определяйте имя и телефон с помощью регулярных выражений.

3. Подумайте, что выбрать в качестве ключа и значения для Map, выберите лучший вариант по вашему мнению. Опишите, какие минусы и плюсы видите в вашем выборе.

Критерии оценки

«Зачёт» — телефонная книга работает согласно условиям.
«Незачёт» — задание не выполнено.
 */

import java.math.BigInteger;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        TreeMap<String, Long> tele = new TreeMap<>();

        Scanner scanner = new Scanner(System.in);

        // телефон не уместить в int поэтому long
        tele.put("hi", Long.valueOf(983298492834L));
        tele.put("abram", Long.valueOf(89053332333L));
        tele.put("rama", Long.valueOf(98329849284L));

        for(;;) {
            String scan = scanner.nextLine();

            if (scan.equals("LIST")) {
                printMap(tele);
                continue;
            }

            if (Pattern.matches("\\d*", scan)) {
                checkName(tele, Long.valueOf(scan));
                continue;
            }

            if (Pattern.matches("\\w*", scan)) {
                checkName(tele, scan);
                continue;
            }
        }
    }


    private static void printMap (Map<String, Long> map) {
        for (String key : map.keySet()) {
            System.out.println("Контакт: " + key + " " + " Номер телефона: " + map.get(key));
        }
    }

    private static void checkName (Map<String, Long> map, String into) {
        System.out.println("Проверка имени ...");
        if (map.containsKey(into)){
            System.out.println("Такой контакт уже существует его номер телефона: " + map.get(into));
        }
        else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Вы заводите новый контакт, введите его телефон!");
            Long scannInt = scanner.nextLong();
            map.put(into, scannInt);
        }
    }

    private static void checkName (Map<String, Long> map, Long into) {
        System.out.println("Проверка телефона ...");
        if (map.containsValue(into)){
            //метода поиска по значению нету пришлось писать цикл
            for (String key : map.keySet()) {
                Object obj = map.get(key);
                if (key != null) {
                    if (into.equals(obj)) {
                        System.out.println("Такой контакт уже существует его имя: " + key); // нашли наше значение и возвращаем  ключ
                    }
                }
            }
        }
        else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Вы заводите новый контакт, введите его имя!");
            String scannStr = scanner.nextLine();
            map.put(scannStr, into);
        }
    }

}
