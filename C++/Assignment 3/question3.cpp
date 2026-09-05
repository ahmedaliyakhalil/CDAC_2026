#include <iostream>
#include <string>

using namespace std;

class LogBuffer {
private:
    char* buffer;
    int capacity;
    int size;

    static int instanceCount;

public:
    // Parametric Constructor
    LogBuffer(int cap) : capacity(cap), size(0) {
        buffer = new char[capacity];
        buffer[0] = '\0';
        instanceCount++;
        cout << "[LogBuffer Created] capacity=" << capacity << endl;
    }

    // Copy Constructor — Deep Copy without cstring
    LogBuffer(const LogBuffer& other) : capacity(other.capacity), size(other.size) {
        buffer = new char[capacity];
        for (int i = 0; i < size; i++) {
            buffer[i] = other.buffer[i];
        }
        buffer[size] = '\0';
        instanceCount++;
        cout << "[LogBuffer Deep Copied] capacity=" << capacity << endl;
    }

    // Copy Assignment Operator — without cstring
    LogBuffer& operator=(const LogBuffer& other) {
        if (this == &other) {
            cout << "[Self-assignment detected – no operation]" << endl;
            return *this;
        }

        delete[] buffer;

        capacity = other.capacity;
        size = other.size;
        buffer = new char[capacity];
        for (int i = 0; i < size; i++) {
            buffer[i] = other.buffer[i];
        }
        buffer[size] = '\0';

        cout << "[LogBuffer Assigned]" << endl;
        return *this;
    }

    // Destructor
    ~LogBuffer() {
        delete[] buffer;
        instanceCount--;
        cout << "[LogBuffer Destroyed]" << endl;
    }

    // Helper method to append text without cstring
    void append(const string& str) {
        for (char c : str) {
            if (size < capacity - 1) {
                buffer[size++] = c;
            } else {
                break;
            }
        }
        buffer[size] = '\0';
    }

    void display(const string& label) const {
        if (!label.empty()) {
            cout << label << " : ";
        }
        cout << buffer << endl;
    }

    static int getInstanceCount() {
        return instanceCount;
    }
};

// Initialize static member variable
int LogBuffer::instanceCount = 0;

int main() {
    // 1. Creation and writing log entries
    LogBuffer log1(256);
    log1.append("Server started on port 8080 | Request received from 192.168.1.10");
    log1.display("");

    cout << endl;

    // 2. Deep Copy
    LogBuffer log2 = log1;
    log2.append(" | Cached response sent");
    log1.display("log1");
    log2.display("log2");

    cout << endl;

    // 3. Assignment Operator
    LogBuffer log3(128);
    log3 = log1;
    log3.display("log3");

    cout << endl;

    // 4. Self-assignment check
    log3 = log3;

    return 0;
}