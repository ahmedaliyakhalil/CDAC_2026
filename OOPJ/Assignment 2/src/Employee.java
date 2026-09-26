

import java.io.Serializable;

public abstract class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // Abstract method
    public abstract String getEmployeeType();

    // Concrete method
    public void display() {
        System.out.println(
                "ID: " + id +
                ", Name: " + name +
                ", Salary: " + salary +
                ", Type: " + getEmployeeType()
        );
    }
}