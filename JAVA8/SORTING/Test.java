import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

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

//Ascending salary sort
        List<String> sortAsec=employees.stream().sorted(Comparator.comparingDouble((Employee e)->e.salary))
                                        .map(e->e.name+":"+e.salary).collect(Collectors.toList());
        System.out.println("Ascending salary sort : "+sortAsec);
        System.out.println();

//Descending salary sort
        List<String> sortDsec=employees.stream().sorted(Comparator.comparingDouble((Employee e)->e.salary).reversed())
                                        .map(e->e.name+":"+e.salary).collect(Collectors.toList());
        System.out.println("Descending salary sort : "+sortDsec);
        System.out.println();

//Filter employees with salary > salaryLimit
        List<String> salaryLimit=employees.stream().filter((Employee e)->e.salary>30000)
                                        .map(e->e.name+":"+e.salary).collect(Collectors.toList());
        System.out.println("Employees with Salary > 30000 : "+salaryLimit);
        System.out.println();

//Get top "N" highest salaries
        int topNum=2;
        List<String> topNSalaries=employees.stream().sorted(Comparator.comparingDouble((Employee e)->e.salary).reversed())
                                    .limit(topNum).map(e->e.name).collect(Collectors.toList());
        System.out.println("Top " + topNum +" Highest Salaries:" + topNSalaries);
        System.out.println();

//Get "N" Largest salary
        int N=2;
        List<String> topNlargest=employees.stream().sorted(Comparator.comparingDouble((Employee e)->e.salary).reversed())
                                            .skip(N).findFirst().map(e->List.of(e.name+":"+e.salary)).orElse(List.of());
        System.out.println(N+" Largest salary : "+topNlargest);
        System.out.println();

    }
}
