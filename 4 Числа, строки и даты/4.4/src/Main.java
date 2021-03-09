import java.util.Scanner;

public class Main {
    //4.4 задание1
    public static void main(String[] args) {
        for(char i = 'A'; i <= 'Z'; i++) {
            System.out.println(i + " = " + (int) i);
        }
        for(char i = 'a'; i <= 'z'; i++) {
            System.out.println(i + " = " + (int) i);
        }


        //4.4 задание3
        boolean check = true;
        while (check) {
            scan();
            try {
                int space = name.indexOf(" ");
                int spaceEnd = name.lastIndexOf(" ");
                String name1 = name.substring(0, space).trim();
                String name2 = name.substring(space, spaceEnd).trim();
                String name3 = name.substring(spaceEnd).trim();
                if (name2 != "") {
                    System.out.println("Фамилия: " + name1);
                    System.out.println("Имя: " + name2);
                    System.out.println("Отчество: " + name3);
                    check = false;
                }
                else {
                    check = true;
                }
            } catch (Exception e) {
                check = true;
            }
        }

    }

    static public String name;

    static public String scan() {
        System.out.println("задание2");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя фамилию и отчество через пробел");
        name = scanner.nextLine();
        return name;
    }

}
