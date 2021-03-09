public class CardAcc extends BankAccount {

    public void cutCash(int cash) {
        this.cash -= cash + (cash * 0.01);
        System.out.println("Коммисия 1% c суммы снятия");
    }

}
