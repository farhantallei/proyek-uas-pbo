package repository;

import model.Product;

import java.util.ArrayList;

/**
 * ProductRepository adalah kelas yang menyimpan daftar produk.
 * Kelas ini digunakan untuk menyimpan produk-produk yang telah ditambahkan.
 */
public class ProductRepository {
    private final ArrayList<Product> productList;

    // Membuat instance statis dari ProductRepository
    private static ProductRepository instance;

    /**
     * Konstruktor private untuk mencegah pembuatan instance baru dari luar kelas.
     */
    private ProductRepository() {
        productList = new ArrayList<>();
    }

    /**
     * Method untuk mendapatkan instance dari ProductRepository.
     * Jika instance belum ada, maka instance baru akan dibuat.
     * @return instance dari ProductRepository
     */
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
