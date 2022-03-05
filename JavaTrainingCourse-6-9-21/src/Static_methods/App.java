package Static_methods;

public class App {

    public static void main(String[] args) {
        EmploymentContract employeeContract = new EmploymentContract(15, 37.5);
        System.out.println(employeeContract.annualNetSalary());
    }
}
