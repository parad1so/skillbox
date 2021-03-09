/*
Цель задания
Научиться получать изображения с сайта парсингом, используя библиотеку jsoup.
Что нужно сделать
Напишите программу, которая:
•	получает с помощью библиотеки jsoup HTML-код страницы https://lenta.ru;
•	находит в HTML-коде теги img и получает абсолютные ссылки на изображения из атрибута src;
•	скачивает изображения в папку images проекта, при этом сохраняя оригинальные названия файлов;
•	выводит в консоль список c названиями скачанных файлов.
Рекомендации
•	Все варианты подключения библиотеки jsoup в проект на странице скачивания библиотеки
•	Для получения ссылок воспользуйтесь префиксом abs при получении атрибута src у тега img. Пример из официальной документации.
Критерии оценки
«Зачёт» — программа скачивает изображения с главной страницы lenta.ru. «Незачёт» — задание не выполнено.

 */

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;



public class Main {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://lenta.ru").get();

        Elements links = doc.getElementsByTag("img");

        links.forEach(link -> System.out.println(link.attr("src")));

        links.forEach(link -> {
            if (link.attr("src").matches("https:\\/\\/icdn.lenta.ru.*")){
                try {
                    Connection.Response resultImageResponse = Jsoup.connect(link.attr("src"))
                            .ignoreContentType(true).execute();
                    // output here
                    FileOutputStream out = (new FileOutputStream(new java.io.File("images/" + name(link))));
                    out.write(resultImageResponse.bodyAsBytes());  // resultImageResponse.body() is where the image contents are.
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("bb");
            }
        });

        //Connection.Response resultImageResponse = Jsoup.connect(links.attr("src"))
        //        .ignoreContentType(true).execute();

        // output here
        //FileOutputStream out = (new FileOutputStream(new java.io.File("images/" + name(links))));
        //out.write(resultImageResponse.bodyAsBytes());  // resultImageResponse.body() is where the image contents are.
        //out.close();
    }

    public static String name (Element el) {
        int idx = el.attr("src").replaceAll("\\\\", "/").lastIndexOf("/");
        String name = idx >= 0 ? el.attr("src").substring(idx + 1) : el.attr("src");
        System.out.println(name);
        return name;
    }

}
