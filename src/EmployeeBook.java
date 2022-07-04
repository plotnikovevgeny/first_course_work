import java.util.Arrays;

public class EmployeeBook {
    private final Employee[] employees;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }


    public void addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                break;
            }
        }
    }

    public void createEmployee(String initials, int department, int salary) {
        Employee employee = new Employee(initials, department, salary);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                break;
            }
        }
    }

    public void removeEmployee(String initials) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getInitials().equals(initials)) {
                employees[i] = null;
                break;
            }
        }
    }

    public void removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                employees[i] = null;
                break;
            }
        }
    }

    public int getSumSalary() {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public int getAverageSalary() {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                count++;
            }
        }
        return getSumSalary() / count;
    }

    public Employee getEmployeeWithMaxSalary() {
        int salary = 0;
        Employee employee = null;
        for (Employee emp : employees) {
            if (emp != null && emp.getSalary() > salary) {
                salary = emp.getSalary();
                employee = emp;
            }
        }
        return employee;
    }

    public Employee getEmployeeWithMinSalary() {
        int salary = getEmployeeWithMaxSalary().getSalary();
        Employee employee = null;
        for (Employee employee1 : employees) {
            if (employee1 != null && employee1.getSalary() < salary) {
                salary = employee1.getSalary();
                employee = employee1;
            }
        }
        return employee;
    }

    public void getInitialsForAllEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getInitials());
            }
        }
    }

    public void setSalaryIndexationForAllEmployee(double bet) {
        for (Employee employee : employees) {
            if (employee != null) {
                double newSalary = employee.getSalary() * (1 + (bet / 100));
                employee.setSalary((int) newSalary);
            }
        }
    }

    public Employee getEmployeeWithMaxSalaryForDepartment(int department) {
        int salary = 0;
        Employee employee = null;
        for (Employee emp : employees) {
            if (emp != null && emp.getSalary() > salary && emp.getDepartment() == department) {
                salary = emp.getSalary();
                employee = emp;
            }
        }
        return employee;
    }

    public Employee getEmployeeWithMinSalaryForDepartment(int department) {
        int salary = getEmployeeWithMaxSalaryForDepartment(department).getSalary();
        Employee employee = null;
        for (Employee employee1 : employees) {
            if (employee1 != null && employee1.getSalary() < salary && employee1.getDepartment() == department) {
                salary = employee1.getSalary();
                employee = employee1;
            }
        }
        return employee;
    }

    public int getSumSalaryForDepartment(int department) {
        int sumSalary = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                sumSalary += employee.getSalary();
            }
        }
        return sumSalary;
    }

    public void setSalaryIndexationForDepartment(int department, double bet) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                double newSalary = employee.getSalary() * (1 + (bet / 100));
                employee.setSalary((int) newSalary);
            }
        }
    }

    public void getInfoFromDepartment(int department) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department)
                System.out.println("ФИО " + employee.getInitials() + ", Заработная плата " + employee.getSalary() + ", id сотрудника " + employee.getId());
        }
    }

    public void setSalaryForEmployee(String initials, int newSalary) {
        Employee employee = getEmployee(initials);
        employee.setSalary(newSalary);
    }

    public void setDepartmentForEmployee(String initials, int department) {
        Employee employee = getEmployee(initials);
        employee.setDepartment(department);
    }

    private Employee getEmployee(String initials) {
        Employee employee = null;
        for (Employee employee1 : employees) {
            if (employee1 != null && employee1.getInitials().equals(initials))
                employee = employee1;
        }
        return employee;
    }

    public void getInfo() {
        int[] departments = {1, 2, 3, 4, 5};
        for (int department : departments) {
            System.out.println("Департамент " + department);
            getInfoFromDepartment(department);
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Employee employee : employees)
            if (employee != null)
                string.append(employee).append("\n");
        return string.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeBook that = (EmployeeBook) o;
        return Arrays.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(employees);
    }
}

