import java.util.HashMap;

public class CustomerStorage
{
    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data)
    {
        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new IllegalArgumentException("Wrong format! Correct format: \n" +
                    "add Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        if (components[2].matches(".*@.*\\..*") == false) {
            throw new IllegalArgumentException("Wrong email format! Correct email format: vasily.petrov@gmail.com");
        }
        if (components[3].matches("\\+7[0-9]{10}") == false) {
            throw new IllegalArgumentException("Wrong num format! Correct num format: +79215637722");
        }
        String name = components[0] + " " + components[1];
        storage.put(name, new Customer(name, components[3], components[2]));
    }

    public void listCustomers()
    {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name)
    {
        if (storage.containsKey(name) == false) {
            throw new IllegalArgumentException("Wrong format! Correct format: \n" +
                    "remove Василий Петров ");
        }
        storage.remove(name);
    }

    public int getCount()
    {
        return storage.size();
    }
}