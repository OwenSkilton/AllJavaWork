package Interfaces.IntStack;

interface IntStack {
    void push(double item); //Store an item
    double pop(); //Retrieve an item
}
interface Volumes{
    double sphereVol(double radius);
    double cubeVol(double side);
    double coneVol(double radius, double height);
    double cylinderVol(double radius, double height);
}

// Can either assign multiple interfaces to a class or can simply extend the first interface onto the 2nd
// Instead of implement IntStack, Volumes. Could extend IntStack onto Interface Volumes and define the methods pop & push within there
class VolumesCalc implements IntStack, Volumes{

    private double stck[];
    private int tos;
    VolumesCalc(int size){ //Constructor
        stck = new double[size];
        tos = -1;
    }

    // Method override:

    @Override
    public void push(double item) {
        if (tos== stck.length-1) { //use length number
            double temp[] = new double[stck.length * 2];
            for (int i=0; i<stck.length;i++){
                temp[i] = stck[i];
            }
            stck = temp;
            stck[++tos] = item;
        }
        else{
            stck[++tos] = item;
        }
    }

    @Override
    public double pop() {
        if (tos < 0){
            System.out.println("Stack underflow");
            return 0;
        }
        else{
            return stck[tos--];
        }
    }

    @Override
    public double sphereVol(double radius) {
        return (4/3 * 3.14 * Math.pow(radius, 3));
    }

    @Override
    public double cubeVol(double side) {
        return (Math.pow(side, 3));
    }

    @Override
    public double coneVol(double radius, double height) {
        return ((3.14 * height * Math.pow(radius, 2)/3));
    }

    @Override
    public double cylinderVol(double radius, double height) {
        return (3.14 * Math.pow(radius, 2) * height);
    }
}


class IFTest{
    public static void main(String args[]){
        VolumesCalc Sphere = new VolumesCalc(10);
        VolumesCalc Cube = new VolumesCalc(10);
        VolumesCalc Cone = new VolumesCalc(10);
        VolumesCalc Cylinder = new VolumesCalc(10);

        for (int i = 0; i<12; i++){
            double param = i;
            Sphere.push(Sphere.sphereVol(param));
        }
        for (int i = 0; i<12; i++){
            double param = i;
            Cube.push(Cube.cubeVol(param));
        }
        for (int i = 0; i<12; i++){
            double param = i;
            Cone.push(Cone.coneVol(param, param));
        }
        for (int i = 0; i<12; i++){
            double param = i;
            Cylinder.push(Cylinder.cylinderVol(param, param));
        }

        for (int i = 0; i<12; i++){
            System.out.println(Sphere.pop());
        }
        System.out.println();
        for (int i = 0; i<12; i++){
            System.out.println(Cube.pop());
        }
        System.out.println();
        for (int i = 0; i<12; i++){
            System.out.println(Cone.pop());
        }
        System.out.println();
        for (int i = 0; i<12; i++){
            System.out.println(Cylinder.pop());
        }
    }
}



