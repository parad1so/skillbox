/*
Цель задания
Научиться копировать файлы и папки.
Что нужно сделать
•	Напишите код, который копирует одну указанную папку в другую. При копировании должны сохраниться файлы и структура папки.
•	Папки запрашивайте у пользователя в консоли. (не стал реализовывать)
•	Программа должна перехватывать все исключения, возникающие при ошибках чтения файлов и папок, и выводить сообщение об ошибке с трассировкой стека (stack trace).
 Критерии оценки
«Зачёт» — программа копирует содержимое папок. «Незачёт» — задание не выполнено.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Mail {
    public static void main(String[] args) {
        try {
            PrintWriter writer = new PrintWriter("data/file.txt");
            for (int i = 0; i < 1000; i++) {
                writer.write(i + "\n");
            }
            writer.flush();
            writer.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            copyDir("/Users/admin/Desktop/test/java", "/Users/admin/Desktop/test/java2");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void copyDir(String sourceDirName, String targetSourceDir) throws IOException {
        File folder = new File(sourceDirName);
        File folderTarget = new File (targetSourceDir);
        File[] listOfFiles = folder.listFiles();

        Path destDir = Paths.get(targetSourceDir);
        if (listOfFiles != null)
            if (!folderTarget.isDirectory()) {
                folderTarget.mkdir();
            }
            for (File file : listOfFiles)
                Files.copy(file.toPath(), destDir.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
    }
}
