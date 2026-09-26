

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeAssignment {

    static Scanner sc = new Scanner(System.in);

    static EmployeeDoublyLinkedList employees =
            new EmployeeDoublyLinkedList();

    static final String FILE_NAME = "employees.dat";

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n================================");
            System.out.println("       EMPLOYEE APPLICATION");
            System.out.println("================================");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display");
            System.out.println("3. Sort");
            System.out.println("4. Save to File");
            System.out.println("5. Load from File");
            System.out.println("6. Exit");
            System.out.println("================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addEmployeeMenu();
                    break;

                case 2:
                    displayMenu();
                    break;

                case 3:
                    sortMenu();
                    break;

                case 4:
                    saveToFile();
                    break;

                case 5:
                    loadFromFile();
                    break;

                case 6:
                    System.out.println(
                            "Program terminated."
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }

        } while (choice != 6);

        sc.close();
    }

    // ==================================================
    // ADD EMPLOYEE MENU
    // ==================================================

    public static void addEmployeeMenu() {

        while (true) {

            System.out.println("\n----- ADD EMPLOYEE -----");
            System.out.println("a. Manager");
            System.out.println("b. Engineer");
            System.out.println("c. Sales Person");
            System.out.println("d. Exit to Main Menu");

            System.out.print("Enter choice: ");

            char choice = sc.next().charAt(0);

            switch (choice) {

                case 'a':
                case 'A':
                    addManager();
                    break;

                case 'b':
                case 'B':
                    addEngineer();
                    break;

                case 'c':
                case 'C':
                    addSalesPerson();
                    break;

                case 'd':
                case 'D':
                    return;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }

    // ==================================================
    // ADD MANAGER
    // ==================================================

    public static void addManager() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        Manager manager =
                new Manager(
                        id,
                        name,
                        salary,
                        department
                );

        employees.add(manager);

        System.out.println(
                "Manager added successfully."
        );
    }

    // ==================================================
    // ADD ENGINEER
    // ==================================================

    public static void addEngineer() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        sc.nextLine();

        System.out.print("Enter Technology: ");
        String technology = sc.nextLine();

        Engineer engineer =
                new Engineer(
                        id,
                        name,
                        salary,
                        technology
                );

        employees.add(engineer);

        System.out.println(
                "Engineer added successfully."
        );
    }

    // ==================================================
    // ADD SALES PERSON
    // ==================================================

    public static void addSalesPerson() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        System.out.print("Enter Sales Target: ");
        double target = sc.nextDouble();

        SalesPerson salesPerson =
                new SalesPerson(
                        id,
                        name,
                        salary,
                        target
                );

        employees.add(salesPerson);

        System.out.println(
                "Sales Person added successfully."
        );
    }

    // ==================================================
    // DISPLAY MENU
    // ==================================================

    public static void displayMenu() {

        while (true) {

            System.out.println("\n----- DISPLAY -----");
            System.out.println("a. All Employees");
            System.out.println("b. First Employee");
            System.out.println("c. Next Employee");
            System.out.println("d. Previous Employee");
            System.out.println("e. Last Employee");
            System.out.println("f. Exit to Main Menu");

            System.out.print("Enter choice: ");

            char choice = sc.next().charAt(0);

            switch (choice) {

                case 'a':
                case 'A':
                    employees.displayAll();
                    break;

                case 'b':
                case 'B':
                    employees.displayFirst();
                    break;

                case 'c':
                case 'C':
                    employees.displayNext();
                    break;

                case 'd':
                case 'D':
                    employees.displayPrevious();
                    break;

                case 'e':
                case 'E':
                    employees.displayLast();
                    break;

                case 'f':
                case 'F':
                    return;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }

    // ==================================================
    // SORT MENU
    // ==================================================

    public static void sortMenu() {

        while (true) {

            System.out.println("\n----- SORT -----");
            System.out.println("a. All Managers");
            System.out.println("b. All Engineers");
            System.out.println("c. All Sales Person");
            System.out.println(
                    "d. All Employees Alphabetic order ascending"
            );
            System.out.println(
                    "e. All Employees Alphabetic order descending"
            );
            System.out.println("f. Exit to Main Menu");

            System.out.print("Enter choice: ");

            char choice = sc.next().charAt(0);

            switch (choice) {

                case 'a':
                case 'A':
                    employees.displayManagers();
                    break;

                case 'b':
                case 'B':
                    employees.displayEngineers();
                    break;

                case 'c':
                case 'C':
                    employees.displaySalesPersons();
                    break;

                case 'd':
                case 'D':
                    employees.sortAscending();
                    break;

                case 'e':
                case 'E':
                    employees.sortDescending();
                    break;

                case 'f':
                case 'F':
                    return;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }

    // ==================================================
    // SAVE TO FILE
    // ==================================================

    public static void saveToFile() {

        try {

            ArrayList<Employee> employeeArray =
                    employees.getEmployees();

            ObjectOutputStream out =
                    new ObjectOutputStream(
                            new FileOutputStream(FILE_NAME)
                    );

            out.writeObject(employeeArray);

            out.close();

            System.out.println(
                    "Employees saved successfully."
            );

        } catch (Exception e) {

            System.out.println(
                    "Error while saving employees."
            );

            System.out.println(
                    "Reason: " + e.getMessage()
            );
        }
    }

    // ==================================================
    // LOAD FROM FILE
    // ==================================================

    @SuppressWarnings("unchecked")
    public static void loadFromFile() {

        try {

            ObjectInputStream in =
                    new ObjectInputStream(
                            new FileInputStream(FILE_NAME)
                    );

            ArrayList<Employee> employeeArray =
                    (ArrayList<Employee>) in.readObject();

            in.close();

            employees.addAll(employeeArray);

            System.out.println(
                    "Employees loaded successfully."
            );

            System.out.println(
                    employeeArray.size()
                    + " employees loaded."
            );

        } catch (Exception e) {

            System.out.println(
                    "Error while loading employees."
            );

            System.out.println(
                    "Reason: " + e.getMessage()
            );
        }
    }
}