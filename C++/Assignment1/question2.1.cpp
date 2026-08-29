#include <iostream>

using namespace std;

// V1: Buggy Version - Call by Value (Modifies local copies only)
void resetSensorPairV1(int reading1, int reading2) {
    int temp = reading1;
    reading1 = reading2;
    reading2 = temp;
}

// V2: Fix 1 - Call by Reference (Modifies original variables directly)
void resetSensorPairV2(int &reading1, int &reading2) {
    int temp = reading1;
    reading1 = reading2;
    reading2 = temp;
}

// V3: Fix 2 - Call by Pointer (Modifies values via memory addresses)
void resetSensorPairV3(int *reading1, int *reading2) {
    int temp = *reading1;
    *reading1 = *reading2;
    *reading2 = temp;
}

int main() {
    int A = 55;
    int B = 12;

    /*
     * ROOT CAUSE EXPLANATION FOR V1 FAILURE:
     * resetSensorPairV1 uses Call by Value, which creates temporary local 
     * copies of 'A' and 'B' inside the function's execution stack frame. 
     * The swap operation modifies only these local copies while leaving 
     * the original memory locations of 'A' and 'B' in main() completely 
     * untouched.
     */

    // --- V1 Execution ---
    cout << "--- V1: Call by Value ---" << endl;
    cout << "Before : A=" << A << "  B=" << B << endl;
    resetSensorPairV1(A, B);
    cout << "After  : A=" << A << "  B=" << B << "    <- values unchanged" << endl << endl;

    // --- V2 Execution ---
    cout << "--- V2: Call by Reference ---" << endl;
    cout << "Before : A=" << A << "  B=" << B << endl;
    resetSensorPairV2(A, B);
    cout << "After  : A=" << A << "  B=" << B << "    <- values swapped" << endl << endl;

    // --- V3 Execution ---
    cout << "--- V3: Call by Pointer ---" << endl;
    cout << "Before : A=" << A << "  B=" << B << endl;
    resetSensorPairV3(&A, &B);
    cout << "After  : A=" << A << "  B=" << B << "    <- values swapped back" << endl;

    return 0;
}