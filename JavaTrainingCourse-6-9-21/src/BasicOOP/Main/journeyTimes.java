package BasicOOP.Main;

import java.util.Scanner;
import BasicOOP.Pojos.Journey;
public class journeyTimes {
    static Scanner stdin = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("What speed were you travelling (MPH)?: ");
        double userSpeed = Double.parseDouble(stdin.nextLine());
        System.out.println("How far did you travel (Miles)?: ");
        double userDistance = Double.parseDouble(stdin.nextLine());
        Journey journey1 = new Journey(userDistance, userSpeed );
        System.out.printf("It took you %fhrs, to travel %f miles, at %f MPH", journey1.getTime(), journey1.getDistance(), journey1.getSpeed());
    }
}
