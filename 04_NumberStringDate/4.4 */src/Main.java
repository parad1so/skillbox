public class Main {

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        int first = text.indexOf("<");
        int last = text.lastIndexOf(">");

        String n1 = text.substring(0, first);
        String n2 = text.substring(last + 1);

        return n1 + placeholder + n2;
    }

    public static void main(String[] args) {

        String safe = searchAndReplaceDiamonds("Номер кредитной карты <4008 1234 5678> 8912", "***");
        System.out.println(safe);

    }
}
