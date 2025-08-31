package lab3.animals.squads;

import lab3.animals.classes.Mammals;

public class Predatory extends Mammals {

    public Predatory(double weight, double length) {
        super(weight, length);
    }

    public void squadInformation() {
        System.out.println("Отряд хищные\n" +
                "Ключевая особенность: питаются другими животными");
    }
}
