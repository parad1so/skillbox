/*
Цель задания

Научиться использовать механизм исключений.

Что нужно сделать

Пропишите в проекте ConsoleCustomerList все возможные варианты защиты от некорректной работы и её преждевременного завершения.

Программа должна выбрасывать исключения (Exception) при неверном формате

    команды (количество элементов в команде),
    номера телефона,
    email.

Критерии оценки

«Зачёт» — программа выводит информацию в консоль при неверном вводе, программа не завершается с ошибкой при вводе любого формата команд.
«Незачёт» — задание не выполнено.
 */
import java.util.Scanner;

public class Main
{
    private static String addCommand = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static String commandExamples = "\t" + addCommand + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static String commandError = "Wrong command! Available command examples: \n" +
            commandExamples;
    private static String helpText = "Command examples:\n" + commandExamples;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();
        for(;;)
        {
            try {
                String command = scanner.nextLine();
                String[] tokens = command.split("\\s+", 2);
                if(tokens[0].equals("add")) {
                    executor.addCustomer(tokens[1]);
                }
                else if(tokens[0].equals("list")) {
                    executor.listCustomers();
                }
                else if(tokens[0].equals("remove"))
                {
                    if (tokens.length != 2) {
                        throw new IllegalArgumentException("delete error! Correct format: \n" +
                                "remove Василий Петров ");
                    }
                    executor.removeCustomer(tokens[1]);
                }
                else if(tokens[0].equals("count")) {
                    System.out.println("There are " + executor.getCount() + " customers");
                }
                else if(tokens[0].equals("help")) {
                    System.out.println(helpText);
                }
                else {
                    System.out.println(commandError);
                }
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }
    }
}
