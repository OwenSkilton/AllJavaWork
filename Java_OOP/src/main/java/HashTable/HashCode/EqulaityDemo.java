package HashTable.HashCode;

public class EqulaityDemo {
    public static void main(String[] args) {
        //2 instances of the employee class
        Employee emp1 = new Employee(102, "Gareth");
        Employee emp2 = new Employee(102, "Gareth");
        Employee emp3 = emp1;
        //Invoking hashCode() method
        int a = emp1.hashCode();
        int b = emp2.hashCode();
        System.out.println("Hash code of emp1: " + a);
        System.out.println("Hash code of emp2: " + b);
        System.out.println("Comparing objects emp1 and emp2 = " + emp1.equals(emp2));
        System.out.println("emp1 == emp2 is: " + (emp1 == emp2));
        System.out.println("emp1 == emp3 is: " + (emp1 == emp3));

    }
}
