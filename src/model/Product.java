package model;

abstract class Product {
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

    public void updateStock(int amount, boolean isIncrease) {
        if (isIncrease) {
            this.stock += amount;
        } else {
            this.stock -= amount;
        }
    }

    public Integer getStock() {
        return Integer.valueOf(stock);
    }
}
