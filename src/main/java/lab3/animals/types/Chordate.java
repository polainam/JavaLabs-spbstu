package lab3.animals.types;

import lab3.animals.Animals;

public class Chordate extends Animals {
    public Chordate(double weight, double length) {
        super(weight, length);
    }

    public void typeInformation() {
        System.out.println("Тип хордовые\n" +
                "Ключевая особенность: внутренний скелет - хорда");
    }
}
