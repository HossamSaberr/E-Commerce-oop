package Services;

public class ShipmentItem implements Shippable {
    private final String name;
    private final double weight;

    public ShipmentItem(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
