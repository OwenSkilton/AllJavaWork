package OOPBasics;

import java.util.Scanner;

public class Box_Basics {
    static Scanner stdin = new Scanner(System.in);

    public static void main(String[] args) {
        // Class is effectively a new data type whose parameters we can customize
        // Class is a template for an object and an object is an instance of a class
        // Data or variables defined within a class are called instance variables

        //Now we initialise myBox using the template class 'OOPBasics.Box' from the class within the package 'com.ooconcepts'
        // This package is done to declutter code, easier testing and compartmentalise programme logic

        BoxWeight myBox1 = new BoxWeight(10.0, 20.0, 15.0, 34.3);
        BoxWeight myBox2 = new BoxWeight(3, 6, 9, 0.076);
        BoxWeight myBox3 = new BoxWeight();
        BoxWeight myBoxClone = new BoxWeight(myBox1);


        double vol = myBox1.volCalc();
        System.out.println("Volume of Box1: " + vol);
        vol = myBox2.volCalc();
        System.out.println("Volume of Box2: " + vol);
        vol = myBox3.volCalc();
        System.out.println("Volume of Box3: " + vol);
        vol = myBoxClone.volCalc();
        System.out.println("Volume of OOPBasics.Box Clone: " + vol);

        System.out.println("\nWeight of Box1: " + myBox1.weight);
        System.out.println("Weight of Box2: " + myBox2.weight);
        System.out.println("Weight of Box3: " + myBox3.weight);
        System.out.println("Weight of OOPBasics.Box Clone: " + myBoxClone.weight);
    }
}

