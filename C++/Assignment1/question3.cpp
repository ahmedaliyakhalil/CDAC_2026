#include <iostream>
#include <string>

using namespace std;

// Employee structure definition
struct Employee {
    int empId;
    string name;
    string dept;
    char grade;
    string status;
    double basicSalary;
    double allowances;
    double grossSalary;
    double taxDeduction;
    double netSalary;
};

// Bonus Struct Padding comparison structs
struct Layout1 {
    char c1;
    int i;
    char c2;
};

struct Layout2 {
    int i;
    char c1;
    char c2;
};

// Validation Helper Functions
bool isValidGrade(char g) {
    return (g == 'A' || g == 'B' || g == 'C' || g == 'D');
}

bool isValidDept(string d) {
    return (d == "Engineering" || d == "HR" || d == "Sales" || d == "Finance");
}

int main() {
    Employee emp;

    // Hardcoded / Default Basic Salary (No prompt asked to user)
    emp.basicSalary = 75000.00;

    cout << "=== Employee Data Entry ===" << endl;

    // Read Emp ID
    cout << "Enter Emp ID        : ";
    cin >> emp.empId;
    cin.ignore(); // Clear newline buffer

    // Read Name
    cout << "Enter Name          : ";
    getline(cin, emp.name);

    // Read and Validate Department
    while (true) {
        cout << "Enter Department    : ";
        getline(cin, emp.dept);
        if (isValidDept(emp.dept)) {
            break;
        }
        cout << "ERROR: '" << emp.dept << "' is not a registered department." << endl;
    }

    // Read and Validate Grade
    while (true) {
        cout << "Enter Grade (A-D)   : ";
        cin >> emp.grade;
        if (isValidGrade(emp.grade)) {
            break;
        }
        cout << "ERROR: Invalid grade '" << emp.grade << "'. Accepted values: A, B, C, D." << endl;
    }

    // Read Status
    cout << "Enter Status        : ";
    cin >> emp.status;

    // --- Salary Calculations ---
    emp.allowances = emp.basicSalary * 0.30;
    emp.grossSalary = emp.basicSalary + emp.allowances;

    // Calculate Tax based on Gross Salary Slabs
    if (emp.grossSalary > 100000.0) {
        emp.taxDeduction = emp.grossSalary * 0.10;
    } else if (emp.grossSalary > 50000.0) {
        emp.taxDeduction = emp.grossSalary * 0.05;
    } else {
        emp.taxDeduction = 0.0;
    }

    emp.netSalary = emp.grossSalary - emp.taxDeduction;

    // --- Print Formatted Payslip ---
    cout.setf(ios::fixed, ios::floatfield);
    cout.precision(2);

    cout << "\n--------------------------------------------" << endl;
    cout << "         EMPLOYEE PAYSLIP - AUG 2026        " << endl;
    cout << "============================================" << endl;
    cout << "Emp ID      : " << emp.empId << endl;
    cout << "Name        : " << emp.name << endl;
    cout << "Department  : " << emp.dept << endl;
    cout << "Grade       : " << emp.grade << endl;
    cout << "Status      : " << emp.status << endl;
    cout << "--------------------------------------------" << endl;
    cout << "Basic Salary     : Rs. " << emp.basicSalary << endl;
    cout << "Allowances (30%) : Rs. " << emp.allowances << endl;
    cout << "Gross Salary     : Rs. " << emp.grossSalary << endl;
    cout << "--------------------------------------------" << endl;
    cout << "Tax Deduction    : Rs. " << emp.taxDeduction << endl;
    cout << "Net Salary       : Rs. " << emp.netSalary << endl;
    cout << "--------------------------------------------" << endl;

    // --- Bonus: Struct Padding Demo ---
    cout << "\n=== Bonus: Struct Padding Demo ===" << endl;
    cout << "sizeof(Layout1) : " << sizeof(Layout1) << " bytes" << endl;
    cout << "sizeof(Layout2) : " << sizeof(Layout2) << " bytes" << endl;

    /*
     * STRUCT PADDING EXPLANATION:
     * 
     * 1. Why sizes differ:
     *    - Layout1 has (char, int, char). The CPU aligns the 4-byte int to a 
     *      4-byte memory boundary, adding 3 padding bytes after c1 and 3 
     *      padding bytes at the end (Total: 12 bytes).
     *    - Layout2 has (int, char, char). The two chars sit together, requiring 
     *      only 2 padding bytes at the end (Total: 8 bytes).
     * 
     * 2. What padding is and why the compiler adds it:
     *    - Padding adds empty filler bytes between structure members so data 
     *      aligns with CPU memory word boundaries for fast read/write access.
     * 
     * 3. Why member order matters:
     *    - In hardware register maps or network packets, unexpected compiler 
     *      padding shifts memory offsets, corrupting data transmission.
     */

    return 0;
}