//1913 ´ÞÆØÀÌ (Silver 5)

#include <iostream>
using namespace std;

int board[1001][1001] = {0, };
int dy[] = {0, 1, 0, -1};
int dx[] = {1, 0, -1, 0};
int main(){
    int N, M;     cin >> N >> M;
    pair<int, int> ans;
    int x = 0, y = 0;
    int num = N*N;
    int dir = 0;

    board[x][y] = num--;
    while (num > 0){
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        //is possible place
        if(nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] == 0){
            board[nx][ny] = num;
            x = nx; y = ny;
            if(num == M){
                ans = make_pair(x, y);
            }
            
        num--;
        } else{
            dir = (dir+1) % 4;
        }
    }

    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            cout << board[i][j] << " ";
        }
        cout << "\n";
    }

    cout << ans.first+1 << " " << ans.second+1;
    return 0;
}