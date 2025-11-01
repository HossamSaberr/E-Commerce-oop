package Services;

import java.util.List;

public class ShippingService {
    private final double costPerKg;
    private final double minFee;

    public ShippingService(double costPerKg, double minFee) {
        this.costPerKg = costPerKg;
        this.minFee = minFee;
    }

    public double shipAndGetFee(List<Shippable> array) {
        if (array == null || array.isEmpty()) {
            return 0.0;
        }
        System.out.println("** Cart Details **");
        double total = 0.0;
        for (Shippable s : array) {
            double gram = s.getWeight() * 1000;
            String ss = (gram >= 1000) ? String.valueOf(gram / 1000.0) + "KG" : String.valueOf(gram) + "Grams";
            System.out.println(s.getName() + " " + ss);
            total += s.getWeight();
        }
        System.out.println("Total package weight " + total + "KG\n");
        double gain = total * costPerKg;
        double fee = Math.max(minFee, gain);
        return fee;
    }
}
