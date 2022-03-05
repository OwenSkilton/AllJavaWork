package OOPBasics;

public class BoxWeight extends Box {

    double weight;

    BoxWeight(double width, double height, double depth, double weight) {
        super(width, height, depth);
        // Super refers to the immediate superclass constructor and can inherit private members as well??? (Maybe?)
        // This causes the OOPBasics.Box() constructor to be called and initialises width, height, depth. These values can then be private if desired
        this.weight = weight;
    }

    // Clone constructor
    BoxWeight(BoxWeight ob) {
        super(ob);
        weight = ob.weight;
    }

    BoxWeight() {
        super();
        weight = -1;
    }

}
