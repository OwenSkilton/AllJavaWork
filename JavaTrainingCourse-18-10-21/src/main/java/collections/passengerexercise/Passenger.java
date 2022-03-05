package collections.passengerexercise;

import java.util.Comparator;

public class Passenger{

    private String name;
    private int number;
    private boolean freqFlyer;

    public Passenger(String name, int number, boolean freqFlyer) {
        this.name = name;
        this.number = number;
        this.freqFlyer = freqFlyer;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public boolean isFreqFlyer() {
        return freqFlyer;
    }
}
