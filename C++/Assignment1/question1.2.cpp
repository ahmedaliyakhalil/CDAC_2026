#include <iostream>

using namespace std;

// Step 1: Function to take user inputs into the buffer array
void read_inputs(double readings[], int N)
{
    for (int i = 0; i < N; ++i)
    {
        cin >> readings[i];
    }
}

// Step 2: Function to print valid readings and count skipped errors
void print_valid_readings(const double readings[], int N, int &skipped_errors)
{
    cout << "\nReadings entered : " << N << endl;
    cout << "Valid readings   : ";

    for (int i = 0; i < N; ++i)
    {
        // Skip negative sensor error readings using continue
        if (readings[i] < 0.0)
        {
            skipped_errors++;
            continue;
        }
        cout << readings[i] << "  ";
    }
    cout << endl;
    cout << "Skipped (errors) : " << skipped_errors << endl << endl;
}

// Step 3: Function to process statistics and categories in a single pass
void process_sensor_data(const double readings[], int N,
                         int &first_critical_idx, double &min_val,
                         double &max_val, double &average,
                         int &normal, int &warning, int &critical, int &shutdown)
{
    int valid_count = 0;
    double sum = 0.0;
    bool is_first_valid = true;

    for (int i = 0; i < N; ++i)
    {
        double temp = readings[i];

        if (temp < 0.0)
            continue; // Skip errors

        // Scan for the first reading at or above 45°C
        if (temp >= 45.0 && first_critical_idx == -1)
        {
            first_critical_idx = i;
        }

        // Initialize and compute min & max
        if (is_first_valid)
        {
            min_val = temp;
            max_val = temp;
            is_first_valid = false;
        }
        else
        {
            if (temp < min_val)
                min_val = temp;
            if (temp > max_val)
                max_val = temp;
        }

        sum += temp;
        valid_count++;

        // Categorize readings
        if (temp >= 0.0 && temp < 30.0)
            normal++;
        else if (temp >= 30.0 && temp < 45.0)
            warning++;
        else if (temp >= 45.0 && temp <= 50.0)
            critical++;
        else if (temp > 50.0)
            shutdown++;
    }

    // Compute average
    if (valid_count > 0)
    {
        average = sum / valid_count;
    }
}

// Step 4: Function to display the summary report
void print_summary_report(const double readings[], int first_critical_idx,
                          double min_val, double max_val, double average,
                          int normal, int warning, int critical, int shutdown)
{
    if (first_critical_idx != -1)
    {
        cout << "First CRITICAL   : Index " << first_critical_idx
             << " -> " << readings[first_critical_idx] << "C" << endl
             << endl;
    }

    cout << "Min : " << min_val << "C   Max : " << max_val
         << "C   Avg : " << average << "C" << endl
         << endl;

    cout << "Normal:" << normal << "   Warning:" << warning
         << "   Critical:" << critical << "   Shutdown:" << shutdown << endl;
}

int main()
{
    int N;
    cout << "Enter number of readings (1 to 100): ";
    cin >> N;

    double readings[100];

    // Execution Step 1: Input
    read_inputs(readings, N);

    // Execution Step 2: Print valid entries & skip errors
    int skipped_errors = 0;
    print_valid_readings(readings, N, skipped_errors);

    // Execution Step 3: Process metrics in one pass
    int first_critical_idx = -1;
    double min_val = 0.0, max_val = 0.0, average = 0.0;
    int normal = 0, warning = 0, critical = 0, shutdown = 0;

    process_sensor_data(readings, N, first_critical_idx, min_val, max_val,
                        average, normal, warning, critical, shutdown);

    // Execution Step 4: Output summary report
    print_summary_report(readings, first_critical_idx, min_val, max_val,
                         average, normal, warning, critical, shutdown);

    return 0;
}