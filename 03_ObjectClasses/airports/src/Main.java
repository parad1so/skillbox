import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;

import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Airport airport = Airport.getInstance();
        System.out.println("Перечесление самолетов:");
        System.out.println(airport.getAllAircrafts());
        List<Aircraft> list = airport.getAllAircrafts();
        System.out.println(" ");

        System.out.println("Всего самолетов в аэропорту: " + list.size());
        System.out.println("Последний: " + list.get(list.size() - 1));
    }
}
