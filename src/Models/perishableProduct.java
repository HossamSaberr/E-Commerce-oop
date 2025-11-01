package Models;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class perishableProduct extends product {
    private final LocalDate expiryDate;

    public perishableProduct(String id , String name , double price , int quantity , boolean shippable , double weight ,LocalDate expiryDate) {
        super(id , name , price , quantity , shippable , weight);
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public boolean isExpired(LocalDate Date) {
        return expiryDate.isBefore(Date);
    }

    @Override
    public String toString() {
        String s = getName();
        s += " (perishable, Expires = ";
        s += expiryDate.format(DateTimeFormatter.ISO_DATE);
        s += ", Price = ";
        s += getPrice();
        s += ", Quantity = ";
        s += getQuantity();
        s += ").";
        return s;
    }
}
