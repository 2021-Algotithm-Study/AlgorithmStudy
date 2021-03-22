#include <iostream>
#include <queue>

using namespace std;

int m, n, h;
int board[101][101][101] = {0};
int visit[101][101][101] = {0};
int dx[] = {0, -1, 0, 1, 0, 0};
int dy[] = {-1, 0, 1, 0, 0, 0};
int dz[] = {0, 0, 0, 0, 1, -1};

struct tomato {
    int x, y, z;
};

void bfs(int x, int y, int z){
    queue<tomato> q;
    tomato temp;
    temp.x = x;
    temp.y = y;
    temp.z = z;
    q.push(temp);
    check[x][y][z] = 1;
    while (!q.empty()){
        for(int i = 0; i < 6; i++){
            int nx;
            int ny;
            int nz;
        }
    }
}

int main(void){
    
    cin >> m >> n >> h;
    for(int i = 0; i < h; i++){
        for(int j = 0; j < n; j++){
            for(int k = 0; k < m; k++){
                cin >> board[i][j][k];
            }            
        }
    }
    
    for(int i = 0; i < h; i++){
        for(int j = 0; j < n; j++){
            for(int k = 0; k < m; k++){
                if(board[i][j][k] == 1 && !check[i][j][k]){
                    bfs(i, j, k);
                }
            }
        }
    }
    return (0);
}