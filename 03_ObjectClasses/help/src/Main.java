import java.util.Scanner;

public class Main {
    public static final int MAX_BOX = 27;
    public static final int MAX_CONTAINER = 13;

    public static void main(String[] args) {
        int box = 0;
        int container = 1;
        int car = 1;

        System.out.println("Введите кол-во яшиков!");
        Scanner scanner = new Scanner(System.in);
        box = scanner.nextInt();

        for (int i = 1; i < box; i++) {

            if (container % MAX_CONTAINER == 1 && i % MAX_BOX == 1) {
                System.out.println("Грузовик " + car);
                car++;
            }

            if (i % MAX_BOX == 1) {
                System.out.println("\tКонтейнер " + container);
                container++;
            }

            System.out.println("\t\tЯшик " + i);

        }
        System.out.println("Нужно:\t контейнеров = " + (container - 1) + ",  грузовиков = " + (car - 1) );
    }
}
