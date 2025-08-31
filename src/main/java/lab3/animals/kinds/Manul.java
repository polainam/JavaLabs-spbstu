package lab3.animals.kinds;

import lab3.animals.families.Feline;

public class Manul extends Feline {
    private static final String NAME = "Манул";
    private static final String DISTRIBUTION_REGION = "Центральная Азия";

    public Manul(double weight, double length) {
        super(weight, length);
    }

    public void distributionInformation() {
        System.out.println("Регион распространения: " + DISTRIBUTION_REGION);
    }

    public String getName() {
        return NAME;
    }
}
