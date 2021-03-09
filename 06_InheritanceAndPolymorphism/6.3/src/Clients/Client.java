package Clients;

public abstract class Client {

    int sum;

    public int getSum() {
        return sum;
    }

    public void putSum(int sum) {
        this.sum += sum;
    }

    public void cutSum(int sum) {
        this.sum -= sum;
    }

}
