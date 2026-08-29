#include <iostream>
#include <cmath> // For std::sqrt and std::abs

using namespace std;

// 1. Compute Root Mean Square (RMS) using pointers
double computeRMS(const double* signal, int n) {
    double sum_sq = 0.0;
    const double* ptr = signal;

    for (int i = 0; i < n; ++i) {
        double val = *ptr;
        sum_sq += val * val;
        ptr++; // Advance pointer
    }

    return sqrt(sum_sq / n);
}

// 2. Normalise array in-place by dividing by max absolute value
void normalise(double* signal, int n) {
    double max_abs = 0.0;
    const double* ptr = signal;

    // Find max absolute value
    for (int i = 0; i < n; ++i) {
        double abs_val = abs(*ptr);
        if (abs_val > max_abs) {
            max_abs = abs_val;
        }
        ptr++;
    }

    // Divide each element by max_abs in-place
    if (max_abs > 0.0) {
        double* write_ptr = signal;
        for (int i = 0; i < n; ++i) {
            *write_ptr = *write_ptr / max_abs;
            write_ptr++;
        }
    }
}

// 3. Count adjacent zero crossings using pointers
int countZeroCrossings(const double* signal, int n) {
    int count = 0;
    const double* ptr = signal;

    for (int i = 0; i < n - 1; ++i) {
        // Zero crossing happens when adjacent elements have opposite signs
        if ((*ptr) * (*(ptr + 1)) < 0) {
            count++;
        }
        ptr++;
    }

    return count;
}

// 4. Apply gain factor in-place using pointers
void applyGain(double* signal, int n, double gainFactor) {
    double* ptr = signal;

    for (int i = 0; i < n; ++i) {
        *ptr = (*ptr) * gainFactor;
        ptr++;
    }
}

// Helper function to print array without indexing
void printArray(const double* signal, int n) {
    const double* ptr = signal;

    cout.setf(ios::fixed, ios::floatfield);
    cout.precision(2);

    cout << "[ ";
    for (int i = 0; i < n; ++i) {
        cout << *ptr << " ";
        ptr++;
    }
    cout << "]" << endl;
}

int main() {
    double signal[] = {0.5, -1.2, 0.8, -0.3, 1.0, -0.9, 0.1};
    int n = sizeof(signal) / sizeof(signal[0]);

    cout << "Initial Signal : ";
    printArray(signal, n);

    // RMS Calculation
    double rms = computeRMS(signal, n);
    cout << "RMS Value      : ";
    cout.precision(4);
    cout << rms << endl;

    // Zero Crossings Count
    int zeroCrossings = countZeroCrossings(signal, n);
    cout << "Zero Crossings : " << zeroCrossings << endl;

    // Normalisation
    normalise(signal, n);
    cout << "After Normalise: ";
    printArray(signal, n);

    // Apply Gain
    applyGain(signal, n, 2.5);
    cout << "After Gain(2.5): ";
    printArray(signal, n);

    return 0;
}