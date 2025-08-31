package lab3.animals;

public class Animals {
    private double weight;
    private double length;

    public Animals(double weight, double length) {
        this.weight = weight;
        this.length = length;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
