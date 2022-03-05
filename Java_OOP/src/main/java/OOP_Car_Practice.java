import java.rmi.registry.Registry;
import java.util.*;

public class OOP_Car_Practice {
    static Scanner stdin = new Scanner(System.in);

    public static void main(String[] args) {

        Car BMW = new Car("BMW", "3 Series", "GP57 PNX", 2007);
        Car Merc = new Car("Merc", "SLS", "FG67 TYP", 2017);
        Car Skoda = new Car("Skoda", "Fabia", "CP17 OOP", 2016);

        printMake(BMW);
        printMake(Merc);
        printMake(Skoda);
        printModel(BMW);
        printModel(Merc);
        printModel(Skoda);
        printRegPlate(BMW);
        printRegPlate(Merc);
        printRegPlate(Skoda);
        printYearRegistered(BMW);
        printYearRegistered(Merc);
        printYearRegistered(Skoda);
    }

    public static void printMake(Car car) {
        System.out.println(car.Make);
    }

    public static void printModel(Car car) {
        System.out.println(car.Model);
    }

    public static void printRegPlate(Car car) {
        System.out.println(car.RegNum);
    }

    public static void printYearRegistered(Car car) {
        System.out.println(car.YearRegistered);
    }

    public static class Car {
        String Make;
        String Model;
        String RegNum;
        int YearRegistered;

        public Car(String Make, String Model, String RegNum, int YearRegistered) {
            this.Make = Make;
            this.Model = Model;
            this.RegNum = RegNum;
            this.YearRegistered = YearRegistered;
        }
    }
}





