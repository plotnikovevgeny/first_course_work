import java.util.Objects;

public class Employee {
    private static int count;
    private final String initials;
    private final int id;
    private int department;
    private int salary;


    public Employee(String initials, int department, int salary) {
        this.initials = initials;
        this.department = department;
        this.salary = salary;
        this.id = count;
        count++;

    }

    public String getInitials() {
        return initials;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ФИО сотрдуника='" + initials + '\'' + ", Отдел '" + department + '\'' + ", Заработная плата " + salary + ", id " + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && id == employee.id && Objects.equals(initials, employee.initials);
    }

    @Override
    public int hashCode() {
        return Objects.hash(initials, department, salary, id);
    }
}
