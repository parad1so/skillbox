public class Manager implements Employee , Comparable<Employee>{

    final int MAXPROFIT = 140000;
    final int MINPROFIT = 115000;
    int result;

    @Override
    public int getMonthSalary() {
        result = MAXPROFIT - MINPROFIT;
        return (int) ((Math.random() * result) + MINPROFIT);
    }

    @Override
    public int compareTo(Employee employee) {
        return Double.compare(employee.getMonthSalary(), this.getMonthSalary());
    }
}
