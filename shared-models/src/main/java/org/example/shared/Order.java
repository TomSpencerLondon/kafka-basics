package org.example.shared;

public class Order {
    private String id;
    private String product;
    private int quantity;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

