#include <iostream>
#include <string>

using namespace std;

class LogBuffer {
private:
    char* buffer;
    int capacity;
    int size;

    static int instanceCount;

    // 1. Mark accessCount as mutable
    mutable int accessCount = 0;

public:
    // Parametric Constructor
    LogBuffer(int cap) : capacity(cap), size(0), accessCount(0) {
        buffer = new char[capacity];
        buffer[0] = '\0';
        instanceCount++;
    }

    // Copy Constructor — Deep Copy
    LogBuffer(const LogBuffer& other) : capacity(other.capacity), size(other.size), accessCount(0) {
        buffer = new char[capacity];
        for (int i = 0; i < size; i++) {
            buffer[i] = other.buffer[i];
        }
        buffer[size] = '\0';
        instanceCount++;
    }

    // Copy Assignment Operator
    LogBuffer& operator=(const LogBuffer& other) {
        if (this == &other) {
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

        return *this;
    }

    // Destructor
    ~LogBuffer() {
        delete[] buffer;
        instanceCount--;
    }

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

    // 2. Inside print() (which is const), increment accessCount
    void print() const {
        accessCount++;
        cout << buffer << endl;
    }

    // 3. Add a const getter: int getAccessCount() const;
    int getAccessCount() const {
        return accessCount;
    }

    static int getInstanceCount() {
        return instanceCount;
    }
};

int LogBuffer::instanceCount = 0;

int main() {
    LogBuffer log1(256);
    log1.append("Server started on port 8080 | Request received from 192.168.1.10");

    // 4. Call print() three times on a const LogBuffer object
    const LogBuffer readOnly(log1); // copy construct into a const object
    readOnly.print();
    readOnly.print();
    readOnly.print();
    cout << "Times printed: " << readOnly.getAccessCount() << endl; // must print 3

    return 0;
}

/*
========================================================================================
 EXPLANATION OF MUTABLE AND CONST MEMBER FUNCTIONS
========================================================================================

 1. Why accessCount must be mutable:
    --------------------------------
    - In C++, calling a member function on a `const` object (e.g., `readOnly`) enforces
      that the object's internal logically visible state cannot be modified.
    - Inside a `const` member function, all non-static data members are implicitly treated
      as `const T* const this`, making member variables read-only.
    - If `accessCount` were a regular member (not marked `mutable`), attempting to write
      `accessCount++` inside `print() const` would cause a compilation error.
    - Marking `accessCount` as `mutable` explicitly informs the compiler that this variable
      is an implementation detail (e.g., telemetry, cache, internal counter) that can be
      modified even on `const` object instances.

 2. What the 'const' keyword on a member function actually prevents:
    -----------------------------------------------------------------
    - The `const` modifier after a function signature promises that invoking the method will 
      NOT mutate any non-mutable member variables of the calling object (`this`).
    - It prevents reassignment/modification of member primitives (e.g., `capacity = 100`).
    - It prevents reassignment of member pointers (e.g., `buffer = new char[...]`).
    - It restricts calling any non-const member functions from within that function body.
========================================================================================
*/