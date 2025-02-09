package gui;

import repository.UserRepository;

import javax.swing.*;

public class RegisterFrame extends JFrame {

    private JPanel panel1;
    private JTextField fullNameField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JButton loginButton;

    public RegisterFrame() {
        setTitle("Register Aplikasi Sistem Manajemen Stok Toko HP");
        setContentPane(panel1);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        registerButton.addActionListener(e -> {
            String fullName = fullNameField.getText();
            String username = usernameField.getText();
            String password = new String(passwordField
                    .getPassword());

            if (fullName.isEmpty() || username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
                return;
            }
            UserRepository.getInstance().register(fullName, username, password);
            JOptionPane.showMessageDialog(null, "Akun berhasil didaftarkan, silakan masuk!");
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
        });

        loginButton.addActionListener(e -> {
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
            dispose();
        });
    }
}
