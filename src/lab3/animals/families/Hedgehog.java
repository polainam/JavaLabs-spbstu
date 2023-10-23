package lab3.animals.families;

import lab3.animals.squads.Insectivores;

public class Hedgehog extends Insectivores {

    public Hedgehog(double weight, double length) {
        super(weight, length);
    }

    public void familyInformation() {
        System.out.println("Семейство ежовые\n" +
                "Ключевая особенность: покрыты иголками");
    }
}
