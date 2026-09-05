#include <iostream>
#include <memory>
#include <string>

using namespace std;

// Shader class definition
class Shader {
private:
    string name;
    string type; // "vertex" or "fragment"

public:
    // Constructor
    Shader(string n, string t) : name(n), type(t) {
        cout << "[Shader Compiled]" << endl;
    }

    // Destructor
    ~Shader() {
        cout << "[Shader Destroyed]" << endl;
    }
};

int main() {
    // 1. Create a Shader using make_shared("main_vert", "vertex")
    auto shader = make_shared<Shader>("main_vert", "vertex");
    cout << "Ref count: " << shader.use_count() << endl; // 1

    {
        // 2 & 3. Assign to second variable (simulating renderer sharing it)
        auto rendererRef = shader;
        cout << "Ref count: " << shader.use_count() << endl; // 2

        {
            // Assign to third variable (simulating editor sharing it)
            auto editorRef = shader;
            cout << "Ref count: " << shader.use_count() << endl; // 3
        }

        // 4. editorRef goes out of scope — count drops to 2
        cout << "Ref count: " << shader.use_count() << endl; // 2
    }

    // rendererRef goes out of scope — count drops back to 1
    cout << "Ref count: " << shader.use_count() << endl; // 1

    return 0; // shader goes out of scope here, triggering destructor
}