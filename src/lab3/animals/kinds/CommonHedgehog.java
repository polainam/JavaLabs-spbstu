package lab3.animals.kinds;

import lab3.animals.families.Hedgehog;

public class CommonHedgehog extends Hedgehog {
    private static final String NAME = "Еж обыкновенный";
    private static final String DISTRIBUTION_REGION = "Европа, Скандинавия";

    public CommonHedgehog(double weight, double length) {
        super(weight, length);
    }

    public void distributionInformation() {
        System.out.println("Регион распространения: " + DISTRIBUTION_REGION);
    }

    public String getName() {
        return NAME;
    }
}
