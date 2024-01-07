import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int id;
    Employee(String name,int id){
        this.name = name;
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    abstract double calculateSalary();
    @Override
    public String toString(){
        return "EMPLOYEE [Name= "+name+", id= "+id+", Salary= "+calculateSalary()+"]";
    }
}

class FullTimeEmployee extends Employee{
    private double monthlySalary;
    FullTimeEmployee(String name, int id, double monthlySalary){
        super(name,id);
        this.monthlySalary = monthlySalary;
    }
    @Override
    public double calculateSalary(){
        return this.monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    private double hourlySalary;
    private int hoursWorked;
    PartTimeEmployee(String name, int id, int hoursWork,double hourlySalary){
        super(name,id);
        this.hourlySalary = hourlySalary;
        this.hoursWorked = hoursWork;
    }
    @Override
    public double calculateSalary(){
        return hourlySalary*hoursWorked;
    }
}

class PayrollSystem{
    private ArrayList<Employee> employeeList;
    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for (Employee employee:employeeList){
            if (employee.getId()==id){
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }
        else {
            System.out.println("Employee doesn't exist");
        }
    }
    public void displayEmployees(){
        for (Employee employee: employeeList){
            System.out.println(employee);     //not using .toString method but still its working..?
        }
        System.out.println();
    }
    public int size(){
        return employeeList.size();
    }
}

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Mahesh",1,90000);
        PartTimeEmployee emp2 = new PartTimeEmployee("Vijay",2,120,100);
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("Initial employees details:");
        payrollSystem.displayEmployees();
        System.out.println("number of employees: "+payrollSystem.size());
        payrollSystem.removeEmployee(1);
        System.out.println("Removed 1st");
        payrollSystem.displayEmployees();
        System.out.println("number of employees: "+payrollSystem.size());
        payrollSystem.removeEmployee(3);
    }
}