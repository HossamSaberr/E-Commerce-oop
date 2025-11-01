# 🛒 E-Commerce OOP Project

A Java Object-Oriented Programming (OOP) implementation of an e-commerce system with products, cart, checkout, and shipping.

---
## 🚀 Features

### 🧩 Product Management
- Define products with **name**, **price**, **quantity**, and **shipping weight**.
- Supports two types of products:
  - 🧀 **Perishable** (expire after a date) — e.g., Cheese, Biscuits.
  - 📺 **Non-perishable** (no expiry) — e.g., TV, Scratch Cards.
- Supports products that require **shipping** and others that don’t.

---

### 🛒 Cart System
- Add products to a cart with specific quantities.
- Prevent adding more items than available in stock.
- Display clear error messages for invalid actions.

---

### 💳 Checkout Process
- Calculates:
  - Subtotal (sum of product prices)
  - Shipping fees
  - Total amount to pay
  - Customer balance after payment
- Validates:
  - Empty cart
  - Insufficient balance
  - Expired products
  - Out-of-stock products
- Generates detailed **checkout receipt**.

---

### 🚚 Shipping Service
- Collects all **shippable items** into a shipment list.
- Prints a **shipment notice** with each item’s name, quantity, and total weight.
- Calculates shipping fee based on:
  - Weight (`ratePerKg`)
  - Minimum shipping fee

---

## 🧠 Object-Oriented Design

| Class | Responsibility |
|-------|-----------------|
| **Product** | Base class for all products (common attributes & methods). |
| **PerishableProduct** | Product that has an expiry date. |
| **NonPerishableProduct** | Product that never expires. |
| **Customer** | Represents a buyer with a balance. |
| **Cart** | Holds items added by the customer. |
| **CartItem** | Represents a product and its quantity inside the cart. |
| **ShippingService** | Handles shippable products and calculates shipping fees. |
| **CheckoutService** | Validates cart, processes payments, and prints receipts. |
| **ShipmentItem** | Adapter implementing `Shippable` for the shipping system. |

---

## 📂 Project Structure

```
E-Commerce/
├── src/
│ ├── Main.java
│ ├── models/
│ │ ├── Product.java
│ │ ├── PerishableProduct.java
│ │ ├── NonPerishableProduct.java
│ │ ├── Cart.java
│ │ ├── CartItem.java
│ │ └── Customer.java
│ └── services/
│ ├── Shippable.java
│ ├── ShipmentItem.java
│ ├── ShippingService.java
│ └── CheckoutService.java
└── README.md
```

