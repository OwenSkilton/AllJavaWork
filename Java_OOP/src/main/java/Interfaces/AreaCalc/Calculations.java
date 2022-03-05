package Interfaces.AreaCalc;

public class Calculations implements AreaCalculation {

    @Override
    public double areaCircle(double radius){
        return 3.14 * radius * radius;
    }

    @Override
    public double areaRectangle(double length, double breadth) {
        return length * breadth;
    }

    @Override
    public double areaSquare(double side) {
        return side * side;
    }

    @Override
    public double pythagHypot(double sideA, double sideB) {
        return Math.sqrt((sideA*sideA) + (sideB * sideB));
    }
}
