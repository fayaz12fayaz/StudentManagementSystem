import dao.StudentDAO;
import model.Student;
import ui.LoginForm;

public class Main {

    public static void main(String[] args) {

        Student student = new Student(
                "Rahul",
                "Computer Science",
                "rahul@gmail.com",
                "9876543210"
        );

        StudentDAO dao = new StudentDAO();

        dao.addStudent(student);
        new LoginForm();

    }
}