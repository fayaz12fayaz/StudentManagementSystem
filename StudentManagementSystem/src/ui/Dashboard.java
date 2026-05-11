package ui;

import javax.swing.*;

public class Dashboard extends JFrame {

    JButton studentButton;

    public Dashboard() {

        setTitle("Dashboard");

        setSize(400,300);

        setLayout(null);

        studentButton = new JButton("Student Management");

        studentButton.setBounds(90,100,200,40);

        add(studentButton);

        studentButton.addActionListener(e -> new StudentForm());

        setLocationRelativeTo(null);

        setVisible(true);
    }
}