/*6. Write a program by creating an 'Employee' class having the following methods 
and print the final salary.
1 - 'getInfo()' which takes the salary, number of hours of work per day of employee
as parameter
2 - 'addSal()' which adds $10 to salary of the employee if it is less than $500.
3 - 'addWork()' which adds $5 to salary of employee if the number of hours of 
work per day is more than 6 hours*/


package easyAssg1;

class Employeedemo {

    double salary;
    int hours;

    void getInfo(double s, int h) {
        salary = s;
        hours = h;
    }

    void addSal() {

        if (salary < 500) {
            salary = salary + 10;
        }
    }

    void addWork() {

        if (hours > 6) {
            salary = salary + 5;
        }
    }

    void displaySalary() {
        System.out.println("Final salary = $" + salary);
    }
}

public class qstn6 {

    public static void main(String[] args) {

        Employeedemo e = new Employeedemo();

        e.getInfo(450, 8);

        e.addSal();
        e.addWork();

        e.displaySalary();
    }
}


