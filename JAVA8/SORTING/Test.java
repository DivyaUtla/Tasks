import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

public class Test {
    public static void main(String[] args) {
        ArrayList<Employee> employees=new ArrayList<>();
        employees.add(new Employee("Divya", 50000));
        employees.add(new Employee("Shanaya", 25000));
        employees.add(new Employee("Tinku", 10000));
        employees.add(new Employee("Lekhana", 25100));

        //want to find second largest salary 
        Optional<Employee> sortedEmployees=employees.stream().sorted(Comparator.comparingDouble((Employee emp)->emp.salary).reversed())
        .skip(2).findFirst();
        
        sortedEmployees.ifPresent(emp->System.out.println("Second highest: " + emp.name + " - " + emp.salary));
    }
}
