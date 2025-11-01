package Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class cart {
    private final List<cartItem> items = new ArrayList<>();

    public void add(product product, int quantity) {
        if (quantity <= 0) {
            System.out.println("Quantity must be > 0");
            return;
        }
        if (quantity > product.getQuantity()) {
            System.out.println("Requested quantity exceeds available stock for: " + product.getName());
            return;
        }
        items.add(new cartItem(product, quantity));
    }

    public List<cartItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }

}
