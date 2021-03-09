package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
Цель задания
Научиться писать контроллер для обработки GET-запроса.
 Что нужно сделать
Создайте проект ToDoList. При входе через браузер по основному адресу он должен отвечать текущей датой или случайным числом.
Критерии оценки
«Зачёт» — после запуска приложения по адресу http://localhost:8080 выводится дата или случайное число. «Незачёт» — задание не выполнено.

 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
