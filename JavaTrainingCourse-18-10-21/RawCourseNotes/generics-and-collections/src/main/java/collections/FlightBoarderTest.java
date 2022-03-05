package collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightBoarderTest {

    @Test
    public void testFlightBoarder() {
        var boarder = new FlightBoarder();
        boarder.addPassenger(new Passenger("Smith", false));
        boarder.addPassenger(new Passenger("Jones", true));
        boarder.addPassenger(new Passenger("Wilson", false));
        assertEquals("Jones", boarder.boardNextPassenger().getName());
        // When a tie occurs in relation to compareTo such ties are broken arbitrarily (PriorityQueue default behaviour)
        // So we included Passenger number in the compareTo method to break such ties
        assertEquals("Smith", boarder.boardNextPassenger().getName());
        assertEquals("Wilson", boarder.boardNextPassenger().getName());
    }
}
