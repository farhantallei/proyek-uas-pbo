package gui;

import model.Phone;
import model.Product;
import repository.ProductRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.NumberFormat;

/**
 * ListProductsFrame adalah jendela untuk menampilkan daftar produk.
 * Ini berisi komponen UI dan menginisialisasi pengaturan frame.
 */
public class ListProductsFrame extends JFrame {

    // Komponen UI
    private JPanel panel1;
    private JTable table1;
    private JButton tambahButton;
    private JButton editButton;
    private JButton hapusButton;
    private JButton blurButton;
    private JTextField nameField;
    private JTextField priceField;
    private JButton kembaliButton;
    private JTextField brandField;

    // Daftar variabel
    private DefaultTableModel tableModel;
    private ProductRepository productRepository;

    // Number formatter
    NumberFormat numberFormat = NumberFormat.getInstance();

    /**
     * Membuat frame baru untuk menampilkan daftar produk.
     */
    public ListProductsFrame() {
        // Inisialisasi frame
        setTitle("Aplikasi Sistem Manajemen Stok Toko HP");
        setContentPane(panel1);
        setSize(800, 600);
        setMinimumSize(getSize());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inisialisasi model tabel
        String[] columnNames = {"Nama", "Merek", "Harga"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table1.setModel(tableModel);

        // Mendapatkan instance dari ProductRepository
        this.productRepository = ProductRepository.getInstance();

        updateTable();

        tambahButton.addActionListener(e -> {
            try {
                String brand = brandField.getText();
                String name = nameField.getText();
                double price = Double.parseDouble(priceField.getText());

                // ✅ Implementasi Polymorphism
                Product phone = new Phone(name, price, 0, brand);

                productRepository.addProduct(phone);
                updateTable();
                clearFields();
            } catch (Exception ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(this, "Input tidak valid.");
            }
        });

        table1.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = table1.getSelectedRow();
            if (selectedRow != -1) {
                tambahButton.setEnabled(false);
                Product product = productRepository.getProductByIndex(selectedRow);
                brandField.setText(product.getBrand());
                nameField.setText(product.getName());
                priceField.setText(String.format("%.0f", product.getPrice()));
            }
        });

        editButton.addActionListener(e -> {
            int selectedRow = table1.getSelectedRow();
            if (selectedRow != -1) {
                try {
                    String name = nameField.getText();
                    double price = Double.parseDouble(priceField.getText());
                    Product product = productRepository.getProductByIndex(selectedRow);
                    product.setName(name);
                    product.setPrice(price);
                    updateTable();
                    clearFields();
                } catch (Exception ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(this, "Input tidak valid.");
                }
            }
        });

        hapusButton.addActionListener(e -> {
            int[] selectedRow = table1.getSelectedRows();

            for (int i = selectedRow.length - 1; i >= 0; i--) {
                if (selectedRow[i] != -1) {
                    productRepository.removeProductByIndex(selectedRow[i]);
                    updateTable();
                    clearFields();
                }
            }
        });

        blurButton.addActionListener(e -> {
            table1.clearSelection();
            clearFields();
        });

        kembaliButton.addActionListener(e -> {
            new MainFrame(null).setVisible(true);
            dispose();
        });
    }

    private void updateTable() {
        tableModel.setRowCount(0);

        for (Product product : productRepository.getProductList()) {
            if (product instanceof Phone phone) {
                tableModel.addRow(new Object[]{
                        phone.getName(),
                        phone.getBrand(),
                        numberFormat.format(phone.getPrice()),
                });
            }
        }
    }

    private void clearFields() {
        tambahButton.setEnabled(true);
        brandField.setText("");
        nameField.setText("");
        priceField.setText("");
    }
}
