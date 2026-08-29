#include <iostream>

using namespace std;

// Struct layout with interspersed data types
struct Layout1 {
    char c1;
    int i;
    char c2;
};

// Struct layout with grouped data types
struct Layout2 {
    int i;
    char c1;
    char c2;
};

int main() {
    cout << "=== Bonus: Struct Padding Demo ===" << endl;
    cout << "sizeof(Layout1) : " << sizeof(Layout1) << " bytes" << endl;
    cout << "sizeof(Layout2) : " << sizeof(Layout2) << " bytes" << endl;

    /*
     * =========================================================================
     * STRUCT PADDING ANSWERS & EXPLANATION
     * =========================================================================
     * 
     * 1. Why the sizes differ:
     *    - Layout1 arranges members as (char, int, char). Because an 'int' must 
     *      align on a 4-byte boundary, the compiler inserts 3 padding bytes after 
     *      c1 and 3 padding bytes after c2, giving a total size of 12 bytes.
     *    - Layout2 arranges members as (int, char, char). The two 'char' variables 
     *      pack together in 2 consecutive bytes, requiring only 2 padding bytes at 
     *      the end, giving a total size of 8 bytes.
     * 
     * 2. What padding is and why the compiler adds it:
     *    - Padding refers to empty/unused filler bytes automatically inserted by 
     *      the compiler between structure members.
     *    - Modern 32-bit and 64-bit CPUs read memory much faster when data types 
     *      are aligned to their natural memory boundary offsets (e.g., 4-byte 
     *      integers at addresses divisible by 4).
     * 
     * 3. Why member order matters for network packets and hardware register maps:
     *    - Network protocol headers and hardware memory-mapped registers expect 
     *      exact binary byte offsets without extra spaces.
     *    - If member variables are ordered poorly, compiler-inserted padding shifts 
     *      the byte positions of variables, causing data corruption or sending 
     *      misaligned commands to hardware.
     */

    return 0;
}