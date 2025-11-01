import Models.NonPerishableProduct;
import Models.cart;
import Models.customer;
import Models.perishableProduct;
import Services.CheckoutService;
import Services.ShippingService;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        perishableProduct cheese = new perishableProduct("p1", "Cheese", 100.0, 10, true, 0.2, LocalDate.now().plusDays(10));
        perishableProduct biscuits = new perishableProduct("p2", "Biscuits", 150.0, 5, true, 0.7, LocalDate.now().plusDays(30));
        NonPerishableProduct tv = new NonPerishableProduct("p3", "TV", 5000.0, 2, true, 8.0);
        customer customer = new customer("c1", "Alice", 10000.0);
        cart cart = new cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(tv, 1);
        ShippingService shippingService = new ShippingService(20.0, 30.0);
        CheckoutService checkoutService = new CheckoutService(shippingService);
        if(checkoutService.checkout(customer, cart)) {
        }
        else {
            System.err.println("Checkout failed.");
        }
        System.out.println();
        System.out.println("Remaining stocks:");
        System.out.println(cheese.toString());
        System.out.println(biscuits.toString());
        System.out.println(tv.toString());
    }
}
