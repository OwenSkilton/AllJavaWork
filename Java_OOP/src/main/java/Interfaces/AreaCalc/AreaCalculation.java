package Interfaces.AreaCalc;

public interface AreaCalculation {


    //Abstract means a basic form for a method that will be change depending on the child class that inherits the parent.
    //What a class must do but not how it does it
    //Abstract classes can have non abstract methods where as Interfaces are purely abstract methods regardless.
    //Abstract methods that we are overwriting later using @Override:

    double areaSquare(double side);
    double areaCircle(double radius);
    double areaRectangle(double length, double breadth);
    double pythagHypot(double sideA, double sideB);
}