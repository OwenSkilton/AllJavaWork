package Inheritance;

public class Basic_Inheritance {
    public static void main(String[] args) {


        // Inheritance is a fundamental of OOP as it allows the creation of hierarchical classifications
        // You can create a general class that defines common traits. This can then be inherited by other
        // more specific classes, adding things that are unique to fit

        Classes_for_inheritance.A superObj = new Classes_for_inheritance.A();
        Classes_for_inheritance.B subObj = new Classes_for_inheritance.B();

        superObj.i = 10;
        superObj.j = 20;
        superObj.showij();

        subObj.i = 7;
        subObj.j = 8;
        subObj.k = 9;
        subObj.showij();
        subObj.showk();
        System.out.println();
        subObj.sum();
    }
}
