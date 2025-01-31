package repository;

import model.Phone;
import model.Product;

import java.util.ArrayList;

public class ProductRepository {
    private ArrayList<Product> productList;
    private static ProductRepository instance;

    private ProductRepository() {
        productList = new ArrayList<>();

        productList.add(new Phone("Samsung Galaxy S24 Ultra", 19_999_000, 10, "Samsung"));
        productList.add(new Phone("Xiaomi 13 Pro", 14_999_000, 5, "Xiaomi"));
        productList.add(new Phone("Google Pixel 8 Pro", 14_999_000, 7, "Google"));
        productList.add(new Phone("OnePlus 11 5G", 10_999_000, 3, "OnePlus"));
    }

    public static ProductRepository getInstance() {
        if (instance == null) {
            instance = new ProductRepository();
        }
        return instance;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void removeProductByIndex(int index) {
        productList.remove(index);
    }

    public Product getProductByIndex(int index) {
        return productList.get(index);
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
}
