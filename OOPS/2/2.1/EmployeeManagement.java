import java.util.ArrayList;
import java.util.List;

class Employee{
    int empId;
    String empName;
    double salary;

    public Employee(int empId,String empName,double salary){ // constructor to initialize emp details
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }
}

class Department{
    int depId;
    String depName;
    List<Employee> employee; //empty emp list

    public Department( int depId,String depName){ //// constructor to initialize dept details
        this.depId=depId;
        this.depName=depName;
        this.employee=new ArrayList<>();  // this will holds the employees details of the department
    }

    public void addEmployee(Employee employees){
        employee.add(employees);
    }

    public void showDepartment(){
        System.out.println("Department Name : "+ depName);
        //System.out.println("Employees : ");
        for(Employee emp:employee){ // this will through the all the emp details in department 
            System.out.println("Employee [ Id " + emp.empId + "| Name: "+emp.empName+ "| Salary: "+emp.salary+" ]");
            System.out.println();
        }
    }

    // to limit the employees by their salary
    //public void showEmpSalaryLimit(double limit){
    //    System.out.println("Employees in " + depName + " with salary greater than " + limit + ":");
    //    for(Employee emp: employee){
    //        if(emp.salary>limit){
    //            System.out.println("Employee [ Id " + emp.empId + "| Name: "+emp.empName+ "| Salary: "+emp.salary+" ]");
    //        }
    //    }
    //}

    public double calculateTotalSalary(){
        double total=0;
        for(Employee emp:employee){
            total+=emp.salary;
        }
        return total;
    }

}

class Company{
    String cmpName;
    List<Department> departments; //empty dep list

    public Company(String cmpName){
        this.cmpName=cmpName;
        this.departments=new ArrayList<>(); // this will holds the dept details of the company
    }

    public void addDepartment(Department dept){
        departments.add(dept);
    }

    public void showCompany(){ 
        System.out.println("Company Name : " + cmpName);
        System.out.println();
        //System.out.println("Departments : ");
        for(Department dept:departments){ // this will through the all the dept details in Company 
            dept.showDepartment();
        }
    }

    //public void showCompany(double limit){
    //    System.out.println("Company Name : " + cmpName);
    //    //System.out.println("Departments : ");
    //    for(Department dept:departments){
    //        dept.showEmpSalaryLimit(limit);
    //    }
    //}

    public double calculateCompanyTotalSalary(){
        double total=0;
        for(Department dept:departments){ //Looping through all departments in the company
            total+=dept.calculateTotalSalary();
        }
        return total;
    }
}

public class EmployeeManagement{
    public static void main(String[] args){
        Employee e1=new Employee(1186573, "Divya", 10000);
        Employee e2=new Employee(1297684, "Chandu", 20000);

        //double limit=5000;

        Department d1=new Department(2, "Development");
        Department d2=new Department(2, "Testing");

        d1.addEmployee(e1);
        d2.addEmployee(e2);

        Company company=new Company("Thought Circuits");

        company.addDepartment(d1);
        company.addDepartment(d2);

        company.showCompany();

        //company.showCompany(limit);
        System.out.println("Total Salary :" + company.calculateCompanyTotalSalary());

    }
}
