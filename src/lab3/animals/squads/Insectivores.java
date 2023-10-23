package lab3.animals.squads;

import lab3.animals.classes.Mammals;

public class Insectivores extends Mammals {

    public Insectivores(double weight, double length) {
        super(weight, length);
    }

    public void squadInformation() {
        System.out.println("Отряд насекомоядные\n" +
                "Ключевая особенность: питаются насекомыми");
    }
}
