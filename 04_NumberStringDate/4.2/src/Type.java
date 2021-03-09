public class Type {
    public static void main(String[] args) {
        System.out.println("Int max = " + Integer.MAX_VALUE + "; min = " + Integer.MIN_VALUE);
        System.out.println("Double max = " + Double.MAX_VALUE + "; min = " + -Double.MAX_VALUE);
        System.out.println("Float max = " + Float.MAX_VALUE + "; min = " + -Float.MAX_VALUE);
        System.out.println("Byte max = " + Byte.MAX_VALUE + "; min = " + Byte.MIN_VALUE);
        System.out.println("Short max = " + Short.MAX_VALUE + "; min = " + Short.MIN_VALUE);
        System.out.println("Long max = " + Long.MAX_VALUE + "; min = " + Long.MIN_VALUE);

        double a = 0;
        while (a < 1) {
            a += 0.1;
            System.out.println(a);
        }

    }
}
