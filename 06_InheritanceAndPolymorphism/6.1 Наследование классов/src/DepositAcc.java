import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DepositAcc extends BankAccount {
    public void cutCash(int cash) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm");
        calendar.add(Calendar.MONTH, -1);
        if (super.calendar.getTime().getTime() < calendar.getTime().getTime()) {
            this.cash -= cash;
        }
        else {
            System.out.println("Отмена! причина: не прошло месяца с момент а зачисления");
        }
    }
}
