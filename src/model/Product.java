package model;

public class Product extends BaseModel {
    private int stock;

    public Product(String name, double price, int stock) {
        super(name, price);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
