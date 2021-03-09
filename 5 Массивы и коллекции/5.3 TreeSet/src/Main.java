/*Цель задания

        Научиться работать со множеством TreeSet.

        Что нужно сделать

        Напишите программу, в которой будет храниться перечень адресов электронной почты. Адреса можно добавлять через консоль командой ADD и печатать весь список командой LIST.
        Программа должна проверять корректность вводимых email’ов и печатать сообщение об ошибке при необходимости.

        Принцип работы команд

        LIST — выводит список электронных адресов.
        ADD — проверяет и, если формат адреса верный, добавляет в множество.

        Примеры команд

        LIST
        ADD hello@skillbox.ru

Команды вводятся одной строкой пользователем в консоль.

        Критерии оценки

        «Зачёт» — реализованы вывод списка и добавление электронного адреса с проверкой формата.
        «Незачёт» — задание не выполнено.
*/

import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    private static boolean flag = true;

    public static void main(String[] args) {
        TreeSet<String> tree = new TreeSet<>();

        Scanner scanner = new Scanner(System.in);
        String inp = scanner.nextLine();
        String[] words = inp.split("\\s+");

        tree.add("kdsja@kds23121321a.ri");
        tree.add("kdsja@kdsa.ri");

        if (words[0].equals("LIST")) {
                System.out.println(tree);
        }
        if (words[0].equals("ADD") && tree.contains(addet(inp)) == false && flag) {
            tree.add(addet(inp));
            System.out.println(tree);
        }
        if (flag == false) {
            System.out.println("Вы ввели некорректный email");
        }
    }

    public static String addet (String input) {
        String[] words = input.split("\\s+");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < words.length; i++){
            if (i == 0 || i > 1) {
                continue;
            }
            if (words[1].matches(".*@.*")) {
                stringBuffer.append(words[1]);
            }
            else flag = false;
        }
        return stringBuffer.toString();
    }


}
