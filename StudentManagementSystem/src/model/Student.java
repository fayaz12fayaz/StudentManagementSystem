package model;

public class Student {

    private int id;
    private String name;
    private String department;
    private String email;
    private String phone;

    // EMPTY CONSTRUCTOR
    public Student() {}

    // CONSTRUCTOR WITHOUT ID
    public Student(String name, String department,
                   String email, String phone) {

        this.name = name;
        this.department = department;
        this.email = email;
        this.phone = phone;
    }

    // CONSTRUCTOR WITH ID
    public Student(int id, String name, String department,
                   String email, String phone) {

        this.id = id;
        this.name = name;
        this.department = department;
        this.email = email;
        this.phone = phone;
    }

    // GETTERS

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}