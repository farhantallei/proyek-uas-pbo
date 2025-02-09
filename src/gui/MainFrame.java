package gui;

import model.User;

import javax.swing.*;

/**
 * MainFrame adalah jendela utama untuk aplikasi.
 * Ini berisi komponen UI dan menginisialisasi pengaturan frame utama.
 */
public class MainFrame extends JFrame {
    private JButton daftarProdukButton;
    private JPanel panel1;
    private JButton stokProdukButton;
    private JButton keluarButton;
    private JLabel userFullName;

    /**
     * Membuat frame utama baru.
     */
    public MainFrame(User user) {
        // Inisialisasi frame
        setTitle("Aplikasi Sistem Manajemen Stok Toko HP");
        setContentPane(panel1);
        setSize(800, 600);
        setMinimumSize(getSize());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        if (user != null) {
            userFullName.setText("Hello, " + user.getFullName());
            userFullName.setSize(500, 500);
        }

        daftarProdukButton.addActionListener(e -> {
            ListProductsFrame listProductsFrame = new ListProductsFrame();
            listProductsFrame.setVisible(true);
            dispose();
        });

        stokProdukButton.addActionListener(e -> {
            ProductStockFrame productStockFrame = new ProductStockFrame();
            productStockFrame.setVisible(true);
            dispose();
        });

        keluarButton.addActionListener(e -> {
            System.exit(0);
        });

    }
}
