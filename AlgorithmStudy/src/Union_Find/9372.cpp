//9372 상근이의 여행 
//union find 쓰려고 했지만 걍... n-1 출력하면 되는 문제임

#include <iostream>

using namespace std;


int t, n, m;

int main(){
    cin >> t;
    while (t--){
        cin >> n >> m;

        for(int i = 0; i < m; i++){
            int temp1, temp2; 
            cin >> temp1 >> temp2;
        }
        cout << n-1 << "\n";

    }
    return (0);
}