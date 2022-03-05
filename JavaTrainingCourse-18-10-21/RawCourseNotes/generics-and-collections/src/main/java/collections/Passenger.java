package collections;

public class Passenger implements Comparable<Passenger> {

    private String name;
    private int number;
    private boolean frequentFlyer;

    public Passenger(String name, boolean frequentFlyer) {
        this.name = name;
        this.frequentFlyer = frequentFlyer;
    }

    @Override
    public int compareTo(Passenger other) {
        if (this.frequentFlyer && !other.frequentFlyer) {
            return -1;
        } else if (other.frequentFlyer && !this.frequentFlyer) {
            return 1;
        } else {
            return this.number - other.number;
        }
    }

    public String getName() {
        return name;
    }

    public Passenger setName(String name) {
        this.name = name;
        return this;
    }

    public int getNumber() {
        return number;
    }

    public Passenger setNumber(int number) {
        this.number = number;
        return this;
    }

    public boolean isFrequentFlyer() {
        return frequentFlyer;
    }

    public Passenger setFrequentFlyer(boolean frequentFlyer) {
        this.frequentFlyer = frequentFlyer;
        return this;
    }
}
