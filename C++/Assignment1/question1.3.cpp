#include <iostream>

using namespace std;

void read_grid(double grid[3][3]) {
    for (int r = 0; r < 3; ++r) {
        for (int c = 0; c < 3; ++c) {
            cin >> grid[r][c];
        }
    }
}

void print_grid(const double grid[3][3]) {
    cout << "\n        Room1   Room2   Room3" << endl;
    
    // Set 1 decimal place using standard iostream methods
    cout.setf(ios::fixed, ios::floatfield);
    cout.precision(1);

    for (int r = 0; r < 3; ++r) {
        cout << "Floor " << (r + 1) << " : ";
        for (int c = 0; c < 3; ++c) {
            cout << " " << grid[r][c] << "  ";
        }
        cout << endl;
    }
    cout << endl;
}

void analyze_grid(const double grid[3][3]) {
    double max_temp = grid[0][0];
    int max_floor = 1, max_room = 1;

    double highest_avg = -1.0;
    int hottest_floor_idx = 1;

    int warning_count = 0;

    for (int r = 0; r < 3; ++r) {
        double floor_sum = 0.0;

        for (int c = 0; c < 3; ++c) {
            double temp = grid[r][c];

            if (temp > max_temp) {
                max_temp = temp;
                max_floor = r + 1;
                max_room = c + 1;
            }

            if (temp >= 30.0) {
                warning_count++;
            }

            floor_sum += temp;
        }

        double floor_avg = floor_sum / 3.0;
        if (floor_avg > highest_avg) {
            highest_avg = floor_avg;
            hottest_floor_idx = r + 1;
        }
    }

    // Configure fixed format
    cout.setf(ios::fixed, ios::floatfield);

    // Print Hottest Room (1 decimal place)
    cout.precision(1);
    cout << "Hottest Room  : Floor " << max_floor << ", Room " << max_room 
         << " -> " << max_temp << " deg C" << endl;

    // Print Hottest Floor Average (2 decimal places)
    cout.precision(2);
    cout << "Hottest Floor : Floor " << hottest_floor_idx 
         << " (avg " << highest_avg << " deg C) "<< endl;

    cout << "Rooms at WARNING or above : " << warning_count << endl;
}

int main() {
    double grid[3][3];

    cout << "Enter 9 temperature readings for 3 floors (3 rooms per floor):\n";

    read_grid(grid);
    print_grid(grid);
    analyze_grid(grid);

    return 0;
}