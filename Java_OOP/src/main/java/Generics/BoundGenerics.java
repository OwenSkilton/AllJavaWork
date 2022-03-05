package Generics;

public class BoundGenerics {

    // T must either be number or a class derived from it. E.g. Integer, Double etc
    // Cant be a String for example as its bound by Number

    public static class Stats2 <T extends Number>{
        T[] Nums; // Array of Number or subclass

        // Pass the constructor a reference to an object of type T
        Stats2(T[] o1){
            Nums = o1;
        }

        double average(){
            double sum = 0.0;
            for (int i = 0; i <Nums.length; i++) {
                sum += Nums[i].doubleValue();
            }
            return sum / Nums.length;
        }

        // Are two averages the same?:
        // The ? acts as a wild called is any data type that enters
        boolean sameAvg(Stats2<?> ob){
            if (average() == ob.average()){
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args){

        Integer inums[] = {1,2,3,4,5,6};
        Stats2<Integer> intOb = new Stats2<Integer>(inums);
        double v = intOb.average();
        System.out.println("intOb average is: " + v);

        Double dnums[] = {1.1, 2.2, 3.3, 4.4, 5.5, 4.5};
        Stats2<Double> douOb = new Stats2<Double>(dnums);
        double w = douOb.average();
        System.out.println("douOb average is: " + w);

        if (intOb.sameAvg(douOb)){
            System.out.println("Are the same");
        } else {
            System.out.println("They are not the same");
        }
    }

    // SLIDE 37 FOR AN EXTRA EXAMPLE
}
