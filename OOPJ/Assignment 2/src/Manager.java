

public class Manager extends Employee {

    private String department;

    public Manager(int id, String name, double salary, String department) {
        super(id, name, salary);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String getEmployeeType() {
        return "Manager";
    }

    @Override
    public void display() {
        System.out.println(
                "Manager | ID: " + getId() +
                ", Name: " + getName() +
                ", Salary: " + getSalary() +
                ", Department: " + department
        );
    }
}