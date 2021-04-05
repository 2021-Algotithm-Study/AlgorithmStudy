//15665 N°ú M(7) (Silver 3)
#include <iostream>
#include <algorithm>

using namespace std;
int N, M;
int n[10];
int arr[10];

void getComb(int ctr){
    if (ctr == M){
        for(int i = 0; i < M; i++)
            cout << arr[i] << " ";
        cout << "\n";
        return;
    }
    for(int i = 0; i < N; i++){
        if (n[i] >= arr[ctr-1]){
            arr[ctr] = n[i];
            getComb(ctr + 1);
        }
    }
}

int main(){
    cin >> N >> M;
    for(int i = 0; i < N; i++)
        cin >> n[i];
    sort(n, n + N);

    getComb(0);
}