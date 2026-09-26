

public class SalesPerson extends Employee {

    private double salesTarget;

    public SalesPerson(int id, String name, double salary, double salesTarget) {
        super(id, name, salary);
        this.salesTarget = salesTarget;
    }

    public double getSalesTarget() {
        return salesTarget;
    }

    @Override
    public String getEmployeeType() {
        return "Sales Person";
    }

    @Override
    public void display() {
        System.out.println(
                "Sales Person | ID: " + getId() +
                ", Name: " + getName() +
                ", Salary: " + getSalary() +
                ", Sales Target: " + salesTarget
        );
    }
}