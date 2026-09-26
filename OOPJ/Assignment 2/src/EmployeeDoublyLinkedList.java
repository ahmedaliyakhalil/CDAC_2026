

import java.util.ArrayList;
import java.util.Comparator;

public class EmployeeDoublyLinkedList {

    private Node<Employee> head;
    private Node<Employee> tail;
    private Node<Employee> current;

    // Add employee at the end
    public void add(Employee employee) {

        Node<Employee> newNode =
                new Node<Employee>(employee);

        if (head == null) {

            head = newNode;
            tail = newNode;
            current = newNode;

        } else {

            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    // Display all employees
    public void displayAll() {

        if (head == null) {
            System.out.println("No employees available.");
            return;
        }

        Node<Employee> temp = head;

        while (temp != null) {

            temp.data.display();

            temp = temp.next;
        }
    }

    // First employee
    public void displayFirst() {

        if (head == null) {
            System.out.println("No employees available.");
            return;
        }

        current = head;

        current.data.display();
    }

    // Next employee
    public void displayNext() {

        if (current == null) {
            System.out.println("No employee selected.");
            return;
        }

        if (current.next == null) {
            System.out.println("Already at the last employee.");
            return;
        }

        current = current.next;

        current.data.display();
    }

    // Previous employee
    public void displayPrevious() {

        if (current == null) {
            System.out.println("No employee selected.");
            return;
        }

        if (current.previous == null) {
            System.out.println("Already at the first employee.");
            return;
        }

        current = current.previous;

        current.data.display();
    }

    // Last employee
    public void displayLast() {

        if (tail == null) {
            System.out.println("No employees available.");
            return;
        }

        current = tail;

        current.data.display();
    }

    // Convert linked list to ArrayList
    private ArrayList<Employee> toArrayList() {

        ArrayList<Employee> employees =
                new ArrayList<Employee>();

        Node<Employee> temp = head;

        while (temp != null) {

            employees.add(temp.data);

            temp = temp.next;
        }

        return employees;
    }

    // Display all Managers
    public void displayManagers() {

        ArrayList<Employee> employees =
                toArrayList();

        boolean found = false;

        for (Employee employee : employees) {

            if (employee instanceof Manager) {

                employee.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Managers found.");
        }
    }

    // Display all Engineers
    public void displayEngineers() {

        ArrayList<Employee> employees =
                toArrayList();

        boolean found = false;

        for (Employee employee : employees) {

            if (employee instanceof Engineer) {

                employee.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Engineers found.");
        }
    }

    // Display all Sales Persons
    public void displaySalesPersons() {

        ArrayList<Employee> employees =
                toArrayList();

        boolean found = false;

        for (Employee employee : employees) {

            if (employee instanceof SalesPerson) {

                employee.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Sales Persons found.");
        }
    }

    // Sort ascending using Lambda + Comparator
    public void sortAscending() {

        ArrayList<Employee> employees =
                toArrayList();

        Comparator<Employee> comparator =
                (e1, e2) ->
                        e1.getName()
                           .compareToIgnoreCase(e2.getName());

        employees.sort(comparator);

        System.out.println("\nEmployees - Alphabetical Ascending:");

        for (Employee employee : employees) {

            employee.display();
        }
    }

    // Sort descending using Lambda + Comparator
    public void sortDescending() {

        ArrayList<Employee> employees =
                toArrayList();

        Comparator<Employee> comparator =
                (e1, e2) ->
                        e2.getName()
                           .compareToIgnoreCase(e1.getName());

        employees.sort(comparator);

        System.out.println("\nEmployees - Alphabetical Descending:");

        for (Employee employee : employees) {

            employee.display();
        }
    }

    // Return all employees for saving
    public ArrayList<Employee> getEmployees() {

        return toArrayList();
    }

    // Clear linked list
    public void clear() {

        head = null;
        tail = null;
        current = null;
    }

    // Add all employees after loading
    public void addAll(ArrayList<Employee> employees) {

        clear();

        for (Employee employee : employees) {

            add(employee);
        }
    }
}