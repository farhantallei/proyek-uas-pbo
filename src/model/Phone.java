package model;

public class Phone extends Product {
    private String brand;

    public Phone(String name, double price, int stock, String brand) {
        super(name, price, stock);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}
