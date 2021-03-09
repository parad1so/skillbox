
/*
Цель заданий

Освоить базовые регулярные выражения и методы работы с ними.

 

Задание №1
Что нужно сделать

Внесите изменения в проект StringExperiments, чтобы суммы заработка каждого человека извлекались из текста регулярным выражением, а в конце программы рассчитывалась и распечатывалась общая сумма заработка людей.

Критерии оценки

«Зачёт» — сумма рассчитывается независимо от изменения расположения чисел в строке и имён.
«Незачёт» — задание не выполнено.

 

Задание №2
Что нужно сделать

Возьмите английский текст (не менее 100 слов) и напишите программу, которая будет разбивать его на слова и печатать слова в консоли. Знаки препинания не являются частью слова.

Критерии оценки

«Зачёт» — в консоль выводятся слова, каждое с новой строки.
«Незачёт» — задание не выполнено.

 

Задание №3
Что нужно сделать

Измените программу, написанную в уроке №4: вводимая строка с фамилией, именем и отчеством должна разбиваться с использованием регулярного выражения.

Критерии оценки

«Зачёт» — в консоль выводятся фамилия, имя, отчество каждое на новой строке.
«Незачёт» — задание не выполнено.

 

Задание №4
Что нужно сделать

Реализуйте  удаление лишних символов при вводе номера телефона в консоли и проверку соответствия номера формату мобильных номеров России. Если введённую строку нельзя привести к формату мобильного номера — выводите сообщение о неверном вводе. Телефон может быть введен не только в формате 79091234567, но и с лишними символами. 

 

Пример ввода номеров и результата вывода программы
Ввод пользователя в консоль
	Вывод программы в консоль
	Примечание
+7 909 123-45-67
	79091234567
	Символов 11 в номере, код страны 7 — номер верный.
+7 (909) 1234567
	79091234567
	Символов 11 в номере, код страны 7 — номер верный.
8-905-1234567
	79051234567
	Символов 11 в номере, первый символ 8 (код выхода на мобильный номер) заменяем на код страны 7 — номер верный.
9-453-1234567
	Неверный формат номера
	Символов 11 в номере, первый символ после очистки 9, это не 7 и не 8 — формат номера неверный.
8-905-123
	Неверный формат номера
	Символов 7 в номере — номер неверный.
905-1234567
	79051234567
	Количество символов 10 после очистки — значит, приводим к формату номера с 7.
8-905-12345672342
	Неверный формат номера
	Символов в номере больше чем 11 — номер неверный.


Критерии оценки

«Зачёт» — работа программы соответствует ответам в таблице.
«Незачёт» — задание не выполнено.


Дополнительное задание*

Цель задания

Закрепить навыки работы с регулярными выражениями.

Что нужно сделать

Изменить метод 

String searchAndReplaceDiamonds(String text, String placeholder),

который будет заменять в переданной строке String text всё содержимое скобок <> и сами скобки на переданную строку в String placeholder, используя регулярные выражения.

Критерии оценки

«Зачёт» — метод заменяет подстроку в < > на placeholder, независимо от расположения < > и количества < > в строке.
«Незачёт» — задание не выполнено.
*/


public class Loader
{
    public static void main(String[] args)
    {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        String[] sentences = text.split(" ");
        int sum = 0;

        for (int i = 0; i < sentences.length; i++) {
            sum = sum + Integer.parseInt(isDigit(sentences[i]));
        }
        System.out.println(sum);

        //задание 2
        String bigText = "NASA is giving university-level engineering students a unique opportunity to participate in the quest to harvest water on the Moon and Mars.Water is essential for extended lunar and Mars expeditions, whether astronauts drink it, grow plants with it, or make rocket propellant from it. But water is also heavy and expensive to bring from Earth. The good news is that in the past decade or so, scientists learned that water is more abundant in our solar system than previously thought, and we’re sending a water-mapping rover there to learn more. For instance, there's the potential for hundreds of millions of tons of ice in the shadows of our Moon’s South Pole. But that water is unlike anything we’ve ever had to process on Earth. \"The water we\'ll find when the next men and first women explore the lunar surface for the Artemis program is liable to be mixed with contaminants that need to be removed before drinking, or use as fuel,\" said Douglas Terrier, NASA chief technologist. \"Learning how to safely and efficiently prospect for and harvest water is key for sustainable human exploration – not only on the Moon, but also on Mars and at other far reaches of our solar system. That’s why the 2021 Moon to Mars Ice and Prospecting Challenge is asking eligible undergraduate and graduate student teams to design and build hardware that can identify, map, and drill through various subsurface layers, then extract water from an ice block in a simulated off-world test bed. The teams\' main goal will be to harvest as much water as possible from simulated slices of lunar and Martian surfaces. Each team will also identify critical differences between operations on Earth versus the Moon and Mars, and describe essential modifications needed for each in this \"path-to-flight\" description for their prototypes.";

        String[] cut = bigText.replaceAll("[.^:,\"]","").split(" ");
        for (int i = 0; i < cut.length; i++) {
            System.out.println(cut[i]);
        }
        System.out.println("Кол-во слов в тексте = " + cut.length);

        //задание 3
        String name = "Иванов Иван Иванович";

        String[] word = name.replaceAll("[.^:,\"]","").split(" ");
        for (int i = 0; i < word.length; i++) {
            System.out.println(word[i]);
        }

        //задание 4
        String num1 = "+7 909 123-45-67";
        String num2 = "+7 (909) 1234567";
        String num3 = "8-905-1234567";
        String num4 = "9-453-1234567";
        String num5 = "8-905-123";
        String num6 = "905-1234567";
        String num7 = "8-905-12345672342";

        //проверка тут
        String[] pars = num7.replaceAll("[-+.^:,\" ()]","").split("");

        System.out.println(pars[0]);


        if (pars[0].equals("8") && pars.length == 11) {
            pars[0] = "7";
            System.out.println(strBuild(pars));
        }
        else if (pars.length > 11) {
            System.out.println("Неверный формат номера");
        }
        else if (pars.length < 10) {
            System.out.println("Неверный формат номера");
        }
        else if (pars.length == 10){
            System.out.println("7" + strBuild(pars));
        }
        else if (pars[0].equals("9")){
            System.out.println("Неверный формат номера");
        }
        else {
            System.out.println(strBuild(pars));
        }
    }

    public static StringBuilder strBuild (String[] s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            stringBuilder.append(s[i]);
        }
        return stringBuilder;
    }


    public static String isDigit(String c){
        if (Character.isDigit(c.charAt(0))) {
            return c;
        }
        return "0";
    }


}