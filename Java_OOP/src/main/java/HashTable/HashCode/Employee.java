package HashTable.HashCode;

public class Employee {
    private int empNo;
    private String name;

    public Employee(int empNo, String name){
        this.setEmpNo(empNo);
        this.setName(name);
    }


    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
