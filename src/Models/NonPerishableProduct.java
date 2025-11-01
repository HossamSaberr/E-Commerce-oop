package Models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NonPerishableProduct extends product{

    public NonPerishableProduct(String id, String name, double price, int quantity, boolean shippable, double weight) {
        super(id, name, price, quantity, shippable, weight);
    }

    @Override
    public boolean isExpired(LocalDate Date) {
        return false;
    }

    @Override
    public String toString() {
        String s = getName();
        s += " (non-perishable, Price = ";
        s += getPrice();
        s += ", Quantity = ";
        s += getQuantity();
        s += ").";
        return s;
    }
}
