import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {

    int income;

    public List staff = new ArrayList<>();


    public Company (int in) {
        this.income = in;
    }

    public void hire(Employee em) {
        staff.add(em);
    }

    public void hireAll(ArrayList em) {
        staff.addAll(em);
    }

    public void fire(Employee em) {
        staff.remove(em);
    }

    public int getIncome() {
        return this.income;
    }

    public int getStaff() {
        return staff.size();
    }

    public List<Employee> getTopSalaryStaff(int count) {
        Collections.sort(staff);
        List out = new ArrayList<>();
        for (int i = 0; count > i; i++) {
            out.add(i, (Employee) staff.get(i));
            System.out.println(((Employee) staff.get(i)).getMonthSalary());
        }
        Collections.sort(out);
        return out;
    }

    public List<Employee> getLowestSalaryStaff(int count){
        Collections.sort(staff);
        List out = new ArrayList<>();
        int counter = 0;
        for (int i = (staff.size() - 1); (staff.size() - count) < i; i--) {
            out.add(counter, (Employee) staff.get(i - 1));
            System.out.println(((Employee) staff.get(i - 1)).getMonthSalary());
            counter++;
        }
        Collections.sort(out);
        return out;
    }



}
