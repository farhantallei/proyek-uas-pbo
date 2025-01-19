package model;

/**
 * BaseModel adalah kelas yang merepresentasikan model dasar.
 * Kelas ini memiliki atribut nama.
 */
public class BaseModel {
    // Atribut yang dimiliki oleh kelas Base.
    private String name;
    private double price;

    /**
     * Konstruktor dari kelas Base.
     * @param name nama dari Base.
     * @param price harga dari Base.
     */
    public BaseModel(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
