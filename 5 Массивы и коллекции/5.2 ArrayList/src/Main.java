import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/*Цель задания

Научиться работать со списком ArrayList.

 Что нужно сделать

Разработайте список дел, который управляется командами в консоли. Команды: LIST, ADD, EDIT, DELETE.

Принцип работы команд:

    LIST — выводит дела с их порядковыми номерами;
    ADD — добавляет дело в конец списка или дело на определённое место, сдвигая остальные дела вперёд, если указать номер;
    EDIT — заменяет дело с указанным номером;
    DELETE — удаляет.

Примеры команд

    LIST
    ADD Какое-то дело
    ADD 4 Какое-то дело на четвёртом месте
    EDIT 3 Новое название дела
    DELETE 7

Команды вводятся одной строкой пользователем в консоль.
* */

public class Main {
    public static void main(String[] args) {
        ArrayList<String> busines = new ArrayList<>();
        busines.add("Дело раз");
        busines.add("Дело два");

        Scanner scanner = new Scanner(System.in);
        String inp = scanner.nextLine();

        String[] words = inp.split("\\s+");

        if (words[0].equals("LIST")) {
            for(int i = 0; i < busines.size(); i++){
                System.out.println(i + " - " + busines.get(i));
            }
        }

        if (words[0].equals("ADD")) {
            //с индексом
            if (words[1].matches("\\d")) {
                busines.add(Integer.parseInt(words[1]), addet(inp));
            }
            //без индекса
            else {
                busines.add(addet(inp));
            }
            System.out.println("Успешно добавленно! ");
            for (int i = 0; i < busines.size(); i++) {
                System.out.println(i + " - " + busines.get(i));
            }
        }

        if (words[0].equals("DELETE")) {
            busines.remove(Integer.parseInt(words[1]));
            System.out.println("Успешно удаленно! ");
            for (int i = 0; i < busines.size(); i++) {
                System.out.println(i + " - " + busines.get(i));
            }
        }

        if (words[0].equals("EDIT")) {
            busines.set(Integer.parseInt(words[1]), addet(inp));
            System.out.println("Успешно измененно! ");
            for (int i = 0; i < busines.size(); i++) {
                System.out.println(i + " - " + busines.get(i));
            }
        }

    }

    public static String addet (String input) {
        String[] words = input.split("\\s+");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < words.length; i++){
            if (i == 0) {
                continue;
            }
            //убираем из массива цифру индекса если она будет
            if (i == 1 && Pattern.matches("\\d", words[1])){
                continue;
            }
            stringBuffer.append(words[i]);
        }
        return stringBuffer.toString();
    }

}
