//17829 222-Ç®¸µ(Silver 2)
#include <iostream>
using namespace std;

int N;
int board[1024][1024];

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> N;
    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            cin >> board[i][j];
        }
    }
    

    return 0;
}