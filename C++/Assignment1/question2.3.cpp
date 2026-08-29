#include <iostream>

using namespace std;

int main() {
    // Hardware Registers simulated in memory
    int statusReg = 0b10110001;  // Status Register
    int controlReg = 0b00000000; // Control Register
    const int romConfig = 0xFF;  // ROM Config

    // 1. Pointer to Status Register: Read-only access to the data
    const int* pStatus = &statusReg;

    // 2. Pointer to Control Register: Fixed address pointer (writable data)
    int* const pControl = &controlReg;

    // 3. Pointer to ROM Config: Read-only data at a fixed address
    const int* const pROM = &romConfig;

    // --- DEMONSTRATION OF VALID OPERATIONS ---
    cout << "--- Initial Register Values ---" << endl;
    cout << "Status Register  : " << *pStatus << endl;
    cout << "Control Register : " << *pControl << endl;
    cout << "ROM Config       : " << *pROM << endl << endl;

    // Writing to Control Register via pointer (ALLOWED)
    *pControl = 0b11110000;
    cout << "Updated Control Register : " << *pControl << endl << endl;

    /*
     * --- ENFORCING HARDWARE ACCESS RULES AT COMPLIANCE LEVEL ---
     * 
     * Uncommenting any of the lines below will cause a COMPILE ERROR:
     */

    // RULE 1 VIOLATION: Trying to write to a read-only status register
    // *pStatus = 0b00000000; 
    // Error: assignment of read-only location '* pStatus'

    // RULE 2 VIOLATION: Trying to reassign the control register pointer to another address
    // pControl = &statusReg; 
    // Error: assignment of read-only variable 'pControl'

    // RULE 3 VIOLATION: Trying to modify ROM data or reassign ROM pointer address
    // *pROM = 0x00; 
    // Error: assignment of read-only location '* pROM'
    // pROM = &controlReg; 
    // Error: assignment of read-only variable 'pROM'

    return 0;
}