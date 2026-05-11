package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener {

    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;

    public LoginForm() {

        setTitle("Login");

        setSize(350, 250);

        setLayout(null);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(50, 50, 100, 30);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 50, 120, 30);
        add(usernameField);

        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(50, 100, 100, 30);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 120, 30);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(120, 150, 100, 30);
        loginButton.addActionListener(this);
        add(loginButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String username = usernameField.getText();
        String password = passwordField.getText();

        if(username.equals("admin") && password.equals("1234")) {

            JOptionPane.showMessageDialog(this,
                    "Login Successful");

            new Dashboard();

            dispose();

        } else {

            JOptionPane.showMessageDialog(this,
                    "Invalid Username or Password");
        }
    }
}