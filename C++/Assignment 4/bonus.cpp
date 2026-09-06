#include <iostream>
#include <vector>
#include <string>

using namespace std;

// ==========================================
// Part A: Abstract DataProcessor Interface
// ==========================================

class DataProcessor {
public:
    virtual ~DataProcessor() = default;

    virtual void loadData(const string& source) = 0;
    virtual void processData() = 0;
    virtual void exportResult(const string& destination) = 0;
    virtual string processorType() const = 0;
    virtual int recordCount() const = 0;

    virtual void printSummary() const {
        cout << "--- " << processorType() << " Summary ---" << endl;
        cout << "Total Records Processed: " << recordCount() << endl;
    }
};

// Concrete Implementation 1: CSVProcessor
class CSVProcessor : public DataProcessor {
private:
    vector<string> records;

public:
    void loadData(const string& source) override {
        records = {"JOHN,DOE", "JANE,SMITH", "ALICE,JONES", "BOB,BROWN", "CHARLIE,DAVIS"};
    }

    void processData() override {}

    void exportResult(const string& destination) override {
        cout << "[CSV EXPORT " << destination << "]" << endl;
    }

    string processorType() const override {
        return "CSV Processor";
    }

    int recordCount() const override {
        return static_cast<int>(records.size());
    }
};

// Concrete Implementation 2: SensorStreamProcessor
class SensorStreamProcessor : public DataProcessor {
private:
    vector<double> readings;
    double meanValue;

public:
    SensorStreamProcessor() : meanValue(0.0) {}

    void loadData(const string& source) override {
        readings = {23.4, 21.8, 25.1, 22.9, 24.0, 26.3, 20.5, 23.8};
    }

    void processData() override {
        double sum = 0.0;
        for (double val : readings) sum += val;
        meanValue = sum / readings.size();
    }

    void exportResult(const string& destination) override {
        cout << "[SENSOR EXPORT " << destination << "]" << endl;
    }

    string processorType() const override {
        return "Sensor Stream Processor";
    }

    int recordCount() const override {
        return static_cast<int>(readings.size());
    }

    // Required getter for Bonus question
    double getMean() const {
        return meanValue;
    }
};

// ==========================================
// Main Demonstration
// ==========================================

int main() {
    vector<DataProcessor*> pipeline;
    pipeline.push_back(new CSVProcessor());
    pipeline.push_back(new SensorStreamProcessor());

    // Execute standard pipeline processing
    for (auto* p : pipeline) {
        p->loadData("source_data");
        p->processData();
        p->printSummary();
        p->exportResult("output_dir");
        cout << "---" << endl;
    }

    // ==========================================
    // BONUS: Dynamic Cast Safety Check
    // ==========================================
    cout << "\n=== BONUS: Dynamic Cast Safety Check ===" << endl;

    for (auto* p : pipeline) {
        if (auto* csv = dynamic_cast<CSVProcessor*>(p)) {
            cout << "Found CSV Processor with " << csv->recordCount() << " records." << endl;
        } else if (auto* sensor = dynamic_cast<SensorStreamProcessor*>(p)) {
            cout << "Found Sensor Processor Mean: " << sensor->getMean() << endl;
        }
    }

    /*
     * EXPLANATION: static_cast vs dynamic_cast Safety
     * ------------------------------------------------
     * 1. Why static_cast is unsafe here:
     *    `static_cast` performs standard downcasting at compile time without any runtime 
     *    type verification. If we forcibly cast a `DataProcessor*` pointing to a 
     *    `CSVProcessor` instance into a `SensorStreamProcessor*`, `static_cast` will succeed 
     *    at compile time. Calling `getMean()` on that invalid pointer would read garbage 
     *    memory or trigger undefined behavior / segmentation fault.
     *
     * 2. Why dynamic_cast is safe here:
     *    `dynamic_cast` uses RTTI (Run-Time Type Information) to inspect the object's actual 
     *    type at runtime. If the cast target type does not match the actual derived object 
     *    type, `dynamic_cast` returns `nullptr`. This allows safely checking types using an 
     *    `if` condition before invoking subclass-specific functions like `getMean()`.
     */

    // Clean up pipeline pointers
    for (auto* p : pipeline) {
        delete p;
    }
    pipeline.clear();

    return 0;
}