/*
Цель задания
Научиться читать файлы, папки и их свойства.
Что нужно сделать
Напишите программу. Она должна:
•	получать через консоль путь от пользователя до папки;
•	суммировать размер файлов папки и вложенных папок;
•	выводить полученную сумму файлов в удобочитаемом виде — в байтах, килобайтах, мегабайтах или гигабайтах;
•	программа должна перехватывать все исключения, возникающие при ошибках чтения файлов и папок, и выводить сообщение об ошибке с трассировкой стека (stack trace).
•

Примеры работы программы
Введите путь до папки:
D:\Games
Размер папки D:\Games cоставляет 56,6 Гб

Критерии оценки
«Зачёт» — программа выводит размер папки в удобочитаемом формате. «Незачёт» — задание не выполнено.

 */

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        for (;;) {
            System.out.println("Введите путь до папки: ");
            try {

                String path = scanner.nextLine();

                System.out.println("Подождите");
                File file = new File(path);

                long size = getFolderSize(file);

                String[]units = new String[]{ "B", "KB", "MB", "GB", "TB" };
                int unitIndex = (int) (Math.log10(size)/3);
                double unitValue = 1 << (unitIndex * 10);

                String readableSize = new DecimalFormat("#,##0.#")
                        .format(size/unitValue) + " "
                        + units[unitIndex];

                System.out.println("Размер папки " + readableSize);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    private static long getFolderSize(File folder) {
        long length = 0;
        File[]files = folder.listFiles();

        int count = files.length;

        for (int i = 0; i < count; i++) {
            if (files[i].isFile()) {
                length += files[i].length();
            }
            else {
                length += getFolderSize(files[i]);
            }
        }
        return length;
    }
}
