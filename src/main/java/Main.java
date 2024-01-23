
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;


public class Main {
    static ArrayList<Employee> employees = new ArrayList<>();

    public static void changeSalary(ArrayList<Employee> arr) {
        for (Employee item : arr) {
            if (item.getAge() > 45) {
                item.setSalary(item.getSalary() + 5000);
            }
        }
    }

    public static void changeSalary(ArrayList<Employee> arr, int age, int increase) {
        for (Employee item : arr) {
            if (item.getAge() > age) {
                item.setSalary(item.getSalary() + increase);
            }
        }
    }

    public static void main(String[] args) {
        employees.add(new Employee(10000, 25));
        employees.add(new Employee(12000, 30));
        employees.add(new Employee(10000, 35));
        employees.add(new Employee(30000, 40));
        employees.add(new Employee(50000, 55));

//        В основной программе создайте руководителя и поместите его в общий массив сотрудников.
//        Повысьте зарплату всем сотрудникам и проследите, чтобы зарплата руководителя не повысилась.

        employees.add(new Employee("Иванов", "Инженер", 123456, 50000, 30, "1990-01-15"));
        employees.add(new Employee("Петров", "Программист", 789012, 60000, 35, "1985-05-20"));

        Manager manager = new Manager("Сидоров", "Руководитель", 654321, 80000, 40, "1980-12-10");
        employees.add(manager);

        System.out.println("Информация о сотрудниках до повышения зарплаты:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        Manager.increaseSalaryExceptManagers(employees, 2000);

        System.out.println("\nИнформация о сотрудниках после повышения зарплаты:");
            for (Employee employee : employees) {
                System.out.println(employee);
            }


        changeSalary(employees);
        for (Employee item : employees) {
            System.out.println(item.toString());
        }
        System.out.println("");
        changeSalary(employees, 30, 2500);
        for (Employee item : employees) {
            System.out.println(item.toString());
        }
        System.out.println("");
        Employee.changeSalary(employees, 30, 1200);
        for (Employee item : employees) {
            System.out.println(item.toString());
        }
        printAverages(employees);

        Optional<Integer> max = employees.stream()
                .map(e -> e.getSalary())
                .max(Comparator.naturalOrder());

        System.out.println(max.map(e -> e * 10).orElseThrow());

        employees.stream()
                .mapToInt(Employee::getSalary)
                .filter(e -> e > 30)
                .average()
                .orElse(0);


        List<String> names = employees.stream()
                .map(e -> {
                    String s = e.getFio();
                    s = s.toUpperCase();
                    s = s.replace("D", "G");
                    return s;
                })
                .toList();

        System.out.println(names);
    }

    public static void printAverages(ArrayList<Employee> employees) {
        int avAge = 0;
        int avSalary = 0;
        for (Employee item : employees) {
            avAge += item.getAge();
            avSalary += item.getSalary();
        }
        System.out.println("Средний возраст равен: " + avAge / employees.size());
        System.out.println("Средняя зарплата равна: " + avSalary / employees.size());
    }

}