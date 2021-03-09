/*
Цель заданий

Научиться работать с датой, используя класс Calendar.

Что нужно сделать

Напишите программу, которая покажет прошедшие дни вашего рождения от нуля лет до текущего времени в формате: возраст, дата и день недели. 

Дату рождения задавайте используя три переменные:

int day = 31;
int month = 12;
int year = 1990;

Формат требуемого вывода:

    0 - 31.12.1990 - Mon
    1 - 31.12.1991 - Tue
    …


Критерии оценки

«Зачёт» — работа программы соответствует ответам в таблице.
«Незачёт» — задание не выполнено.
*/

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        int day = 31;
        int month = 12;
        int year = 1990;

        DateFormat dateFormat = new SimpleDateFormat(" - dd.MM.yyyy - EEE", Locale.ENGLISH);

        Calendar calendar = Calendar.getInstance();

        // беру текушее время
        Date date = calendar.getTime();
        //System.out.println(dateFormat.format(date));
        //System.out.println(date.getTime());

        // задаю дату ДР
        calendar.set(year, month - 1, day);
        //System.out.println(dateFormat.format(calendar.getTime()));
        //System.out.println(calendar.getTime().getTime());

        for (int i = 0; date.getTime() >= calendar.getTime().getTime(); i++)  {
            System.out.println(i + dateFormat.format(calendar.getTime()));
            calendar.add(Calendar.YEAR, 1);
        }
    }
}
