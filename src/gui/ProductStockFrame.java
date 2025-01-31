package gui;

import model.Product;
import repository.ProductRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.NumberFormat;

public class ProductStockFrame extends JFrame {

    // Komponen UI
    private JPanel panel1;
    private JTable table1;
    private JButton replaceButton;
    private JButton blurButton;
    private JTextField stockField;
    private JButton kembaliButton;
    private JButton tambahButton;
    private JButton kurangButton;
    private JButton emptyButton;

    // Daftar variabel
    private DefaultTableModel tableModel;
    private ProductRepository phoneRepository;

    // Number formatter
    NumberFormat numberFormat = NumberFormat.getInstance();

    public ProductStockFrame() {
        // Inisialisasi frame
        setTitle("Aplikasi Sistem Manajemen Stok Toko HP");
        setContentPane(panel1);
        setSize(800, 600);
        setMinimumSize(getSize());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inisialisasi model tabel
        String[] columnNames = {"Nama", "Harga", "Stok"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table1.setModel(tableModel);

        // Mendapatkan instance dari ProductRepository
        this.phoneRepository = ProductRepository.getInstance();

        updateTable();
        clearFields();

        kurangButton.addActionListener(e -> {
            int selectedRow = table1.getSelectedRow();
            if (selectedRow != -1) {
                try {
                    Product phone = phoneRepository.getProductByIndex(selectedRow);
                    int stock = phone.getStock();
                    int stockToSubtract = Integer.parseInt(stockField.getText());

                    if (stockToSubtract > stock) {
                        JOptionPane.showMessageDialog(this, "Stok tidak cukup!");
                        return;
                    }

                    phone.updateStock(stockToSubtract, false);
                    updateTable();
                    table1.setRowSelectionInterval(selectedRow, selectedRow);
                } catch (Exception ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(this, "Input tidak valid.");
                }
            }
        });

        tambahButton.addActionListener(e -> {
            int selectedRow = table1.getSelectedRow();
            if (selectedRow != -1) {
                try {
                    Product phone = phoneRepository.getProductByIndex(selectedRow);
                    int stockToAdd = Integer.parseInt(stockField.getText());

                    phone.updateStock(stockToAdd, true);
                    updateTable();
                    table1.setRowSelectionInterval(selectedRow, selectedRow);
                } catch (Exception ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(this, "Input tidak valid.");
                }
            }
        });

        replaceButton.addActionListener(e -> {
            int selectedRow = table1.getSelectedRow();
            if (selectedRow != -1) {
                try {
                    Product phone = phoneRepository.getProductByIndex(selectedRow);
                    int stock = Integer.parseInt(stockField.getText());

                    phone.updateStock(stock);
                    updateTable();
                    table1.setRowSelectionInterval(selectedRow, selectedRow);
                } catch (Exception ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(this, "Input tidak valid.");
                }
            }
        });

        emptyButton.addActionListener(e -> {
            int selectedRow = table1.getSelectedRow();
            if (selectedRow != -1) {
                try {
                    Product phone = phoneRepository.getProductByIndex(selectedRow);
                    phone.updateStock(0);
                    updateTable();
                    table1.setRowSelectionInterval(selectedRow, selectedRow);
                } catch (Exception ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(this, "Input tidak valid.");
                }
            }
        });

        blurButton.addActionListener(e -> {
            table1.clearSelection();
            clearFields();
        });

        kembaliButton.addActionListener(e -> {
            new MainFrame().setVisible(true);
            dispose();
        });
    }

    private void updateTable() {
        tableModel.setRowCount(0);

        for (Product phone : phoneRepository.getProductList()) {
            tableModel.addRow(new Object[]{
                    phone.getName(),
                    numberFormat.format(phone.getPrice()),
                    numberFormat.format(phone.getStock()),
            });
        }
    }

    private void clearFields() {
        stockField.setText("1");
    }
}
