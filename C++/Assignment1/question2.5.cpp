#include <iostream>
#include <cmath>

using namespace std;

// Inline math helper functions for flight control loops

inline double distance2D(double x1, double y1, double x2, double y2) {
    return sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
}

inline double toRadians(double degrees) {
    const double PI = 3.14159265358979323846;
    return degrees * (PI / 180.0);
}

inline double clamp(double value, double minVal, double maxVal) {
    if (value < minVal) return minVal;
    if (value > maxVal) return maxVal;
    return value;
}

inline bool isInSafeZone(double x, double y, double cx, double cy, double radius) {
    double dist = distance2D(x, y, cx, cy);
    return dist <= radius;
}

int main() {
    // Home position coordinates
    double homeX = 0.0;
    double homeY = 0.0;
    double safeRadius = 50.0;

    // Test waypoints (x, y)
    double waypoints[3][2] = {
        {15.0, 20.0},  // Waypoint 1 (Inside)
        {30.0, 40.0},  // Waypoint 2 (On boundary)
        {60.0, 10.0}   // Waypoint 3 (Outside)
    };

    cout << "=== Drone Flight Controller - Safe Zone Check ===" << endl;
    cout << "Home Base   : (" << homeX << ", " << homeY << ")" << endl;
    cout << "Safe Radius : " << safeRadius << " units" << endl << endl;

    cout.setf(ios::fixed, ios::floatfield);
    cout.precision(2);

    for (int i = 0; i < 3; ++i) {
        double wpX = waypoints[i][0];
        double wpY = waypoints[i][1];

        // Compute distance from home base
        double dist = distance2D(homeX, homeY, wpX, wpY);

        // Check safe zone status
        bool safe = isInSafeZone(wpX, wpY, homeX, homeY, safeRadius);

        cout << "Waypoint " << (i + 1) << " (" << wpX << ", " << wpY << "):" << endl;
        cout << "  Distance from Home : " << dist << " units" << endl;
        cout << "  Status             : " << (safe ? "INSIDE SAFE ZONE" : "OUTSIDE SAFE ZONE") << endl << endl;
    }

    return 0;
}