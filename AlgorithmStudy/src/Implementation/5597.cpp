/*Bronze2, 과제 안 내신 분*/

#include <iostream>
using namespace std;

bool submit[33] = { false, };

int main() {
    int temp;
    for(int i = 0; i < 28; i++){
        cin >> temp;
        submit[temp] = true;
    }
    for(int i = 1; i <= 30; i++){
        if(!submit[i])  cout << i << "\n";
    }
    return 0;
}