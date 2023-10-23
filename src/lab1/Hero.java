package lab1;

import lab1.strategies.MovementStrategy;

public class Hero {

    private MovementStrategy movement;

    public void move() {
        movement.move();
    }

    public void setMovement(MovementStrategy movement) {
        this.movement = movement;
    }
}
