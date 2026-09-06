#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

// ==========================================
// Part A: Abstract DataProcessor Interface
// ==========================================

class DataProcessor {
public:
    virtual ~DataProcessor() = default;

    // Pure virtual functions
    virtual void loadData(const string& source) = 0;
    virtual void processData() = 0;
    virtual void exportResult(const string& destination) = 0;
    virtual string processorType() const = 0;
    virtual int recordCount() const = 0;

    // Non-pure virtual base function provides default report format
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
        cout << "Loading CSV data from: " << source << endl;
        // Hardcoded 5 sample rows
        records = {
            "john,doe,developer",
            "jane,smith,manager",
            "alice,johnson,designer",
            "bob,brown,analyst",
            "charlie,davis,tester"
        };
    }

    void processData() override {
        for (auto& row : records) {
            for (char& c : row) {
                // ASCII manual conversion to uppercase (without <cctype>)
                if (c >= 'a' && c <= 'z') {
                    c = c - ('a' - 'A');
                }
            }
        }
    }

    void exportResult(const string& destination) override {
        cout << "[CSV EXPORT " << destination << "]" << endl;
        for (const auto& row : records) {
            cout << "  " << row << endl;
        }
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
    double minValue;
    double maxValue;

public:
    SensorStreamProcessor() : meanValue(0.0), minValue(0.0), maxValue(0.0) {}

    void loadData(const string& source) override {
        cout << "Reading sensor stream from: " << source << endl;
        // Hardcoded 8 sensor readings
        readings = {23.4, 21.8, 25.1, 22.9, 24.0, 26.3, 20.5, 23.8};
    }

    void processData() override {
        if (readings.empty()) return;

        double sum = 0.0;
        minValue = readings[0];
        maxValue = readings[0];

        for (double val : readings) {
            sum += val;
            if (val < minValue) minValue = val;
            if (val > maxValue) maxValue = val;
        }
        meanValue = sum / readings.size();
    }

    void exportResult(const string& destination) override {
        cout << "[SENSOR EXPORT " << destination << "]" << endl;
        cout << "  Mean: " << meanValue << " | Min: " << minValue << " | Max: " << maxValue << endl;
    }

    string processorType() const override {
        return "Sensor Stream Processor";
    }

    int recordCount() const override {
        return static_cast<int>(readings.size());
    }

    double getMean() const {
        return meanValue;
    }
};

// ==========================================
// Part B: Class Template DataBuffer<T>
// ==========================================

/*
 * NOTE ON TEMPLATE DEFINITIONS:
 * Template code must reside entirely in header files (or within a single translation unit).
 * This is because template instantiation happens at compile time. The compiler must see 
 * the full implementation of template functions when instantiated with a specific type T. 
 * If defined in a separate .cpp file, the compiler won't generate code for other files, 
 * causing linker errors.
 */

template <typename T>
class DataBuffer {
private:
    T* data;
    int capacity;
    int head;  // Index of oldest element
    int tail;  // Index where next element is written
    int count; // Current number of elements

public:
    DataBuffer(int cap) : capacity(cap), head(0), tail(0), count(0) {
        data = new T[capacity];
    }

    ~DataBuffer() {
        delete[] data;
    }

    bool isEmpty() const { return count == 0; }
    bool isFull() const { return count == capacity; }
    int size() const { return count; }

    void push(const T& value) {
        data[tail] = value;
        tail = (tail + 1) % capacity;

        if (isFull()) {
            // Buffer was full; overwrite oldest element and advance head
            head = (head + 1) % capacity;
        } else {
            count++;
        }
    }

    T pop() {
        if (isEmpty()) {
            // Manual error handling without <stdexcept>
            cout << "Error: Buffer is empty" << endl;
            return T();
        }
        T value = data[head];
        head = (head + 1) % capacity;
        count--;
        return value;
    }

