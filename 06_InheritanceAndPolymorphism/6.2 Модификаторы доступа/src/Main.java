/*
Цель задания

Освоить на практике наследование классов.

Что нужно сделать

1. Создайте класс Acc.BankAccount, который представляет собой расчётный счёт в банке. У класса необходимо написать методы:

     a. Снять со счёта сумму денег (без комиссии).

     b. Вносить на счёт сумму денег (без комиссии).

     c. Получить остаток на счёте.

2. Создайте два класса наследника, расширяющие работу с остатком на счёте:

    Депозитный расчётный счёт, с которого нельзя снимать деньги в течение месяца после последнего внесения.
    Карточный счёт, при снятии денег с которого будет взиматься комиссия 1%.


Критерии оценки

«Зачёт» — написаны три класса: родитель и два наследника.
«Незачёт» — задание не выполнено.


Дополнительное задание*

Цель задания

Потренироваться в написании взаимодействия между классами.

Что нужно сделать

Напишите метод в классе Acc.BankAccount:

boolean send(Acc.BankAccount receiver, double amount)

для отправки денег с одного счёта на другой. Метод должен вернуть true, если деньги успешно переведены.

Примечание

В методе для аргумента amount используйте тип данных, который применили в классе Acc.BankAccount. Тип double дан для примера.

Критерии оценки

«Зачёт» — метод send() передаёт деньги между счетами с учётом комиссий и ограничений.
«Незачёт» — задание не выполнено.

 */


import Acc.BankAccount;
import Acc.CardAcc;
import Acc.DepositAcc;

public class Main {
    public static void main(String[] args) {
        DepositAcc depositAcc = new DepositAcc();
        System.out.println(depositAcc.getCash());
        depositAcc.cutCash(39);
        System.out.println(depositAcc.getCash());

        CardAcc cardAcc = new CardAcc();
        System.out.println(cardAcc.getCash());
        cardAcc.cutCash(40);
        System.out.println(cardAcc.getCash());
        System.out.println(depositAcc.getCash());

        //задание со звездочкой
        System.out.println(cardAcc.send(depositAcc, 300));
        System.out.println(cardAcc.getCash());
        System.out.println(depositAcc.getCash());

        BankAccount bankAccount = new BankAccount();

        System.out.println(bankAccount.getCash());
        System.out.println(cardAcc.getCash());
        System.out.println(depositAcc.getCash());

    }
}
