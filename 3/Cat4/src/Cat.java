
public class Cat
{
    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;

    private double amount;

    public static int count;

    private Colors color;

    public static final int EYE_COUNT = 2;
    public static final int MIN_WEIGHT = 1000;
    public static final int MAX_WEIGHT = 9000;
   // public static final int LEGS_COUNT = 4;

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        count++;
    }

    public Cat(double weight) {
        this();
        this.weight = weight;
    }

    public Cat (Cat cat) {
        this(cat.getWeight());
        this.originWeight = cat.originWeight;
        this.color = cat.color;
    }

    public void meow()
    {
        weight = weight - 1;
        System.out.println("Meow");
        if(isLive() == false) {
            count--;
        }
    }

    public void feed(Double amount){
        weight = weight + amount;
        this.amount = this.amount + amount;
        System.out.print("feed ");
        System.out.println(amount);
        if(isLive() == false) {
            count--;
        }
    }

    public void pee(){
        weight = weight - 5;
        System.out.println("Pee");
    }

    public void drink(Double amount)
    {
        weight = weight + amount;
    }


    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public boolean isLive() {
        return weight > minWeight && weight < maxWeight;
    }

    public static int getCount(){
        return count;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            return "Dead";
        }
        else if(weight > maxWeight) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
}