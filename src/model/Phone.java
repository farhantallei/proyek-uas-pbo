package model;

public class Phone extends Product {
    private String brand;

    public Phone(String name, double price, int stock, String brand) {
        super(name, price, stock);
        this.brand = brand;
    }

    // ✅ Implementasi Overriding
    @Override
    public Integer getStock() {
        System.out.println("Mengambil stok untuk produk: " + this.name);
        return super.getStock();
    }

    @Override
    public String getBrand() {
        return brand;
    }
}
