package Services;

import Models.cart;
import Models.cartItem;
import Models.customer;
import Models.product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutService {
    private final ShippingService shippingService;

    public CheckoutService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public boolean checkout(customer customer, cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty");
            return false;
        }
        LocalDate today = LocalDate.now();
        for (cartItem it : cart.getItems()) {
            product p = it.getProduct();
            int need = it.getQuantity();
            if (need > p.getQuantity()) {
                System.out.println("Product out of stock or insufficient stock: " + p.getName());
                return false;
            }
            if (p.isExpired(today)) {
                System.out.println("Product expired: " + p.getName());
                return false;
            }
        }
        double total = 0.0;
        for (cartItem it : cart.getItems()) {
            total += it.totalCost();
        }
        Map<String, Double> arrayWeight = new HashMap<>();
        Map<String, Integer> arrayQantity = new HashMap<>();
        List<Shippable> List = new ArrayList<>();
        for (cartItem it : cart.getItems()) {
            product p = it.getProduct();
            int qty = it.getQuantity();
            if (p.isShippable()) {
                double totalWeight = p.getWeight() * qty;
                arrayWeight.merge(p.getName(), totalWeight, Double::sum);
                arrayQantity.merge(p.getName(), qty, Integer::sum);
            }
        }
        for (Map.Entry<String, Double> e : arrayWeight.entrySet()) {
            String s = String.valueOf(arrayQantity.getOrDefault(e.getKey(), 1));
            s += "x ";
            s += e.getKey();
            List.add(new ShipmentItem(s, e.getValue()));
        }
        double fee = shippingService.shipAndGetFee(List);
        double overAllCost = total + fee;
        if (overAllCost > customer.getBalance()) {
            System.out.println("Insufficient balance for customer " + customer.getName());
            return false;
        }
        customer.debit(overAllCost);
        for (cartItem it : cart.getItems()) {
            product p = it.getProduct();
            p.reduceStock(it.getQuantity());
        }
        System.out.println("** Checkout receipt **");
        for (cartItem it : cart.getItems()) {
            System.out.println(it.getQuantity() + "x " + it.getProduct().getName() + "\t\t\t" + it.totalCost());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal\t\t\t" + total);
        System.out.println("Shipping\t\t\t" + fee);
        System.out.println("Amount\t\t\t" + overAllCost);
        System.out.println("Customer balance after payment: " + customer.getBalance());
        cart.clear();
        return true;
    }
}
