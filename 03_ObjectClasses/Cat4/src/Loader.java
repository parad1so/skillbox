import java.util.Scanner;

public class Loader
{
    private static Cat getKitten(){
        return new Cat(1100.00);
    }

    public static void main(String[] args)
    {
        //задание 1
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Cat cat4 = new Cat();
        Cat cat5 = new Cat();
        Cat cat6 = new Cat();
        Cat cat7 = new Cat();

        System.out.println("cat1 weight: " + cat1.getWeight());
        System.out.println("cat2 weight: " + cat2.getWeight());
        System.out.println("cat3 weight: " + cat3.getWeight());
        System.out.println("cat4 weight: " + cat4.getWeight());
        System.out.println("cat5 weight: " + cat5.getWeight());
        System.out.println("cat6 weight: " + cat6.getWeight());
        System.out.println("cat7 weight: " + cat7.getWeight());

        System.out.println("Кормим cat1 " );
        cat1.feed(1000.0);
        System.out.println("Кормим cat2 ");
        cat2.feed(1400.7);

        System.out.println("cat1 weight: " + cat1.getWeight());
        System.out.println("cat2 weight: " + cat2.getWeight());

        while (cat1.isLive()) {
            cat1.feed(1800.0 + 3.0 * Math.random());
        }
        System.out.println("Cat1 is " + cat1.getStatus());

        while (cat2.isLive()) {
            cat2.meow();
        }
        System.out.println("Cat1 is " + cat2.getStatus());

        //задание 2
        cat3.feed(150.0);
        System.out.println("cat3 weight: " + cat3.getWeight() + " Скушано еды " + cat3.getAmount());
        cat3.pee();
        System.out.println("cat3 weight: " + cat3.getWeight());
        cat3.pee();
        System.out.println("cat3 weight: " + cat3.getWeight());

        //задание 3
        System.out.println(Cat.getCount());

        //задание 5
        Cat kitten = getKitten();
        System.out.println(kitten.getWeight());
        Cat kitten2 = getKitten();
        System.out.println(kitten2.getWeight());
        Cat kitten3 = getKitten();
        System.out.println(kitten3.getWeight());

        //задание 6
        System.out.println("cat6 is " + cat6.getColor());
        cat6.setColor(Colors.BLACK);
        System.out.println("cat6 is " + cat6.getColor());

        //задание 7
        cat7.setColor(Colors.WHITE);
        Cat copy = new Cat(cat7);
        System.out.println("copy " + copy.getWeight() + " " + copy.getColor());
        System.out.println("cat7 " + cat7.getWeight() + " " + cat7.getColor());







    }
}