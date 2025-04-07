
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

class Employee{
    String empName;
    double salary;

    public Employee(String empName,double salary){
        this.empName=empName;
        this.salary=salary;
    }

    @Override
    public String toString(){
        return empName + " - " + salary;
    }
}

public class SortJava8{
    public static ArrayList<Employee> SortingUsingJava8(ArrayList<Employee> employees){  
    return employees.stream().sorted(Comparator.comparingDouble((Employee emp)->emp.salary).reversed())
                                                              .collect(Collectors.toCollection(ArrayList::new)); //asec

    //return employees.stream().sorted(Comparator.comparingDouble((Employee emp)->emp.salary).reversed())
                                                              //  .collect(Collectors.toCollection(ArrayList::new)); //dsec

    //return employees.stream().filter((Employee emp)->emp.salary>30000).collect(Collectors.toCollection(ArrayList::new)); //limit by salary

    //return employees.stream().filter((Employee emp)->emp.salary>25000).map((Employee emp)->emp.empName)
    //.collect(Collectors.toCollection(ArrayList::new)); //return only emp names used type ArrayList<String> instead of ArrayList<Employee>

    //return employees.stream().sorted(Comparator.comparingDouble((Employee emp)->emp.salary).reversed()).limit(3)
    //.collect(Collectors.toCollection(ArrayList::new)); //limited to top 3 highest

    }

    public static void main(String[] args) {
        ArrayList<Employee> employees=new ArrayList<>();
        employees.add(new Employee("Divya", 50000));
        employees.add(new Employee("Shanaya", 25000));
        employees.add(new Employee("Tinku", 10000));
        employees.add(new Employee("Lekhana", 25100));

        ArrayList<Employee> sortedEmployees=SortingUsingJava8(employees);

        for(Employee emp:sortedEmployees){
            System.out.println(emp);
        }

    }

}