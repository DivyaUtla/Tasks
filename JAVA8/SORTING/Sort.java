
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//ASK : Write code to sort the list of employees by salary using built in methods.

class Employee{
    String empName;
    double empSalary;

    public Employee(String empName,double empSalary){
        this.empName=empName;
        this.empSalary=empSalary;
    }

    @Override
    public String toString(){
        return empName + "-" + empSalary;
    }
}

public class Sort{
    public static ArrayList<Employee> Sorting(ArrayList<Employee> employees){
        ArrayList<Employee> resultArray=new ArrayList<>(employees);
        Collections.sort(resultArray, Comparator.comparingDouble((Employee emp)->emp.empSalary)); //asecending order
        Collections.sort(resultArray, Comparator.comparingDouble((Employee emp)->emp.empSalary).reversed());//desc
        return resultArray;
    }

    public static void main(String[] args) {
        ArrayList<Employee> employees=new ArrayList<>();
        employees.add(new Employee("Divya", 50000));
        employees.add(new Employee("Shanaya", 25000));
        employees.add(new Employee("Tinku", 10000));
        employees.add(new Employee("Lekhana", 25100));
        //arr.add(1); arr.add(4);arr.add(8);arr.add(2);arr.add(5);//arr={1,4,8,2,5}
        ArrayList<Employee> sortedEmployees=Sorting(employees);
        for(Employee emp:sortedEmployees){
            System.out.println(emp);
        }
    }
}