#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

// Maximum capacity for array-based inventory
const int MAX_PRODUCTS = 100;

// Struct definition for Product
struct Product {
    int id;
    string name;
    double price;
    int quantity;
    double totalValue;
};

// Function prototypes (Part B - Function Overloading & Default Arguments)
double reorderCost(int qty, double unitPrice);
double reorderCost(double qty, double unitPrice);
double reorderCost(int qty, double unitPrice, double taxRate);
double applyDiscount(double price, double discountPercent = 10.0);

int main() {
    Product inventory[MAX_PRODUCTS];
    int count = 0;

    // --- Part A (Points 1 & 2): Input details for N products using a loop ---
    cout << "Enter number of products to add: ";
    cin >> count;

    for (int i = 0; i < count; i++) {
        cout << "\nEnter details for Product " << (i + 1) << ":\n";
        cout << "ID: ";
        cin >> inventory[i].id;
        cout << "Name: ";
        cin >> inventory[i].name;
        cout << "Price: ";
        cin >> inventory[i].price;
        cout << "Quantity: ";
        cin >> inventory[i].quantity;

        // Calculate total value for each product
        inventory[i].totalValue = inventory[i].price * inventory[i].quantity;
    }

    // --- Part A (Point 3): Display all products in a formatted table ---
    cout << "\n===== INVENTORY REPORT =====\n";
    cout << left << setw(8) << "ID" 
         << setw(12) << "Name" 
         << setw(10) << "Price" 
         << setw(8) << "Qty" 
         << setw(14) << "Total Value" << endl;
    cout << "--------------------------------------------------\n";

    for (int i = 0; i < count; i++) {
        cout << left << setw(8) << inventory[i].id 
             << setw(12) << inventory[i].name 
             << setw(10) << fixed << setprecision(2) << inventory[i].price 
             << setw(8) << inventory[i].quantity 
             << setw(14) << inventory[i].totalValue << endl;
    }

    // --- Part A (Point 4): Find and print product with the highest total value ---
    int highestIdx = 0;
    for (int i = 1; i < count; i++) {
        if (inventory[i].totalValue > inventory[highestIdx].totalValue) {
            highestIdx = i;
        }
    }

    cout << "\nHighest Value Product : " << inventory[highestIdx].name 
         << " (Rs. " << fixed << setprecision(2) << inventory[highestIdx].totalValue << ")\n";

    // --- Part A (Point 5): Print products where quantity is below low-stock threshold ---
    int threshold;
    cout << "\nEnter Low Stock Threshold: ";
    cin >> threshold;

    cout << "Low Stock (threshold: " << threshold << ") : ";
    bool first = true;
    for (int i = 0; i < count; i++) {
        if (inventory[i].quantity < threshold) {
            if (!first) cout << ", ";
            cout << inventory[i].name;
            first = false;
        }
    }
    if (first) cout << "None";
    cout << endl;

    // --- Part B Demonstrations ---
    cout << "\n===== PART B: REORDER COSTS & DISCOUNTS =====\n";
    cout << "Reorder Cost (50 units @ Rs 100.00): Rs " << fixed << setprecision(2) << reorderCost(50, 100.0) << endl;
    cout << "Reorder Cost (12.5 kg @ Rs 200.00): Rs " << reorderCost(12.5, 200.0) << endl;
    cout << "Reorder Cost (50 units @ Rs 100.00 + 18% Tax): Rs " << reorderCost(50, 100.0, 18.0) << endl;
    cout << "Discounted Price (Rs 1000.00 with default 10% off): Rs " << applyDiscount(1000.0) << endl;
    cout << "Discounted Price (Rs 1000.00 with explicit 15% off): Rs " << applyDiscount(1000.0, 15.0) << endl;

    return 0;
}

// --- Part B Function Definitions ---

// 1. Integer quantity
double reorderCost(int qty, double unitPrice) {
    return qty * unitPrice;
}

// 2. Fractional (by weight)
double reorderCost(double qty, double unitPrice) {
    return qty * unitPrice;
}

// 3. With tax percentage
double reorderCost(int qty, double unitPrice, double taxRate) {
    double subtotal = qty * unitPrice;
    return subtotal + (subtotal * (taxRate / 100.0));
}

// 4. Default argument discount
double applyDiscount(double price, double discountPercent) {
    return price - (price * (discountPercent / 100.0));
}







/*------------------OUTPUT-------------------------------


PS D:\CDAC\c++\assignment2> D:\CDAC\c++\assignment2\question1A.exe
Enter number of products to add: 2

Enter details for Product 1:
ID: 1001
Name: Widget-A
Price: 250.00
Quantity: 120

Enter details for Product 2:
ID: 1002
Name: Bolt-b
Price: 15.50
Quantity: 8

===== INVENTORY REPORT =====
ID      Name        Price     Qty     Total Value   
--------------------------------------------------
1001    Widget-A    250.00    120     30000.00      
1002    Bolt-b      15.50     8       124.00        

Highest Value Product : Widget-A (Rs. 30000.00)

Enter Low Stock Threshold: 10
Low Stock (threshold: 10) : Bolt-b

===== PART B: REORDER COSTS & DISCOUNTS =====
Reorder Cost (50 units @ Rs 100.00): Rs 5000.00
Reorder Cost (12.5 kg @ Rs 200.00): Rs 2500.00
Reorder Cost (50 units @ Rs 100.00 + 18% Tax): Rs 5900.00
Discounted Price (Rs 1000.00 with default 10% off): Rs 900.00
Discounted Price (Rs 1000.00 with explicit 15% off): Rs 850.00

*/