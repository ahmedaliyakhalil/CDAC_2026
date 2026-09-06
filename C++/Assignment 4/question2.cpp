#include <iostream>
#include <string>
#include <vector>

using namespace std;

// ==========================================
// Part A: Class Hierarchy Design
// ==========================================

// Base Class: Vehicle
class Vehicle {
protected:
    string registrationNo;
    string ownerName;
    int yearOfManufacture;
    double kmDriven;

public:
    Vehicle(const string& reg, const string& owner, int year, double km)
        : registrationNo(reg), ownerName(owner), yearOfManufacture(year), kmDriven(km) {
        cout << "[Vehicle Constructor] " << registrationNo << ": " << ownerName << endl;
    }

    virtual ~Vehicle() {
        cout << "[Vehicle Destructor] " << registrationNo << endl;
    }

    virtual double fuelCost(double kmToTravel) const = 0; // Pure virtual
    virtual string vehicleType() const = 0;              // Pure virtual

    // Alias helper to resolve getVehicleType() method calls
    string getVehicleType() const {
        return vehicleType();
    }

    virtual void describe() const {
        cout << "Reg: " << registrationNo 
             << " | Owner: " << ownerName 
             << " | Year: " << yearOfManufacture 
             << " | Odometer: " << kmDriven << " km";
    }

    double getKmDriven() const { return kmDriven; }
    string getRegNo() const { return registrationNo; }
    string getOwnerName() const { return ownerName; }
};

// Single Inheritance: Car
class Car : public Vehicle {
private:
    string fuelType; // "Petrol" or "Diesel"
    double mileageKmpl;

public:
    Car(const string& reg, const string& owner, int year, double km, const string& fuel, double mileage)
        : Vehicle(reg, owner, year, km), fuelType(fuel), mileageKmpl(mileage) {
        cout << "[Car Constructor] " << registrationNo << endl;
    }

    ~Car() override {
        cout << "[Car Destructor] " << registrationNo << endl;
    }

    double fuelCost(double kmToTravel) const override {
        double fuelPrice = (fuelType == "Petrol" || fuelType == "petrol") ? 106.00 : 93.00;
        return (kmToTravel / mileageKmpl) * fuelPrice;
    }

    string vehicleType() const override {
        return "Car";
    }

    void describe() const override {
        Vehicle::describe();
        cout << " | Fuel: " << fuelType << " | Mileage: " << mileageKmpl << " km/L";
    }

    string getFuelType() const { return fuelType; }
};

// Single Inheritance: Truck
class Truck : public Vehicle {
protected:
    double payloadCapacityTons;
    double fuelEfficiencyKmpl;

public:
    Truck(const string& reg, const string& owner, int year, double km, double payload, double efficiency)
        : Vehicle(reg, owner, year, km), payloadCapacityTons(payload), fuelEfficiencyKmpl(efficiency) {
        cout << "[Truck Constructor] " << registrationNo << endl;
    }

    ~Truck() override {
        cout << "[Truck Destructor] " << registrationNo << endl;
    }

    double fuelCost(double kmToTravel) const override {
        double effectiveEfficiency = fuelEfficiencyKmpl * (1.0 - 0.05 * payloadCapacityTons);
        double dieselPrice = 93.00;
        return (kmToTravel / effectiveEfficiency) * dieselPrice;
    }

    string vehicleType() const override {
        return "Truck";
    }

    void describe() const override {
        Vehicle::describe();
        cout << " | Payload: " << payloadCapacityTons << " Tons | Base Efficiency: " << fuelEfficiencyKmpl << " km/L";
    }
};

// Multilevel Inheritance: ElectricTruck
class ElectricTruck : public Truck {
private:
    double batteryCapacityKWh;
    double rangePerChargeKm;

public:
    ElectricTruck(const string& reg, const string& owner, int year, double km, 
                 double payload, double efficiency, double battery, double range)
        : Truck(reg, owner, year, km, payload, efficiency), 
          batteryCapacityKWh(battery), rangePerChargeKm(range) {
        cout << "[ElectricTruck Constructor] " << registrationNo << endl;
    }

    ~ElectricTruck() override {
        cout << "[ElectricTruck Destructor] " << registrationNo << endl;
    }

    double fuelCost(double kmToTravel) const override {
        double electricityCostPerUnit = 9.50;
        return (kmToTravel / rangePerChargeKm) * batteryCapacityKWh * electricityCostPerUnit;
    }

    string vehicleType() const override {
        return "Electric Truck";
    }

    void describe() const override {
        Truck::describe();
        cout << " | Battery: " << batteryCapacityKWh << " kWh | Range: " << rangePerChargeKm << " km";
    }

    void printBatteryStatus() const {
        cout << "[Battery: 85% charged]";
    }
};

// Hierarchical Inheritance: Van
class Van : public Vehicle {
private:
    int seatingCapacity;
    double mileageKmpl;

public:
    Van(const string& reg, const string& owner, int year, double km, int seats, double mileage)
        : Vehicle(reg, owner, year, km), seatingCapacity(seats), mileageKmpl(mileage) {
        cout << "[Van Constructor] " << registrationNo << endl;
    }

