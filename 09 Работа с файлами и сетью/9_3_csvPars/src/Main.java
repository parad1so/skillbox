/*
Цель задания
Научиться читать файл CSV и анализировать его.
Что нужно сделать
1.	Создать новый проект, который будет читать файл csv банковской выписки movementsList.csv и парсить полученные строки. Путь к файлу выписки храните в константе. 
2.	Код должен выводить сводную информацию по этой выписке: общий приход, общий расход и разбивку расходов.
3.

Примеры работы программы
Сумма расходов: 398 563.39 руб.
Сумма доходов: 289 890.06 руб.
 
Суммы расходов по организациям:
RUSMOSKVA56  SHLOVE REPUBLIC        1 081.53 руб.
RUSMOSCOW42 SHCL ETOILE                     126.34 руб.
RUSPUSHKINO105ZOOMAGAZIN 4             217.65 руб.

Критерии оценки
«Зачёт» — после запуска программы в консоль выводятся суммы и расходы по организациям. «Незачёт» — задание не выполнено.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Main {
    public final static String PATH = "data/movementList.csv";
    public final static String RUB = "RUR";
    public final static String USD = "USD";
    public final static String EUR = "EUR";

    public static void main(String[] args) throws IOException {

        StringBuilder builder = new StringBuilder();

        List<String> lines = Files.readAllLines(Paths.get(PATH));


        System.out.println("Сумма расходов: " + spending(lines, RUB) + " руб.");
        System.out.println("Сумма расходов: " + spending(lines, EUR) + " евро");
        System.out.println("Сумма расходов: " + spending(lines, USD) + " долларов");
        System.out.println(" ");
        System.out.println("Сумма доходов: " + income(lines, RUB) + " руб.");
        System.out.println("Сумма доходов: " + income(lines, EUR) + " евро");
        System.out.println("Сумма доходов: " + income(lines, USD) + " долларов");

        //System.out.println(lines.get(2).replaceAll(".*(\\\\.*\\\\.*\\\\.*)\\d{2}.\\d{2}\\.\\d{2}\\s\\d{2}.\\d{2}\\.\\d{2}\\s*([0-9]{0,6}.[0-9]{2})\\s{2}" + "RUR" + ".*", "$2"));
        System.out.println(" ");
        spendingName(lines, RUB);
        spendingName(lines, EUR);
        spendingName(lines, USD);

    }

    public static Double sum (ArrayList<Double> arr) {
        Double sum = 0.00;
        for (Double i : arr) {
            sum += i;
        }
        return sum;
    }


    public static Double spending (List<String> lines, String currency) {
        Pattern pattern = Pattern.compile("[0-9]{0,6}.[0-9]{2}\\s{2}" + currency);
        ArrayList <Double> sum = new ArrayList<Double>();
        lines.forEach(line -> {
            if (pattern.matcher(line).find()) {
                sum.add(Double.parseDouble(line.replaceAll("(?s).*?([0-9]{0,6}.[0-9]{2})\\s{2}" + currency + ".*", "$1")));
            }
            else {
            }
        });
        return sum(sum);
    }
    //ArrayList <String> name = new ArrayList<>();

    public static Double income (List<String> lines, String currency) {
        Pattern pattern = Pattern.compile("[0-9]{0,6}.[0-9]{2}\\s{6}" + currency);
        ArrayList <Double> sum = new ArrayList<Double>();
        lines.forEach(line -> {
            if (pattern.matcher(line).find()) {
                sum.add(Double.parseDouble(line.replaceAll("(?s).*?([0-9]{0,6}.[0-9]{2})\\s{6}" + currency + ".*", "$1")));
            }
            else {
            }
        });
        return sum(sum);
    }

    public static void spendingName (List<String> lines, String currency) {
        Pattern pattern = Pattern.compile("[0-9]{0,6}.[0-9]{2}\\s{2}" + currency);
        Map<String, Double> name = new HashMap<>();
        String regex = ".*(\\\\.*\\\\.*\\\\.*)\\d{2}.\\d{2}\\.\\d{2}\\s\\d{2}.\\d{2}\\.\\d{2}\\s*([0-9]{0,6}.[0-9]{2})\\s{2}" + currency + ".*";
        lines.forEach(line -> {
            if (pattern.matcher(line).find()) {
                //тут короче жесть проверяем есть ли в коллекции такой ключ название компании и если есть то прибавляем к нему значение
                if(name.containsKey(line.replaceAll(regex, "$1"))){
                    name.put(line.replaceAll(regex, "$1"),
                            name.get(line.replaceAll(regex, "$1")) +
                                    Double.parseDouble(line.replaceAll(regex, "$2")));
                }
                else {
                    name.put(line.replaceAll(regex, "$1"),
                            Double.parseDouble(line.replaceAll(regex, "$2")));
                }
            }
            else {
            }
        });

        String decode = new String();
        if (currency.equals("RUR")) {
            decode = " руб.";
        }
        else if (currency.equals("EUR")){
            decode = " евро";
        }
        else {
            decode = " долларов";
        }

        for (Map.Entry<String, Double> entry : name.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue() + " " + decode);
        }
    }


}
