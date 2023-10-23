package lab3.animals.families;

import lab3.animals.squads.Predatory;

public class Feline extends Predatory {
    public Feline(double weight, double length) {
        super(weight, length);
    }

    public void familyInformation() {
        System.out.println("Семейство кошачьи\n" +
                "Ключевая особенность: конические клыки");
    }
}