    ~Van() override {
        cout << "[Van Destructor] " << registrationNo << endl;
    }

    double fuelCost(double kmToTravel) const override {
        double petrolPrice = 106.00;
        return (kmToTravel / mileageKmpl) * petrolPrice;
    }

    string vehicleType() const override {
        return "Van";
    }

    void describe() const override {
        Vehicle::describe();
        cout << " | Seats: " << seatingCapacity << " | Mileage: " << mileageKmpl << " km/L";
    }
};

// ==========================================
// Formatting Helpers (No <iomanip>)
// ==========================================

string padRight(const string& str, size_t totalLength) {
    if (str.length() >= totalLength) return str;
    return str + string(totalLength - str.length(), ' ');
}

string formatKm(double km) {
    string str = to_string((long long)km);
    int n = str.length();
    if (n <= 3) return str;
    
    string result = "";
    int count = 0;
    for (int i = n - 1; i >= 0; i--) {
        result += str[i];
        count++;
        if (count == 3 && i != 0) {
            result += ',';
        } else if (count > 3 && (count - 3) % 2 == 1 && i != 0) {
            result += ',';
        }
    }
    for (size_t i = 0; i < result.length() / 2; i++) {
        swap(result[i], result[result.length() - 1 - i]);
    }
    return result;
}

string formatCurrency(double amount) {
    long long totalCents = (long long)(amount * 100 + 0.5);
    long long dollars = totalCents / 100;
    long long cents = totalCents % 100;

    string dollarsStr = to_string(dollars);
    string result = "";
    int count = 0;
    for (int i = dollarsStr.length() - 1; i >= 0; i--) {
        result += dollarsStr[i];
        count++;
        if (count == 3 && i != 0) result += ',';
    }
    for (size_t i = 0; i < result.length() / 2; i++) {
        swap(result[i], result[result.length() - 1 - i]);
    }

    string centsStr = to_string(cents);
    if (centsStr.length() < 2) centsStr = "0" + centsStr;

    return result + "." + centsStr;
}

// ==========================================
// Part C: Polymorphic Fleet Report
// ==========================================

void printFleetReport(const vector<Vehicle*>& fleet, double tripKm) {
    cout << "\n===== FLEET REPORT =====\n";
    cout << "Trip Distance: " << (int)tripKm << " km\n\n";

    cout << padRight("Reg", 12) 
         << padRight("Type", 16) 
         << padRight("Owner", 20) 
         << padRight("Km Driven", 12) << "\n";

    for (const auto* vehicle : fleet) {
        cout << padRight(vehicle->getRegNo(), 12)
             << padRight(vehicle->getVehicleType(), 16)
             << padRight(vehicle->getOwnerName(), 20)
             << padRight(formatKm(vehicle->getKmDriven()), 12) << "\n";
    }

    cout << "\n===== FUEL / CHARGE COST ESTIMATE =====\n";

    const Vehicle* mostEfficient = nullptr;
    double minCost = -1.0;

    for (const auto* vehicle : fleet) {
        double cost = vehicle->fuelCost(tripKm);

        string label = vehicle->getRegNo() + " (" + vehicle->getVehicleType() + ")";
        cout << padRight(label, 26) << ": Rs. " << formatCurrency(cost);

        if (auto et = dynamic_cast<const ElectricTruck*>(vehicle)) {
            cout << " ";
            et->printBatteryStatus();
            cout << "\n";
        } else if (auto car = dynamic_cast<const Car*>(vehicle)) {
            cout << " (" << car->getFuelType() << ")\n";
        } else {
            cout << "\n";
        }

        if (minCost < 0 || cost < minCost) {
            minCost = cost;
            mostEfficient = vehicle;
        }
    }

    if (mostEfficient) {
        cout << "\nMost Efficient Vehicle: " << mostEfficient->getRegNo() 
             << " (" << mostEfficient->getVehicleType() << ") Rs. " 
             << formatCurrency(minCost) << " for " << (int)tripKm << " km\n";
    }
}

// ==========================================
// Main Function
// ==========================================

int main() {
    {
        ElectricTruck stackTruck("V-ET001", "Green Logistics", 2024, 15000, 5.0, 4.0, 100.0, 250.0);
    } 

    vector<Vehicle*> fleet;

    fleet.push_back(new Car("KA01AA001", "Ramesh Kumar", 2021, 45200, "Petrol", 18.7445));
    fleet.push_back(new Truck("MH04BB002", "Shyam Logistics", 2019, 123500, 3.2, 8.8));
    fleet.push_back(new ElectricTruck("GJ07CC003", "Green Fleet Co", 2023, 89000, 5.0, 4.0, 102.0, 500.0));

    printFleetReport(fleet, 200.0);

    for (auto* vehicle : fleet) {
        delete vehicle;
    }
    fleet.clear();

    return 0;
}