package lab3.animals.classes;

import lab3.animals.types.Chordate;

public class Mammals extends Chordate {
    public Mammals(double weight, double length) {
        super(weight, length);
    }

    public void classInformation() {
        System.out.println("Класс млекопитающие\n" +
                "Ключевая особенность: покрыты шерстью");
    }
}
