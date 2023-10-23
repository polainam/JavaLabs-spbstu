package lab3.animals.kinds;

import lab3.animals.families.Feline;

public class Lynx extends Feline {
    private static final String NAME = "Рысь";
    private static final String DISTRIBUTION_REGION = "Северная Америка, Евразия, Северная Африка";

    public Lynx(double weight, double length) {
        super(weight, length);
    }

    public void distributionInformation() {
        System.out.println("Регион распространения: " + DISTRIBUTION_REGION);
    }

    public String getName() {
        return NAME;
    }
}
