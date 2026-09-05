#include <iostream>
#include <memory>
#include <string>

using namespace std;

// AudioClip class definition
class AudioClip {
private:
    string name;
    double duration;

public:
    // Constructor
    AudioClip(string n, double d) : name(n), duration(d) {
        cout << "[AudioClip Loaded]" << endl;
    }

    // Destructor
    ~AudioClip() {
        cout << "[AudioClip Destroyed]" << endl;
    }

    // Getter for clip name
    string getName() const {
        return name;
    }
};

int main() {
    // 1. Create an AudioClip using make_shared("explosion", 3.5)
    auto audio = make_shared<AudioClip>("explosion", 3.5);

    // 2. Assign a weak_ptr from the shared_ptr
    weak_ptr<AudioClip> observer = audio;

    // 3. Use lock() on the weak_ptr to access the clip — print its name if still alive
    if (auto clip = observer.lock()) {
        cout << "Clip alive: " << clip->getName() << endl;
    }

    // 4. Reset the shared_ptr (simulating unload)
    audio.reset(); // unload

    // 5. Try lock() again — use expired() to check — print "Clip already unloaded" if gone
    if (observer.expired()) {
        cout << "Clip already unloaded." << endl;
    }

    return 0;
}