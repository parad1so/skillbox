/*
Цель заданий

Получить опыт работы со Stream API.


Задание №1
Что нужно сделать

Выведите в консоль с помощью Stream API сотрудника с максимальной зарплатой среди тех, кто пришёл в 2017 году.

Критерии оценки

«Зачёт» — в консоль выведен сотрудник и его зарплата.
«Незачёт» — задание не выполнено.


Задание №2
Что нужно сделать

Распечатайте с помощью библиотеки airport.jar время вылета и модели самолётов, вылетающих в ближайшие два часа.

Критерии оценки

«Зачёт» — список рейсов выводится в консоль.
«Незачёт» — задание не выполнено.

непонятно как достать метод getDate для обьекта
 */


import com.skillbox.airport.Airport;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class Main
{
    private static String staffFile = "data/staff.txt";
    private static String dateFormat = "dd.MM.yyyy";

    private static String dateY = "yyyy";

    public static void main(String[] args)
    {
        ArrayList<Employee> staff = loadStaffFromFile();

        SimpleDateFormat format = new SimpleDateFormat(dateY);
        Stream<Employee> stream = staff.stream();
        //stream.filter(employee -> employee.getSalary() >= 140000).forEach(System.out::println);
        stream.filter(employee -> format.format(employee.getWorkStart()).equals("2017"))
                .max(Comparator.comparing(Employee::getSalary))
                .ifPresent(System.out::println);
        //stream.filter(employee -> employee.getWorkStart().compareTo())
        //staff.forEach(employee -> System.out.println(employee));
        //staff.forEach(System.out::println);

        //System.out.println(format.format(staff.get(1).getWorkStart()).equals("2018"));


        //задание 2
        Airport airport = Airport.getInstance();
        System.out.println(airport.getAllAircrafts().get(1).toString());
        System.out.println(airport);

    }

    private static ArrayList<Employee> loadStaffFromFile()
    {
        ArrayList<Employee> staff = new ArrayList<>();
        try
        {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for(String line : lines)
            {
                String[] fragments = line.split("\t");
                if(fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                staff.add(new Employee(
                    fragments[0],
                    Integer.parseInt(fragments[1]),
                    (new SimpleDateFormat(dateFormat)).parse(fragments[2])
                ));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }
}