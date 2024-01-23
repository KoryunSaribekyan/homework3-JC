import java.util.Comparator;
import java.util.ArrayList;

public class Employee{
    private String fio;
    private String position;
    private int phone;
    private int salary;
    private int age;
    private String birthDate;



    public Employee(String fio, String position, int phone, int salary, int age) {
        this.fio = fio;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public Employee(int salary, int age) {
        this.fio = "default";
        this.position = "default";
        this.phone = 100;
        this.salary = salary;
        this.age = age;
    }
    public Employee(String fio, String position, int phone, int salary, int age, String birthDate) {
        this.fio = fio;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
        this.birthDate = birthDate;
    }




    public static void changeSalary(ArrayList<Employee> employees, int age, int increase){
        for (Employee item: employees){
            if(item.getAge() > age){
                item.setSalary(item.getSalary()+increase);
            }
        }
    }

    public static Comparator<Employee> dateComparator = (e1, e2) -> {
        int date1 = Integer.parseInt(e1.getBirthDate().replace("-", ""));
        int date2 = Integer.parseInt(e2.getBirthDate().replace("-", ""));
        return Integer.compare(date1, date2);
    };


    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "fio='" + fio + '\'' +
                ", position='" + position + '\'' +
                ", phone=" + phone +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
    public void info(){
        System.out.println(this.toString());
    }
    public void info_format(){
        System.out.println(String.format("%s", this));
    }
}