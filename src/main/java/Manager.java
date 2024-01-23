import java.util.ArrayList;

public class Manager extends Employee {
    public Manager(String fio, String position, int phone, int salary, int age, String birthDate) {
        super(fio, position, phone, salary, age, birthDate);
    }

    public static void increaseSalaryExceptManagers(ArrayList<Employee> employees, int increase) {
        for (Employee employee : employees) {
            if (!(employee instanceof Manager)) {
                employee.setSalary(employee.getSalary() + increase);
            }
        }
    }
}
