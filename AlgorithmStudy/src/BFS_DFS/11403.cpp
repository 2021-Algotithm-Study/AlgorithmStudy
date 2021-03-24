// 11403 경로찾기 
#include <iostream>

using namespace std;

int n;
int board[101][101];
bool check[101][101];
int dx[] = {0, -1, 0, 1};
int dy[] = {-1, 0, 1, 0};


void dfs(int x, int y){
    for(int i = 0; i < n; i++){
        if (board[y][i] && !check[x][i]){
            board[x][i] = 1;
            check[x][i] = true;
            dfs(y, i);
        }
    }
}

int main(void){
    cin >> n;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> board[i][j];
        }
    }

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++)
            if(board[i][j])
                dfs(i, j);
    }

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cout << board[i][j] << " ";
        }
        cout << "\n";
    }

    return (0);
}