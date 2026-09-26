

public class Engineer extends Employee {

    private String technology;

    public Engineer(int id, String name, double salary, String technology) {
        super(id, name, salary);
        this.technology = technology;
    }

    public String getTechnology() {
        return technology;
    }

    @Override
    public String getEmployeeType() {
        return "Engineer";
    }

    @Override
    public void display() {
        System.out.println(
                "Engineer | ID: " + getId() +
                ", Name: " + getName() +
                ", Salary: " + getSalary() +
                ", Technology: " + technology
        );
    }
}