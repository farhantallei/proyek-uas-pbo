package model;

// ✅ Implementasi Abstract Class
public abstract class Product {
    protected String name;
    protected double price;
    protected int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void updateStock(int amount) {
        this.stock = amount;
    }

    // ✅ Implementasi Overloading
    public void updateStock(int amount, boolean isIncrease) {
        if (isIncrease) {
            this.stock += amount;
        } else {
            this.stock -= amount;
        }
    }

    // ✅ Implementasi Wrapper Class
    public Integer getStock() {
        return Integer.valueOf(stock);
    }

    // ✅ Implementasi Abstract Method
    public abstract String getBrand();
}
