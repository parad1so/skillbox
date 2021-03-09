package Clients;

public class IpClient extends Client {
    public String getInfo() {
        return "У ИП — пополнение с комиссией 1%, если сумма меньше 1000 рублей. И с комиссией 0,5%, если сумма больше либо равна 1000 рублей.";
    }

    public void putSum(int sum) {
        if (sum < 1000) {
            System.out.println("Коммисия 1%");
            this.sum += sum - (sum * 0.01);
        }
        else {
            System.out.println("Коммисия 0.5%");
            this.sum += sum - (sum * 0.005);
        }
    }
}
