//17829 222-Ç®¸µ(Silver 2)
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N;
int board[1024][1024];

void print(int size){
    for(int i = 0; i < size; i++){
        for(int j = 0; j < size; j++){
            cout << board[i][j] << " ";
        }
        cout << "\n";
    }
    cout << "\n";
}

int pulling(int x, int y){
    /*
    vector<int> temp;
    temp.push_back(board[x][y]);
    temp.push_back(board[x+1][y]);
    temp.push_back(board[y+1][x]);
    temp.push_back(board[x+1][y+1]);

    sort(temp.begin(), temp.end());
    return temp[2];
    */
   vector <int> a;

    a.push_back(board[x][y]);
    a.push_back(board[x+1][y]);
    a.push_back(board[x][y+1]);
    a.push_back(board[x+1][y+1]);

    sort(a.begin(), a.end());
    return a[2];

}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> N;
    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            cin >> board[i][j];
        }
    }
    //cout << "\n";
    while(N > 1){
        for(int i = 0; i < N; i+=2){
            for(int j = 0; j < N; j+=2){
                board[i/2][j/2] = pulling(i, j);
            }
        }
        N/=2;
        //print(N);
    }

    cout << board[0][0];
    return 0;
}