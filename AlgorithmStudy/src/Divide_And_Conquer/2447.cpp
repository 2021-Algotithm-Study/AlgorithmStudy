//2447 º° Âï±â - 10(Silver 1)
#include <iostream>

using namespace std;

void print(int x, int y, int n){
    if((x / n%3) == 1 && (y / n%3) == 1)    cout << " ";    //Áß°£ ºóÄ­
    else if(n / 3 == 0)                     cout << "*";
    else                                    print(x, y, n/3);
}

int main(){
    ios::sync_with_stdio(false);
    cout.tie(0);
    int N; cin >> N;
    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            print(i, j, N);
        }
        cout << "\n";
    }
}