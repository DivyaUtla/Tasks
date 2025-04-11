
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
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

//Ascending salary sort
    public static ArrayList<Employee> sortSalaryAsec(ArrayList<Employee> employees){
        return employees.stream().sorted(Comparator.comparingDouble((Employee emp)->emp.salary)).collect(Collectors.toCollection(ArrayList::new));
    }

//Descending salary sort
    public static ArrayList<Employee> sortSalaryDsec(ArrayList<Employee> employees){
        return employees.stream().sorted(Comparator.comparingDouble((Employee emp)->emp.salary).reversed())
                                                                                .collect(Collectors.toCollection(ArrayList::new));
    }

//Filter employees with salary > salaryLimit
    public static ArrayList<Employee> salaryLimit(ArrayList<Employee> employees, double salaryLimit){
        return employees.stream().filter((Employee emp)->emp.salary>salaryLimit).collect(Collectors.toCollection(ArrayList::new));
    }

//Get Employee names with salary > salaryLimit
    public static ArrayList<String> salaryLimitEmp(ArrayList<Employee> employees, double salaryLimit){
        return employees.stream().filter((Employee emp)->emp.salary>salaryLimit).map((Employee emp)->emp.empName)
                                                                                .collect(Collectors.toCollection(ArrayList::new));
    }

//Get top N highest salaries
    public static ArrayList<Employee> TopEmpList(ArrayList<Employee> employees,int topNum){
        return employees.stream().sorted(Comparator.comparingDouble((Employee emp)->emp.salary).reversed()).limit(topNum)
                                                                                .collect(Collectors.toCollection(ArrayList::new));
    }

//Get Largest salary
    public static Optional<Employee> findLargest(ArrayList<Employee> employees, int num){  
    return employees.stream().sorted(Comparator.comparingDouble((Employee emp)->emp.salary).reversed()).skip(num).findFirst();
    }

    public static ArrayList<Employee> removeDups(ArrayList<Employee> employees){
        return employees.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
    }

    public static void main(String[] args) {
        ArrayList<Employee> employees=new ArrayList<>();
        employees.add(new Employee("Divya", 50000));
        employees.add(new Employee("Shanaya", 25000));
        employees.add(new Employee("Tinku", 10000));
        employees.add(new Employee("Lekhana", 25100));
        employees.add(new Employee("Tinku", 10000));

        System.out.println("\n1. Salary sorted in Ascending Order :");
        sortSalaryAsec(employees).forEach(System.out::println);

        System.out.println("\n2. Salary sorted in Descending Order :");
        sortSalaryDsec(employees).forEach(System.out::println);

        double salaryLimit = 24000;
        System.out.println("\n3. Employees with Salary > "+salaryLimit +" : ");
        salaryLimit(employees, salaryLimit).forEach(System.out::println);

        System.out.println("\n4. Employee names with Salary > "+salaryLimit +" : ");
        salaryLimitEmp(employees, salaryLimit).forEach(System.out::println);

        int topNum=2;
        System.out.println("\n5. Top" + topNum +" Highest Salaries:");
        TopEmpList(employees, topNum).forEach(System.out::println);

        int num=3;
        System.out.println("\n6. Employee with Largest salary");
        findLargest(employees,num).ifPresentOrElse(
            emp -> System.out.println(emp),
            () -> System.out.println("Not enough employees")
        );

        System.out.println("\n7. Remove duplicates : ");
        removeDups(employees).forEach(System.out::println);
    }
}