#include <iostream>
#include <cstdlib> // For rand()
#include <string>  // For std::stod and std::stoi

using namespace std;

void print_usage(const char* program_name) {
    cout << "Usage   : " << program_name << " <warn_threshold> <crit_threshold> <num_readings>" << endl;
}

bool validate_args(int argc, char* argv[], double &warn, double &crit, int &num_readings) {
    if (argc < 4) {
        print_usage(argv[0]);
        cout << "Error   : Missing arguments." << endl;
        return false;
    }

    try {
        warn = stod(argv[1]);
        crit = stod(argv[2]);
        num_readings = stoi(argv[3]);
    } catch (...) {
        cout << "Error   : Missing arguments." << endl;
        return false;
    }

    if (warn >= crit) {
        cout << "Error   : <warn_threshold> must be strictly less than <crit_threshold>." << endl;
        return false;
    }

    if (num_readings < 1 || num_readings > 500) {
        cout << "Error   : <num_readings> must be between 1 and 500." << endl;
        return false;
    }

    return true;
}

void process_readings(double warn, double crit, int num_readings) {
    int normal = 0, warning = 0, critical = 0, shutdown = 0;

    for (int i = 0; i < num_readings; ++i) {
        double temp = rand() % 70;

        if (temp < warn) {
            normal++;
        } else if (temp >= warn && temp < crit) {
            warning++;
        } else if (temp >= crit && temp <= 50.0) {
            critical++;
        } else if (temp > 50.0) {
            shutdown++;
        }
    }

    // Config line format matching the assignment specification
    cout << "Config  : Warn=" << (int)warn << "deg C   Critical=" << (int)crit 
         << " deg C   Readings=" << num_readings << endl;
         
    // Results summary line format
    cout << "Results : Normal:" << normal 
         << "   Warning:" << warning 
         << "   Critical:" << critical 
         << "   Shutdown:" << shutdown << endl;
}

int main(int argc, char* argv[]) {
    double warn_threshold = 0.0;
    double crit_threshold = 0.0;
    int num_readings = 0;

    if (!validate_args(argc, argv, warn_threshold, crit_threshold, num_readings)) {
        return 1;
    }

    process_readings(warn_threshold, crit_threshold, num_readings);

    return 0;
}