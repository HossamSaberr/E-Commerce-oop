package Models;

import java.time.format.DateTimeFormatter;

public class customer {
    protected String id;
    protected String name;
    protected double balance;

    public customer(String id , String name , double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public void debit(double amount) {
        if(amount <= 0) {
            System.out.println("Amount must be > 0");
            return;
        }
        if(amount > balance) {
            System.out.println("Insufficient balance");
            return;
        }
        balance -= amount;
    }

    public void credit(double amount) {
        if(amount <= 0) {
            System.out.println("Amount must be > 0");
            return;
        }
        balance += amount;
    }

    @Override
    public String toString() {
        String s = getName();
        s += " (Balance = ";
        s += getBalance();
        s += ").";
        return s;
    }
}
