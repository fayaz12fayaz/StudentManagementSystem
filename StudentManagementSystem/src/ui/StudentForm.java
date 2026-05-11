package ui;

import dao.StudentDAO;
import model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class StudentForm extends JFrame {

    JTextField idField, nameField, deptField,
            emailField, phoneField;

    JButton addButton, updateButton,
            deleteButton, refreshButton;

    JTable table;

    DefaultTableModel model;

    StudentDAO dao = new StudentDAO();

    public StudentForm() {

        setTitle("Student Management");

        setSize(800,500);

        setLayout(null);

        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(20,20,100,30);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(120,20,150,30);
        add(idField);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(20,60,100,30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(120,60,150,30);
        add(nameField);

        JLabel deptLabel = new JLabel("Department");
        deptLabel.setBounds(20,100,100,30);
        add(deptLabel);

        deptField = new JTextField();
        deptField.setBounds(120,100,150,30);
        add(deptField);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(20,140,100,30);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(120,140,150,30);
        add(emailField);

        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(20,180,100,30);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(120,180,150,30);
        add(phoneField);

        addButton = new JButton("Add");
        addButton.setBounds(20,240,100,30);
        add(addButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(130,240,100,30);
        add(updateButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(240,240,100,30);
        add(deleteButton);

        refreshButton = new JButton("Refresh");
        refreshButton.setBounds(350,240,100,30);
        add(refreshButton);

        model = new DefaultTableModel();

        table = new JTable(model);

        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Department");
        model.addColumn("Email");
        model.addColumn("Phone");

        JScrollPane pane = new JScrollPane(table);

        pane.setBounds(300,20,450,200);

        add(pane);

        loadStudents();

        // ADD
        addButton.addActionListener(e -> {

            Student student = new Student(

                    nameField.getText(),
                    deptField.getText(),
                    emailField.getText(),
                    phoneField.getText()
            );

            dao.addStudent(student);

            JOptionPane.showMessageDialog(this,
                    "Student Added");

            loadStudents();
        });

        // UPDATE
        updateButton.addActionListener(e -> {

            Student student = new Student(

                    Integer.parseInt(idField.getText()),
                    nameField.getText(),
                    deptField.getText(),
                    emailField.getText(),
                    phoneField.getText()
            );

            dao.updateStudent(student);

            JOptionPane.showMessageDialog(this,
                    "Student Updated");

            loadStudents();
        });

        // DELETE
        deleteButton.addActionListener(e -> {

            dao.deleteStudent(
                    Integer.parseInt(idField.getText())
            );

            JOptionPane.showMessageDialog(this,
                    "Student Deleted");

            loadStudents();
        });

        // REFRESH
        refreshButton.addActionListener(e -> loadStudents());

        setLocationRelativeTo(null);

        setVisible(true);
    }

    void loadStudents() {

        model.setRowCount(0);

        ArrayList<Student> students = dao.getStudents();

        for(Student s : students) {

            model.addRow(new Object[]{

                    s.getId(),
                    s.getName(),
                    s.getDepartment(),
                    s.getEmail(),
                    s.getPhone()
            });
        }
    }
}