//15651 N�� M(3) Silver 3
#include <iostream>

using namespace std;

int N, M;
int arr[9];

void getComb(int ctr){
    if (ctr == M){
        for(int i = 0; i < M; i++){
            cout << arr[i] << " ";
        }
        cout << "\n";
        return;
    }
    for(int i = 1; i <= N; i ++){
            arr[ctr] = i;
            getComb(ctr+1);
        }
}

int main(){
    cin >> N >> M;
    getComb(0);
    return (0);
}