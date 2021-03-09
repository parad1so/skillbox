/*
Цель задания

Научиться сортировать и искать элементы в коллекциях.

Что нужно сделать

1. Напишите генератор «красивых» автомобильных номеров и методы поиска элементов в коллекциях:

    прямым перебором по ArrayList,
    бинарным поиском по сортированному ArrayList,
    поиском в HashSet,
    поиском в TreeSet.

2. Измерьте и сравните длительность каждого метода поиска.

Формат вывода результатов поиска:

Поиск перебором: номер найден/не найден, поиск занял 34нс

Бинарный поиск: номер найден/не найден, поиск занял 34нс

Поиск в HashSet: номер найден/не найден, поиск занял 34нс

Поиск в TreeSet: номер найден/не найден, поиск занял 34нс

3. Напишите в форме ответа, какой поиск — самый быстрый, а какой — самый медленный.

В видео Поиск и сортировка неточно указана оценка результата работы метода бинарного поиска Collections.binarySearch(). Метод возвращает int, если возвращаемое значение больше или равно нулю — это означает, что элемент найден. Если возвращаемое значение int меньше нуля — элемент в коллекции не найден.


Рекомендации

    Сортировка не входит в учёт времени для бинарного поиска.
    Для детального сравнения методов поиска используйте время в наносекундах:

     System.nanoTime()

    Используйте правила генерации номеров для получения более 2 млн номеров:

XYZ — различные буквы, N — цифры, R — регион (от 01 до 199);

XNNNYZR — пример, A111BC197, Y777HC66,

таким образом, количество номер будет достаточно для оценки времени поиска даже в миллисекундах.


Критерии оценки

«Зачёт» — при вводе в консоль автомобильного номера программа однозначно отвечает, найден ли номер в каждой из коллекций.
«Незачёт» — задание не выполнено.
 */

import java.util.*;

public class Main {
    public static TreeSet<String> arr = new TreeSet<>();

    public static void main(String[] args) {
        generator();
        System.out.println("Номера успешно сгренерированны, введите команду на выбор: ArrayList, ArrayBinary, HashSet, TreeSet");

        for(;;) {
            Scanner scanner = new Scanner(System.in);
            String enter = scanner.nextLine();
            if (enter.equals("ArrayList")) {
                System.out.println("Введите номер!");
                String data = scanner.nextLine();
                System.out.println("подождите ......");
                searchArr(data);
            }
            else if (enter.equals("ArrayBinary")) {
                System.out.println("Введите номер!");
                String data = scanner.nextLine();
                System.out.println("подождите ......");
                searchArrSort(data);
            }
            else if (enter.equals("HashSet")) {
                System.out.println("Введите номер!");
                String data = scanner.nextLine();
                System.out.println("подождите ......");
                searchHashSet(data);
            }
            else if (enter.equals("TreeSet")) {
                System.out.println("Введите номер!");
                String data = scanner.nextLine();
                System.out.println("подождите ......");
                searchTreeSet(data);
            }
            else {
                System.out.println("Неверная команда");
            }
        }
    }

    public static void generator() {
        for (int i = 1; i <= 9; i++) {
            String bi;
            for (int b = 1; b <= 199; b++) {
                if (b < 10) {
                    bi = "0" + String.valueOf(b);
                }
                else {
                    bi = String.valueOf(b);
                }
                ArrayList<Character> arrChar = new ArrayList<>();
                List<Character> anotherList = Arrays.asList('A', 'B', 'E', 'K', 'M', 'H', 'O', 'P', 'C', 'T', 'Y', 'X');
                arrChar.addAll(anotherList);
                for (int c = 0; c < arrChar.size(); c++) {
                    for (int d = 0; d < arrChar.size(); d++) {
                        for (int f = 0; f < arrChar.size(); f++) {
                            String in = String.valueOf(arrChar.get(c)) + String.valueOf(i) + String.valueOf(i) + String.valueOf(i) + String.valueOf(arrChar.get(d)) + String.valueOf(arrChar.get(f)) + bi;
                            while (arr.contains(in) == false) {
                                arr.add(in);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void searchArr(String in) {
        ArrayList<String> arrArr = new ArrayList<>();
        arrArr.addAll(arr);
        boolean check = false;

        long start = System.nanoTime();

        if (arrArr.contains(in)) {
            check = true;
            long stop = System.nanoTime() - start;
            System.out.println("Поиск перебором: номер найден, поиск занял " + stop);
        }
        else if (check == false) {
            long stop = System.nanoTime() - start;
            System.out.println("Поиск перебором: номер не найден, поиск занял " + stop);
        }

    }

    public static void searchArrSort(String in) {
        ArrayList<String> arrArr = new ArrayList<>();
        arrArr.addAll(arr);
        Collections.sort(arrArr);

        long start = System.nanoTime();

        if (Collections.binarySearch(arrArr, in) >= 0) {
            long stop = System.nanoTime() - start;
            System.out.println("Бинарный поиск: номер найден, поиск занял " + stop);
        }
        else if (Collections.binarySearch(arrArr, in) < 0) {
            long stop = System.nanoTime() - start;
            System.out.println("Бинарный поиск: номер не найден, поиск занял " + stop);
        }

        long stop = System.nanoTime() - start;
    }

    public static void searchHashSet(String in) {
        HashSet<String> arrArr = new HashSet<>();
        arrArr.addAll(arr);

        long start = System.nanoTime();

        if (arrArr.contains(in)) {
            long stop = System.nanoTime() - start;
            System.out.println("Поиск в HashSet: номер найден, поиск занял " + stop);
        }
        else {
            long stop = System.nanoTime() - start;
            System.out.println("Поиск в HashSet: номер не найден, поиск занял " + stop);
        }

    }

    public static void searchTreeSet(String in) {
        TreeSet<String> arrArr = new TreeSet<>();
        arrArr.addAll(arr);

        long start = System.nanoTime();

        if (arrArr.contains(in)) {
            long stop = System.nanoTime() - start;
            System.out.println("Поиск в TreeSet: номер найден, поиск занял " + stop);
        }
        else {
            long stop = System.nanoTime() - start;
            System.out.println("Поиск в TreeSet: номер не найден, поиск занял " + stop);
        }

    }

}
