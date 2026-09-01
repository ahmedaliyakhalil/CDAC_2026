#include <iostream>
#include <string>

using namespace std;

class Patient {
private:
    int patientId;
    string name;
    int age;
    string ward;
    const string bloodGroup; // Const member variable initialized via Initializer List

public:
    // 1. Full Admission Constructor (ID, Name, Age, Ward, BloodGroup)
    Patient(int id, string n, int a, string w, string bg) 
        : patientId(id), name(n), age(a), ward(w), bloodGroup(bg) {
        cout << "[Constructor] Full admission: " << name << endl;
    }

    // 2. Emergency Admission Constructor (ID, Name, Ward)
    Patient(int id, string n, string w) 
        : patientId(id), name(n), age(0), ward(w), bloodGroup("Unknown") {
        cout << "[Constructor] Emergency: " << name << endl;
    }

    // 3. Default Constructor
    Patient() 
        : patientId(0), name("Unknown"), age(0), ward("General"), bloodGroup("N/A") {
        cout << "[Constructor] Default patient registered.\n";
    }

    // Destructor
    ~Patient() {
        cout << "[Destructor] Patient " << name << " discharged.\n";
    }

    // Function to transfer ward
    void transferWard(const string& newWard) {
        ward = newWard;
    }

    // Function to display individual patient record
    void displayRecord() const {
        cout << "\nPatient Record:\n";
        cout << "  ID        : " << patientId << "\n";
        cout << "  Name      : " << name << "\n";
        cout << "  Age       : " << age << "\n";
        cout << "  Ward      : " << ward << "\n";
        cout << "  Blood Grp : " << bloodGroup << "\n";
    }
};

int main() {
    // Step 1: Create one patient of each type (3 stack objects) — observe constructor messages
    Patient p1(1001, "Meera Joshi", 34, "Cardiology", "B+");
    Patient p2(1002, "Raj Patel", "ICU");
    Patient p3;

    // Display sample patient record as per PDF layout
    p1.displayRecord();

    // Step 2: Create a dynamic array of 4 patients on the heap using new Patient[4] (default constructor)
    Patient* heapArray = new Patient[4];

    // Step 3: Use a loop to call displayRecord() on all 4 heap patients
    for (int i = 0; i < 4; i++) {
        heapArray[i].displayRecord();
    }

    // Step 4: Transfer one patient's ward using transferWard()
    p2.transferWard("General");

    // Step 5: delete[] the array and observe destructor messages
    delete[] heapArray;

    // Step 6: Let the 3 stack objects go out of scope and observe destructor messages
    return 0;
}


/*

S D:\CDAC\c++\assignment2> D:\CDAC\c++\assignment2\question2.exe
[Constructor] Full admission: Meera Joshi
[Constructor] Emergency: Raj Patel
[Constructor] Default patient registered.

Patient Record:
  ID        : 1001
  Name      : Meera Joshi
  Age       : 34
  Ward      : Cardiology
  Blood Grp : B+
[Constructor] Default patient registered.
[Constructor] Default patient registered.
[Constructor] Default patient registered.
[Constructor] Default patient registered.

Patient Record:
  ID        : 0
  Name      : Unknown
  Age       : 0
  Ward      : General
  Blood Grp : N/A

Patient Record:
  ID        : 0
  Name      : Unknown
  Age       : 0
  Ward      : General
  Blood Grp : N/A

Patient Record:
  ID        : 0
  Name      : Unknown
  Age       : 0
  Ward      : General
  Blood Grp : N/A

Patient Record:
  ID        : 0
  Name      : Unknown
  Age       : 0
  Ward      : General
  Blood Grp : N/A
[Destructor] Patient Unknown discharged.
[Destructor] Patient Unknown discharged.
[Destructor] Patient Unknown discharged.
[Destructor] Patient Unknown discharged.
[Destructor] Patient Unknown discharged.
[Destructor] Patient Raj Patel discharged.
[Destructor] Patient Meera Joshi discharged.
PS D:\CDAC\c++\assignment2> 

*/