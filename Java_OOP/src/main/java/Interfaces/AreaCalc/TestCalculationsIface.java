package Interfaces.AreaCalc;

import Interfaces.AreaCalc.Calculations;

public class TestCalculationsIface {
    public static void main(String[] args){
        Calculations myCalc = new Calculations();
        System.out.println("Area of a square with side = 5: "+ myCalc.areaSquare(5));
        System.out.println("Area of a Rectangle with sides = 5 & 7: "+ myCalc.areaRectangle(5, 7));
        System.out.println("Area of a Circle with radius = 2: "+ myCalc.areaCircle(2));
        System.out.println("Length of hypotenuse with sides = 5 & 12: "+ myCalc.pythagHypot(5, 12));
    }
}
