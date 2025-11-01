package Models;

public class cartItem  {
    private final product product;
    private final int quantity;

    public cartItem(product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double totalCost() {
        return quantity * product.getPrice();
    }
}
