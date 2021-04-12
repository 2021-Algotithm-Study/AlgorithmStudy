//9663 N-Queen (Gold 5)
#include <iostream>

using namespace std;

int board[16];
int N;

bool is_possible(int row, int col){
    for(int i = 0; i < row; i++){
        if((board[i] == col) || (board[i] + i == col + row) || (i - board[i] == row-col)){
            return false;
        }
    }
    return true;
}

int queen(int ctr){
    int answer = 0;
    if(ctr == N) 
        return 1;
    for(int i = 0; i < N; i++)
        if(is_possible(ctr, i)){
            board[ctr] = i;
            answer += queen(ctr+1);
        }
    return answer;
}

int main(){
    ios_base::sync_with_stdio;
    cin.tie(NULL); cout.tie(NULL);
    
    cin >> N;
    cout << queen(0);
    return 0;
}