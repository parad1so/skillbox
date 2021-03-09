public class Main
{
    public static void main(String[] args)
    {
        Container container = new Container();
        container.count += 7843;


        System.out.println(sumDigits(12345));
        System.out.println(sumDigits(10));
        System.out.println(sumDigits(5059191));

    }

    public static Integer sumDigits(Integer number){
        int sum = 0;
        String num = Integer.toString(number);

        for (int i=0; i<num.length(); i++) {
            sum = sum + Integer.parseInt(String.valueOf(num.charAt(i)));
        }
        return sum;
    }

   /* Задание под звездочкой
   public static Integer sumDigits(Integer number)
    {
        int sum = 0;
        String num = Integer.toString(number);

        for (int i=0; i<num.length(); i++) {
             sum = sum + Character.getNumericValue(num.charAt(i));
        }

        return sum;
    }

    */


}
