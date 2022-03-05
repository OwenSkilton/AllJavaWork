package collections.passengerexercise;

import java.util.Comparator;

public class PassengerComparator implements Comparator<Passenger> {

    @Override
    public int compare(Passenger o1, Passenger o2) {
        if (o1.isFreqFlyer() && !o2.isFreqFlyer()) {
            return -1;
        } if (!o1.isFreqFlyer() && o2.isFreqFlyer()) {
            return 1;
        }
        return Integer.compare(o1.getNumber(), o2.getNumber());
    }
}