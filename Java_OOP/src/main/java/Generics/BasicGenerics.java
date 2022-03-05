package Generics;

public class BasicGenerics {

    // Generics = parameterized types
    // Parameterized types enable you to create classes, interfaces and methods
    // where the type of data which they operate is specified as a parameter
    // Can create a single class that automatically work with different data types

    // *************** Non generic example: ***************
    public static class NonGen{
        Object ob; // Object is technically a data type

        // Pass the constructor a reference to an object of data type 'Object'
        NonGen(Object o){
            ob = o;
        }
        Object getOb(){
            return ob; // Return data type object
        }
        //Show type of ob
        void showType(){
            System.out.println("Type of ob is " + ob.getClass().getName());
        }
    }

    // *************** Generic example: ***************

    public static class Generic <T>{
        // This T replaces the object data type example and we pass the data we want which over rides T
        T ob; // Declaring an object of type T

        // Pass the constructor a reference to an object of type T
        Generic(T o){
            ob = o;
        }
        T getOb(){
            return ob;
        }
        void showType(){
            System.out.println("Type of T is " + ob.getClass().getName());
        }
    }

    // *************** Two Generic example: ***************

    public static class TwoGeneric <T, V>{
        // This T replaces the object data type example and we pass the data we want which over rides T
        T ob1; // Declaring an object of type T
        V ob2;

        // Pass the constructor a reference to an object of type T
        TwoGeneric(T o1, V o2){
            ob1 = o1;
            ob2 = o2;
        }
        T getOb1(){
            return ob1;
        }
        V getOb2(){
            return ob2;
        }
        void showTypes(){
            System.out.println("Type of T is " + ob1.getClass().getName());
            System.out.println("Type of V is " + ob2.getClass().getName());
        }
    }

    public static void main(String[] args){

        // *************** Non generic example: ***************

        // Integer example
        NonGen intOb = new NonGen(88);
        intOb.showType();
        int v = (Integer) intOb.getOb();
        System.out.println("Value: " + v);

        // String example
        NonGen strOb = new NonGen("Non-Generics Test");
        strOb.showType();
        String v2 = (String) strOb.getOb();
        System.out.println("Value: " + v2);

        // *************** Generic example: ***************

        Generic<Integer> intOb2 = new Generic<Integer>(99);
        intOb2.showType();
        v = intOb2.getOb();
        System.out.println("Value: " + v);

        Generic<String> strOb2 = new Generic<String>("Generics Test");
        strOb2.showType();
        v2 = strOb2.getOb();
        System.out.println("Value: " + v);

        // *************** Two Generic example: ***************

        TwoGeneric<Integer, String> intStrOb = new TwoGeneric<Integer, String>(99, "Two generic example");
        intStrOb.showTypes();
        v = intStrOb.getOb1();
        System.out.println("Value: " + v);
        v2 = intStrOb.getOb2();
        System.out.println("Value: " + v2);
    }
}
