package BasicOOP.Pojos;

public class Journey {
    private double distance;
    private double speed;

    public Journey(double distance, double speed){
        this.distance = distance;
        this.speed = speed;
    }

    public double getTime(){
        return this.getDistance() / this.getSpeed();
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
