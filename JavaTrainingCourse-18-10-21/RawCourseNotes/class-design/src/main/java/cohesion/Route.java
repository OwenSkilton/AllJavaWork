package cohesion;

public class Route {

    private int startingX;
    private int startingY;
    private int endingX;
    private int endingY;

    public Route(int startingX, int startingY, int endingX, int endingY) {
        this.startingX = startingX;
        this.startingY = startingY;
        this.endingX = endingX;
        this.endingY = endingY;
    }

    // What's wrong with this?
    // It makes the class non-cohesive
    // Cohesion speaks to whether the class's fields and methods belong
    // Ask yourself the following questions:
    // 1. Are the fields related to one another?
    // 2. Do the methods operate on the fields?
    // 3. Does the class have static methods?
    // Static methods are not necessarily a sign of a non-cohesive class but often are
    public static double milesToKms(double miles) {
        return miles * 1.6;
    }
}
