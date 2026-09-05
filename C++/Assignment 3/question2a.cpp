#include <iostream>
#include <memory>
#include <string>
#include <utility>

using namespace std;

// Texture class definition
class Texture {
private:
    string name;
    int width;
    int height;

public:
    // Constructor
    Texture(string n, int w, int h) : name(n), width(w), height(h) {
        cout << "[Texture Loaded]" << endl;
    }

    // Destructor
    ~Texture() {
        cout << "[Texture Released]" << endl;
    }

    // Prints dimensions
    void display() const {
        cout << "Texture: " << name << " (" << width << "x" << height << ")" << endl;
    }
};

int main() {
    // 1. Create a Texture using make_unique("player_sprite", 512, 512)
    auto tex1 = make_unique<Texture>("player_sprite", 512, 512);

    // 2. Call display() through the unique_ptr
    tex1->display();

    // 3. Attempt to copy the unique_ptr — commented out with one-line explanation
    // unique_ptr<Texture> tex2 = tex1; // Error: std::unique_ptr copy constructor is deleted because it enforces unique ownership.

    // 4. Transfer ownership to a second unique_ptr using std::move()
    unique_ptr<Texture> tex2 = move(tex1);

    // Verify the first is now nullptr
    cout << "tex1 is null: " << (tex1 == nullptr ? "YES" : "NO") << endl;

    // 5. Let it go out of scope — observe destructor
    return 0;
}