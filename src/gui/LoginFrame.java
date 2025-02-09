package gui;

import model.User;
import repository.UserRepository;

import javax.swing.*;

/**
 * LoginFrame adalah jendela login untuk aplikasi.
 * Ini berisi komponen UI dan menginisialisasi pengaturan frame login.
 */
public class LoginFrame extends JFrame {

    // Komponen UI
    private JPanel panel1;
    private JTextField fullNameField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JButton loginButton;
    private JTextField usernameField;

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

        registerButton.addActionListener(e -> {
            String username = fullNameField.getText();
            String password = new String(passwordField
                    .getPassword());

            User user = UserRepository.getInstance().login(username, password);
            if (user != null) {
                MainFrame mainFrame = new MainFrame(user);
                mainFrame.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Username atau password salah");
            }
        });

        loginButton.addActionListener(e -> {
            RegisterFrame registerFrame = new RegisterFrame();
            registerFrame.setVisible(true);
            dispose();
        });
    }
}
