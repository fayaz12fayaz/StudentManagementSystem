package dao;

import database.DBConnection;
import model.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {

    Connection con = DBConnection.getConnection();

    // ADD STUDENT
    public void addStudent(Student student) {

        String query =
                "INSERT INTO students(name, department, email, phone) VALUES(?,?,?,?)";

        try {

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, student.getName());
            pst.setString(2, student.getDepartment());
            pst.setString(3, student.getEmail());
            pst.setString(4, student.getPhone());

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // GET ALL STUDENTS
    public ArrayList<Student> getStudents() {

        ArrayList<Student> list = new ArrayList<>();

        try {

            String query = "SELECT * FROM students";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                Student s = new Student(

                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getString("email"),
                        rs.getString("phone")
                );

                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // UPDATE STUDENT
    public void updateStudent(Student student) {

        String query =
                "UPDATE students SET name=?, department=?, email=?, phone=? WHERE id=?";

        try {

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, student.getName());
            pst.setString(2, student.getDepartment());
            pst.setString(3, student.getEmail());
            pst.setString(4, student.getPhone());
            pst.setInt(5, student.getId());

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE STUDENT
    public void deleteStudent(int id) {

        String query =
                "DELETE FROM students WHERE id=?";

        try {

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, id);

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}