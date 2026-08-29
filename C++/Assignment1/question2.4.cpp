#include <iostream>

using namespace std;

// Function to locate min and max elements and return their memory addresses
void findMinMax(const int* packet, int size, const int** minPtr, const int** maxPtr) {
    if (size <= 0) {
        *minPtr = nullptr;
        *maxPtr = nullptr;
        return;
    }

    // Initialize output pointers to point to the first element
    *minPtr = packet;
    *maxPtr = packet;

    const int* ptr = packet;

    for (int i = 0; i < size; ++i) {
        // Compare values pointed to by current pointer vs current min/max pointers
        if (*ptr < **minPtr) {
            *minPtr = ptr;
        }
        if (*ptr > **maxPtr) {
            *maxPtr = ptr;
        }
        ptr++; // Move to next memory location
    }
}

int main() {
    int packet[] = {42, 15, 88, 3, 67, 99, 24, 11};
    int size = sizeof(packet) / sizeof(packet[0]);

    const int* pMin = nullptr;
    const int* pMax = nullptr;

    // Call parser passing addresses of pointers (pMin and pMax)
    findMinMax(packet, size, &pMin, &pMax);

    cout << "--- Calibration Packet Parser ---" << endl;
    cout << "Buffer Address : " << packet << endl << endl;

    if (pMin && pMax) {
        // Calculate offset indices using pointer subtraction
        int minIndex = pMin - packet;
        int maxIndex = pMax - packet;

        cout << "Minimum Sensor Value:" << endl;
        cout << "  Value   : " << *pMin << endl;
        cout << "  Address : " << pMin << " (Offset Index: " << minIndex << ")" << endl << endl;

        cout << "Maximum Sensor Value:" << endl;
        cout << "  Value   : " << *pMax << endl;
        cout << "  Address : " << pMax << " (Offset Index: " << maxIndex << ")" << endl;
    }

    return 0;
}