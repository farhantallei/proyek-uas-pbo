package gui;

import javax.swing.*;

/**
 * LoginFrame adalah jendela login untuk aplikasi.
 * Ini berisi komponen UI dan menginisialisasi pengaturan frame login.
 */
public class LoginFrame extends JFrame {

    // Komponen UI
    private JPanel panel1;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    /**
     * Membuat frame login baru.
     */
    public LoginFrame() {
        // Inisialisasi frame
        setTitle("Login Aplikasi Sistem Manajemen Stok Toko HP");
        setContentPane(panel1);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField
                    .getPassword());
            if (username.equals("admin") && password.equals("admin")) {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Username atau password salah");
            }
        });
    }
}
