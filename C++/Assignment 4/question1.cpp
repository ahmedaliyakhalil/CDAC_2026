#include <iostream>
#include <string>
#include <stdexcept>
#include <utility>

using namespace std;

class LedgerEntry {
private:
    string description;
    double* amounts;
    int days;

    static int totalEntries;

    // Helper method to compute running total
    double getTotalSum() const {
        double sum = 0.0;
        for (int i = 0; i < days; ++i) {
            sum += amounts[i];
        }
        return sum;
    }

public:
    // Parametric Constructor
    LedgerEntry(const string& desc, int d) : description(desc), days(d) {
        amounts = new double[days]();
        totalEntries++;
    }

    // Destructor
    ~LedgerEntry() {
        delete[] amounts;
        totalEntries--;
    }

    // Copy Constructor — Deep Copy
    LedgerEntry(const LedgerEntry& other) : description(other.description), days(other.days) {
        amounts = new double[days];
        for (int i = 0; i < days; ++i) {
            amounts[i] = other.amounts[i];
        }
        totalEntries++;
    }

    // Copy Assignment Operator — Deep Copy
    LedgerEntry& operator=(const LedgerEntry& other) {
        if (this != &other) {
            delete[] amounts;

            description = other.description;
            days = other.days;
            amounts = new double[days];
            for (int i = 0; i < days; ++i) {
                amounts[i] = other.amounts[i];
            }
        }
        return *this;
    }

    // Requirement 1 & 5: Move Constructor
    LedgerEntry(LedgerEntry&& other) noexcept 
        : description(move(other.description)), amounts(other.amounts), days(other.days) {
        
        // Print message confirming move constructor call
        cout << "[Move Constructor Called] Transferred ownership of " << description << endl;

        // Set other.amounts = nullptr and other.days = 0 after transferring ownership
        other.amounts = nullptr;
        other.days = 0;
        totalEntries++;
    }

    // Requirement 2 & 5: Move Assignment Operator
    LedgerEntry& operator=(LedgerEntry&& other) noexcept {
        // Handle self-assignment
        if (this != &other) {
            // delete[] existing memory before taking ownership
            delete[] amounts;

            description = move(other.description);
            amounts = other.amounts;
            days = other.days;

            // Leave source object in valid empty state
            other.amounts = nullptr;
            other.days = 0;

            // Print message confirming move assignment call
            cout << "[Move Assignment Called] Transferred ownership of " << description << endl;
        }
        return *this;
    }

    // Requirement 3: Subscript operator[] (non-const) with out_of_range check
    double& operator[](int index) {
        if (index < 0 || index >= days) {
            throw out_of_range("out_of_range: Index out of bounds!");
        }
        return amounts[index];
    }

    // Requirement 3: Subscript operator[] (const) with out_of_range check
    const double& operator[](int index) const {
        if (index < 0 || index >= days) {
            throw out_of_range("out_of_range: Index out of bounds!");
        }
        return amounts[index];
    }

    // Comparison Operators
    bool operator==(const LedgerEntry& other) const {
        return getTotalSum() == other.getTotalSum();
    }

    bool operator>(const LedgerEntry& other) const {
        return getTotalSum() > other.getTotalSum();
    }

    // Addition Operator
    LedgerEntry operator+(const LedgerEntry& other) const {
        int maxDays = (days > other.days) ? days : other.days;
        LedgerEntry result(description + " + " + other.description, maxDays);

        for (int i = 0; i < maxDays; ++i) {
            double val1 = (i < days) ? amounts[i] : 0.0;
            double val2 = (i < other.days) ? other.amounts[i] : 0.0;
            result.amounts[i] = val1 + val2;
        }

        return result;
    }

    // Requirement 4: operator<< non-member friend function printing amounts and running total
    friend ostream& operator<<(ostream& out, const LedgerEntry& entry) {
        out << entry.description << " | Amounts: [";
        for (int i = 0; i < entry.days; ++i) {
            out << entry.amounts[i] << (i == entry.days - 1 ? "" : ", ");
        }
        out << "] | Running Total: $" << entry.getTotalSum();
        return out;
    }

    static int getTotalEntries() {
        return totalEntries;
    }
};

// Initialize static member variable
int LedgerEntry::totalEntries = 0;

int main() {
    // Objective 1 — Constructor & subscript setup
    LedgerEntry jan("January Sales", 5);
    jan[0] = 1200.50; jan[1] = 3400.00; jan[2] = 800.75;
    jan[3] = 2100.00; jan[4] = 650.25;

    LedgerEntry feb("February Sales", 5);
    feb[0] = 900.00;  feb[1] = 2200.50; feb[2] = 1750.00;
    feb[3] = 3000.00; feb[4] = 475.50;

    cout << "--- 1. Print Objects via operator<< ---" << endl;
    cout << jan << endl;
    cout << feb << endl << endl;

    cout << "--- 2. Move Constructor Test ---" << endl;
    LedgerEntry movedJan = move(jan);
    cout << movedJan << endl << endl;

    cout << "--- 3. Move Assignment Test ---" << endl;
    LedgerEntry Q1("Q1 Summary", 1);
    Q1 = move(feb);
    cout << Q1 << endl << endl;

    cout << "--- 4. Out of Range Exception Test ---" << endl;
    try {
        cout << "Accessing index 10: " << Q1[10] << endl;
    } catch (const out_of_range& e) {
        cout << "Caught Exception: " << e.what() << endl;
    }

    return 0;
}