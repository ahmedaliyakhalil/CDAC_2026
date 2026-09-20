/*5. Write a program that would print the information (name, year of joining, salary, 
address) of three employees by creating a class named 'Employee'. The output 
should be as follows:
Name      
Robert
Sam  
John        
  Year of joining        Address
            1994                64C- WallsStreat
              2000                68D- WallsStreat
        1999    
            26B- WallsStreat*/

package easyAssg1;


class Employee {

    String name;
    int year;
    double salary;
    String address;

    Employee(String n, int y, double s, String a) {
        name = n;
        year = y;
        salary = s;
        address = a;
    }

    void display() {

        System.out.println(
            name + "\t" + year + "\t" + salary + "\t" + address
        );
    }
}

public class qstn5 {

    public static void main(String[] args) {

        Employee e1 = new Employee(
            "Robert", 1994, 50000, "64C-WallStreet"
        );

        Employee e2 = new Employee(
            "Sam", 2000, 45000, "68D-WallStreet"
        );

        Employee e3 = new Employee(
            "John", 1999, 55000, "26B-WallStreet"
        );

        System.out.println("Name\tYear\tSalary\tAddress");

        e1.display();
        e2.display();
        e3.display();
    }
}


