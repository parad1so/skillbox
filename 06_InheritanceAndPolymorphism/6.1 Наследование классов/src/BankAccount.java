import java.util.Calendar;

public class BankAccount {

    public int cash = 2000;
    Calendar calendar = Calendar.getInstance();

    public void putCash(int cash) {
        this.cash += cash;
        calendar = Calendar.getInstance();
    }
    public void cutCash(int cash) {
        this.cash -= cash;
    }

    public boolean send(BankAccount receiver, int amount) {
        if (this.cash > amount) {
            this.cutCash(amount);
            receiver.putCash(amount);
            return true;
        }
        return false;
    }

    public int getCash() {
        return cash;
    }


}
