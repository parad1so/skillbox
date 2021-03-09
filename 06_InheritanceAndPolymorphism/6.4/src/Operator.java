public class Operator implements Employee , Comparable<Employee>{

    final int SUM = 60000;

    @Override
    public int getMonthSalary() {
        return SUM;
    }

    @Override
    public int compareTo(Employee employee) {
        if (employee.getMonthSalary() > this.getMonthSalary()) {
            return 1;
        }
        else if (employee.getMonthSalary() < this.getMonthSalary()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
