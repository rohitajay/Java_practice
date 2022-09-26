/*
Create an application for employee management having following classes: 
Create an Employee class with following attributes and behaviors : i) EmpId Int ii) EmpName String iii) EmpEmail String iv) EmpGender char v) EmpSalary float vi) GetEmployeeDetails() -> prints employee details
Create one more class EmployeeDB which has the following methods. i) boolean addEmployee(Employee e) ii) boolean deleteEmployee(int empId) iii) String showPaySlip(int empId) iv) Employee[] listAll()
Do implementation of the above application with below two methods : I. Use an ArrayList which will be used to store the employees and use enumeration/iterator to process the employees. II. Use a TreeSet Object to store employees on the basis of their EmpId and use enumeration/iterator to process employees. [Hint: Use Comparable interface] Write a Test Program to test that all functionalities are operational.
*/

package Assignment1;


// Employee Class

import java.util.*;

import static Assign1.Employee.arrayList;
import static Assign1.Employee.getEmployeeDetails;

class Employee{
    private int empId;
    private String empName;
    private String empEmail;
    private char empGender;
    private float empSalary;
    static ArrayList<Employee> arrayList = new ArrayList<>();

    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public String getEmpEmail(){
        return empEmail;
    }
    public void setEmpEmail(String empEmail){
        this.empEmail = empEmail;
    }
    public char getEmpGender(){
        return empGender;
    }
    public void setEmpGender(char empGender){
        this.empGender = empGender;
    }
    public float getEmpSalary(){
        return empSalary;
    }
    public void setEmpSalary(float empSalary){
        this.empSalary = empSalary;
    }
    public int getEmpId(){
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public Employee(int empId, String empName, String empEmail, char empGender, float empSalary){
        this.empId = empId;
        this.empName= empName;
        this.empEmail = empEmail;
        this.empGender = empGender;
        this.empSalary = empSalary;
    }

    public String toString() {
        return "Employee{" +
                "empId=" + empName + '\'' +
                ", empEmail=" + empEmail + '\'' +
                ", empGender=" + empGender + '\'' +
                ", empSalary=" + empSalary +
                '}';
    }

    public static void getEmployeeDetails(){
        Iterator<Employee> it = arrayList.iterator();
        while (it.hasNext()){
            Employee e = it.next();
            System.out.println(e + " ");
        }
    }
}

class EmployeeDB {

    boolean addEmployee(int e) {
        Iterator<Employee> it = arrayList.iterator();
        boolean check = true;
        while(it.hasNext()){
            Employee emp = it.next();
            if(emp.getEmpId()==e){
                check = false;
            }
        }
        return check;
    }

    //deleting employee
    boolean deleteEmployee(int empId) {
        Iterator<Employee> it = arrayList.iterator();
        boolean check = true;
        while(it.hasNext()) {
            Employee emp = it.next();
            if (emp.getEmpId()== empId){
                check = false;
            }
        }
        return check;
    }

    public void showPaySlip(int empId) {
        Iterator<Employee> it = arrayList.iterator();
        while (it.hasNext()){
            Employee emp = it.next();
            if (emp.getEmpId() == empId){
                System.out.println(emp);
            }
        }
    }
}

class Q2TreeSet {
    static Set<Employee> empTreeSet = new TreeSet<Employee>();
    public boolean addEmployee(Employee e) {
        return empTreeSet.add(e);
    }
    public boolean deleteEmployee(Integer empId) {
        Iterator<Employee> it = empTreeSet.iterator();

        while (it.hasNext()) {
            Employee e = it.next();
            if (e.getEmpId() == empId) {
                return empTreeSet.remove(e);
            }
        }
        return false;
    }

    public String showPaySlip(Integer empId) {
        Iterator<Employee> it = empTreeSet.iterator();
        String paySlip;
        while (it.hasNext()) {
            Employee e = it.next();
            if (e.getEmpId() == empId){
                paySlip = "Name: " + e.getEmpName() + "\nEmail: " + e.getEmpEmail()
                        + "\nGender: " + e.getEmpGender() + "\nSalary: "
                         + e.getEmpSalary();
                return paySlip;
            }
        }
        return null;
    }

    Employee[] listAll() {
        int index = 0;
        Employee[] emp = new Employee[empTreeSet.size()];
        Iterator it = empTreeSet.iterator();
        while (it.hasNext()) {
            Employee e = (Employee) it.next();
            emp[index++] = e;
        }
        return emp;
    }
}

public class Q2 {
    public static void main(String[] args){
        EmployeeDB objDB = new EmployeeDB();

        Scanner sc = new Scanner(System.in);
        int option;
        ArrayList<Employee> arrayList = new ArrayList<>();
        arrayList.add(new Employee(0, "Raj", "raj@raj.com",'M', 20003));
        arrayList.add(new Employee(1, "Raja", "raja@raj.com",'F', 20030));
        arrayList.add(new Employee(2, "Rajaa", "rajaa@raj.com",'M', 20030));
        arrayList.add(new Employee(3, "Rajaaa", "rajaaa@raj.com",'F', 20300));
        arrayList.add(new Employee(4, "Rajaaaa", "rajaaaa@raj.com",'M', 20000));

        do {
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Show All Employee");
            System.out.println("4. Payslip Operation");
            System.out.println("0: Exit");
            System.out.println();
            System.out.println("-----------------------");
            System.out.println("Please Enter an Option :----------Please press 0 to exit---------");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter Id, Name, Email, Gender, Salary :");
                    int id = sc.nextInt();
                    String name = sc.next();
                    String email = sc.next();
                    char gender = sc.next().charAt(0);
                    double salary = sc.nextDouble();
                    boolean result = objDB.addEmployee(id);
                    if(result) {
                        arrayList.add(new Employee(id,name,email,gender, (float) salary));
                        System.out.println("Employee is Added");
                    } else{
                        System.out.println("Employee already Exists");
                    }
                    break;

                case 2:
                    System.out.println("Enter employee Id to delete :");
                    int del_id = sc.nextInt();
                    boolean deletedEmp = objDB.deleteEmployee(del_id);
                    if(deletedEmp) {
                        arrayList.remove(del_id);
                    }
                    System.out.println("Employee is Deleted");

                case 3:
                    System.out.println("All Employee Details : ");
                    getEmployeeDetails();
                    break;
                case 4:
                    System.out.println("Enter Employee id to check details : ");
                    int employee_id = sc.nextInt();
                    objDB.showPaySlip(employee_id);

                case 0:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please enter correct option");
            }
        } while (option != 0);






    }
}
