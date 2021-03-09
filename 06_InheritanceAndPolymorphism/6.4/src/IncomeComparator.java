import java.util.Comparator;

class IncomeComparator implements Comparator <Employee>{

    @Override
    public int compare(Employee employee, Employee t1) {
        if (employee.getMonthSalary() > t1.getMonthSalary()) {
            return 1;
        }
        else if (employee.getMonthSalary() < t1.getMonthSalary()) {
            return -1;
        }
        else {
            return 0;
        }
    }

}
