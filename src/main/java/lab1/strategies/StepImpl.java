package lab1.strategies;

public class StepImpl implements MovementStrategy {
    @Override
    public void move() {
        System.out.println("Иду пешком");
    }
}
