package lab1.strategies;

public class StayImpl implements MovementStrategy {
    @Override
    public void move() {
        System.out.println("Стою");
    }
}
