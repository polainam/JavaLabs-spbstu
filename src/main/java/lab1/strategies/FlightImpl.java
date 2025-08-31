package lab1.strategies;

public class FlightImpl implements MovementStrategy {
    @Override
    public void move() {
        System.out.println("Лечу");
    }
}
