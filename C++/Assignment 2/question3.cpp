
#include <iostream>
#include <cstdlib>

using namespace std;

class Entity {
private:
    string name;
    int health;
    int level;
    string type;

public:
    // Method chaining setters
    Entity& setName(const string& name) {
        this->name = name;
        return *this;
    }

    Entity& setHealth(int health) {
        this->health = health;
        return *this;
    }

    Entity& setLevel(int level) {
        this->level = level;
        return *this;
    }

    Entity& setType(const string& type) {
        this->type = type;
        return *this;
    }

    // Const getters
    string getName() const {
        return this->name;
    }

    int getHealth() const {
        return this->health;
    }

    int getLevel() const {
        return this->level;
    }

    string getType() const {
        return this->type;
    }

    void displayInfo() const {
        cout << "Name: " << this->name << "\n"
             << "Health: " << this->health << "\n"
             << "Level: " << this->level << "\n"
             << "Type: " << this->type << "\n\n\n";
    }
};

namespace Physics {
    // Clamp a velocity
    double clamp(double val, double min, double max) {
        if (max < min) return 0;
        cout << "Physics Clamp called" << endl;
        return (val < min) ? min : ((val > max) ? max : val);
    }

    double lerp(double a, double b, double t) {
        cout << "Physics Lerp called" << endl;
        return a + t * (b - a);
    }
}

namespace GameMath {
    int clamp(int val, int min, int max) {
        if (max < min) return 0;
        cout << "GameMath Clamp called" << endl;
        return (val < min) ? min : ((val > max) ? max : val);
    }

    double lerp(double a, double b, double t) {
        cout << "Gamemath Lerp called" << endl;
        return a + t * (b - a);
    }
}

// Helper function to track terrain tile distribution
void populateCount(int& cnt1, int& cnt2, int& cnt3, int& cnt4, int& cnt5, int& gridval) {
    switch (gridval) {
        case 0:  cnt1++; break;
        case 1:  cnt2++; break;
        case 2:  cnt3++; break;
        case 3:  cnt4++; break;
        default: cnt5++; break;
    }
}

int level = 1; // Global level

namespace Engine {
    namespace Audio {
        void playSound(string name) {
            cout << "Playing: " << name << endl;
        }
    }
}

int main() {

    // -------------------------------- PART A --------------------------------
    Entity player, enemy, item;
    
    // Method chaining calls
    player.setName("Aragorn").setHealth(100).setLevel(10).setType("Player");
    enemy.setName("Orc").setHealth(60).setLevel(5).setType("Enemy");
    item.setName("HealthPotion").setHealth(0).setLevel(1).setType("Item");

    /*
     * Chaining mechanism explanation:
     * Calling player.setName("Aragorn").setHealth(100) returns *this (a reference to current object).
     * An alias (reference) Entity& is returned, passing the exact instance down the chain.
     * Behind the scenes, member functions implicitly receive the object instance pointer:
     * setName(Entity* const this, const string& name)
     */

    player.displayInfo();
    enemy.displayInfo();
    item.displayInfo();

    // -------------------------------- PART B --------------------------------
    cout << "Physics Clamp: " << Physics::clamp(30, 50, 100) << endl;
    cout << "Physics Lerp: " << Physics::lerp(3, 7, 64) << endl << endl;

    cout << "GameMath Clamp: " << GameMath::clamp(-2, 50, 100) << endl;
    cout << "GameMath Lerp: " << GameMath::lerp(3, 66, 64) << endl;

    {
        using namespace Physics;
        cout << clamp(10, 20, 3000) << endl;
    }

    {
        using namespace GameMath;
        cout << clamp(8000, 20, 590) << endl;
    }

    // -------------------------------- PART C --------------------------------
    const int R = 3;
    const int C = 4;
    
    // Allocate dynamic 2D array matrix
    int** grid = new int*[R];

    for (int i = 0; i < R; i++) {
        grid[i] = new int[C];
        for (int j = 0; j < C; j++) {
            grid[i][j] = rand() % 5;
        }
    }

    cout << "===== GAME MAP " << R << " * " << C << " =====\n";
    int cnt1 = 0, cnt2 = 0, cnt3 = 0, cnt4 = 0, cnt5 = 0;

    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            populateCount(cnt1, cnt2, cnt3, cnt4, cnt5, grid[i][j]);
            cout << grid[i][j] << " ";
        }
        cout << endl;
    }

    cout << "Legend: 0=Grass 1=Water 2=Mountain 3=Forest 4=Dungeon\n\n";
    cout << "Tile Count:\n";
    cout << "Grass : " << cnt1 << "\n";
    cout << "Water : " << cnt2 << "\n";
    cout << "Mountain : " << cnt3 << "\n";
    cout << "Forest : " << cnt4 << "\n";
    cout << "Dungeon : " << cnt5 << "\n";

    // Dynamic memory cleanup
    for (int i = 0; i < R; i++) {
        delete[] grid[i];
    }
    delete[] grid;

    // ---------------------------- BONUS QUESTION ----------------------------
    int level = 10; // Local variable shadowing global level
    cout << "Printing global value: " << ::level << endl;
    cout << "Printing local value: " << level << endl;
    cout << "Calling Nested Namespace: \n" << endl;

    Engine::Audio::playSound("sword_clash");

    return 0;
}



/*------------------------------------OUTPUT----------------------------
PS D:\CDAC\c++\assignment2> D:\CDAC\c++\assignment2\question3.exe
Name: Aragorn
Health: 100
Level: 10
Type: Player


Name: Orc
Health: 60
Level: 5
Type: Enemy


Name: HealthPotion
Health: 0
Level: 1
Type: Item


Physics Clamp called
Physics Clamp: 50
Physics Lerp called
Physics Lerp: 259

GameMath Clamp called
GameMath Clamp: 50
Gamemath Lerp called
GameMath Lerp: 4035
Physics Clamp called
20
GameMath Clamp called
590
===== GAME MAP 3 * 4 =====
1 2 4 0 
4 4 3 3 
2 4 0 0 
Legend: 0=Grass 1=Water 2=Mountain 3=Forest 4=Dungeon

Tile Count:
Grass : 3
Water : 1
Mountain : 2
Forest : 2
Dungeon : 4
Printing global value: 1
Printing local value: 10
Calling Nested Namespace: 

Playing: sword_clash
PS D:\CDAC\c++\assignment2> 

*/