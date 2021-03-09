package Clients;

public class UlClient extends Client{
    public String getInfo() {
        return "У юридических лиц — снятие с комиссией 1%.";
    }

    public void cutSum(int sum) {
        System.out.println("Коммисия 1%");
        this.sum -= sum + (sum * 0.01);
    }

}
