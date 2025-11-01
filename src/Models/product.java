package Models;
import java.time.LocalDate;
public abstract class product {
    protected String id;
    protected String name;
    protected double price;
    protected int quantity;
    protected boolean shippable;
    protected double weight;

    public product(String id , String name , double price , int quantity , boolean shippable , double weight) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.shippable = shippable;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isShippable() {
        return shippable;
    }

    public double getWeight() {
        return weight;
    }

    public void reduceStock(int amount) {
        if(amount <= 0) {
            System.out.println("Amount must be > 0");
            return;
        }
        if(amount > quantity) {
            System.out.println("Not enough stock to reduce");
            return;
        }
        quantity -= amount;
    }

    public void increaseStock(int amount) {
        if(amount <= 0) {
            System.out.println("Amount must be > 0");
            return;
        }
        this.quantity += amount;
    }

    public boolean isExpired(LocalDate Date) {
        return false;
    }

    @Override
    public String toString() {
        String s = getName();
        s += " (price = " + getPrice() + ", quantity = " + quantity + ").";
        return s;
    }
}