    T peek() const {
        if (isEmpty()) {
            cout << "Error: Buffer is empty" << endl;
            return T();
        }
        return data[head];
    }

    template <typename U>
    friend ostream& operator<<(ostream& out, const DataBuffer<U>& buf);
};

template <typename U>
ostream& operator<<(ostream& out, const DataBuffer<U>& buf) {
    out << "[";
    for (int i = 0; i < buf.count; ++i) {
        int idx = (buf.head + i) % buf.capacity;
        out << buf.data[idx];
        if (i < buf.count - 1) out << ", ";
    }
    out << "]";
    return out;
}

// ==========================================
// Demonstration
// ==========================================

int main() {
    // ---------------------------------------------------
    // Part A: Abstract Interface Demonstration
    // ---------------------------------------------------
    cout << "=== PART A: ABSTRACT DATA PROCESSOR PIPELINE ===" << endl;

    // UNCOMMENTING THE LINE BELOW CAUSES A COMPILER ERROR:
    // DataProcessor dp; 
    // Explanation: DataProcessor is an abstract class containing pure virtual functions.
    // Abstract classes cannot be instantiated directly.

    vector<DataProcessor*> pipeline;
    pipeline.push_back(new CSVProcessor());
    pipeline.push_back(new SensorStreamProcessor());

    for (auto* p : pipeline) {
        p->loadData("source_data");
        p->processData();
        p->printSummary();
        p->exportResult("output_dir");
        cout << "---" << endl;
    }

    // Bonus: dynamic_cast Safety Check
    cout << "\n--- Bonus: Dynamic Cast Safety Check ---" << endl;
    for (auto* p : pipeline) {
        if (auto* csv = dynamic_cast<CSVProcessor*>(p)) {
            cout << "Found CSV Processor with " << csv->recordCount() << " records." << endl;
        } else if (auto* sensor = dynamic_cast<SensorStreamProcessor*>(p)) {
            cout << "Found Sensor Processor Mean: " << sensor->getMean() << endl;
        }
    }
    /*
     * SAFETY NOTE:
     * static_cast performs a compile-time cast without runtime type checking. Performing a static_cast 
     * on an incompatible object pointer can result in undefined behavior or memory corruption.
     * dynamic_cast performs a runtime check using RTTI (Run-Time Type Information) and returns nullptr 
     * if the object type does not match, making downcasting safe.
     */

    // Cleanup Pipeline Objects
    for (auto* p : pipeline) {
        delete p;
    }
    pipeline.clear();

    // ---------------------------------------------------
    // Part B: Class Template DataBuffer<T> Demonstration
    // ---------------------------------------------------
    cout << "\n=== PART B: CLASS TEMPLATE DATABUFFER<T> ===" << endl;

    // 1. Integer buffer (Simulate sensor tick IDs)
    DataBuffer<int> tickBuffer(5);
    for (int i = 1; i <= 7; i++) {
        tickBuffer.push(i * 10); // Overwrites oldest elements (10 and 20)
    }
    cout << "Tick Buffer: " << tickBuffer << endl;

    // 2. Double buffer (Simulate temperature readings)
    DataBuffer<double> tempBuffer(4);
    tempBuffer.push(36.6); 
    tempBuffer.push(37.1);
    tempBuffer.push(38.2); 
    tempBuffer.push(36.9);

    cout << "Before pop: " << tempBuffer << endl;
    cout << "Popped: " << tempBuffer.pop() << endl;
    cout << "After pop: " << tempBuffer << endl;

    // 3. String buffer (Simulate log message queue)
    DataBuffer<string> logBuffer(3);
    logBuffer.push("INFO: Server started");
    logBuffer.push("WARN: High memory usage");
    logBuffer.push("ERROR: DB connection timeout");
    logBuffer.push("INFO: Retry successful"); // Overwrites oldest ("INFO: Server started")

    cout << "Log Buffer: " << logBuffer << endl;

    return 0;
}