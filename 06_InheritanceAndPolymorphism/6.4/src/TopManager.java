public class TopManager implements Employee , Comparable<Employee>{
    final int SUM = 120000;
    int income;

    public TopManager(int income) {
        this.income = income;
    }

    @Override
    public int getMonthSalary() {
        if (income > 10000000) {
            return (int) (SUM + (SUM * 1.5));
        }
        else {
            return SUM;
        }
    }

    @Override
    public int compareTo(Employee employee) {
        return Double.compare(employee.getMonthSalary(), this.getMonthSalary());
    }
}
