package OOPBasics;

public class Box {
    double width;
    double height;
    double depth;

    // Regular constructor
    Box(double width, double height, double depth) {
        System.out.println("Constructing box object...");

        // If parameter names are the same as the classes instance variable names.
        // Need to use this.name to reference instance variable rather than local variable.
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    // Clone constructor
    Box(Box ob) {
        width = ob.width;
        height = ob.height;
        depth = ob.depth;
    }

    // Constructor used when no dimensions specified
    Box() {
        width = -1;
        height = -1;
        depth = -1;
    }

    public double volCalc() {
        return depth * width * height;
    }
}
