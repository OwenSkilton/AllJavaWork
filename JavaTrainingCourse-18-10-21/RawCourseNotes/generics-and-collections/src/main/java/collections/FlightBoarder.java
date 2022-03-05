package collections;

import java.util.PriorityQueue;
import java.util.Queue;

public class FlightBoarder {

    private Queue<Passenger> passengers;

    private static int nextNumber = 1;

    public FlightBoarder() {
        passengers = new PriorityQueue<>();
    }

    public void addPassenger(Passenger passenger) {
        passenger.setNumber(nextNumber++);
        passengers.add(passenger);
    }

    public Passenger boardNextPassenger() {
        return passengers.remove();
    }
}
