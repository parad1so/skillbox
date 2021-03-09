public class GeometryCalculator {
    //метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {
        //Площадь круга вычисляется по формуле = PI*radius*radius
        return Math.PI * (Math.abs(radius) * Math.abs(radius));
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {
        return ( 4.0 / 3.0 ) * Math.PI * Math.pow( Math.abs(radius), 3 );
    }

    public static boolean isTriangleRightAngled(double a, double b, double c) {
        return a + b > c & a + c > b & b + c > a;
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTriangleRightAngled, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        if (isTriangleRightAngled(a, b, c)) {
            double pp = (a + b + c) / 2.0;  // полупериметр
            return Math.sqrt(pp * (pp - a) * (pp - b) * (pp - c)); // прямо по формуле Герона
        }
        else return -1.0;
    }

}
