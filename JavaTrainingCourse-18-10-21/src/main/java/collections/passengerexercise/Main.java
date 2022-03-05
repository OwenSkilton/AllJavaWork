package collections.passengerexercise;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Comparator<Passenger> comparator = new PassengerComparator();
        PriorityQueue<Passenger> passengers = new PriorityQueue<Passenger>(10, comparator);

        passengers.add(new Passenger("1", 1, true));
        passengers.add(new Passenger("5", 2, false));
        passengers.add(new Passenger("6", 3, false));
        passengers.add(new Passenger("2", 4, true));
        passengers.add(new Passenger("7", 5, false));
        passengers.add(new Passenger("8", 6, false));
        passengers.add(new Passenger("3", 7, true));
        passengers.add(new Passenger("9", 8, false));
        passengers.add(new Passenger("10", 9, false));
        passengers.add(new Passenger("4", 10, true));

        while (passengers.size() != 0){
            System.out.println(passengers.remove().getName());
        }
    }
}
