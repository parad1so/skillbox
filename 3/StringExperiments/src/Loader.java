
public class Loader
{
    public static void main(String[] args)
    {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        String vasia = text.substring(text.indexOf("5"), text.indexOf("5") + 4 );
        String masha = text.substring(text.lastIndexOf("3"), text.lastIndexOf("3") + 5);

        int sum = Integer.parseInt(vasia) + Integer.parseInt(masha);
        System.out.println("сумма васи и маши = " + sum);
    }
}