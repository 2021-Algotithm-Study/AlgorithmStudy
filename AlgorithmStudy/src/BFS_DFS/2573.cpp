//2573 빙산 (Gold 4)
//시간초과 났었는데 과정 도중에 전부 잠겨 버리는 케이스는 바로 0 출력하고 죽게 해주면 오케이임

#include <iostream>
#include <queue>

using namespace std;

int n, m;
int origin[301][301];
int board[301][301];
bool check[301][301];

int dx[] = {0, -1, 0, 1};
int dy[] = {-1, 0, 1, 0};

void print_module(){
    cout << "\n";
    for(int i = 0; i < n; i ++){
        for(int j = 0; j < m; j++){
            cout << board[i][j] << " ";
        }
        cout << "\n";
    }
    cout << "\n";
}

//빙산을 1년치만큼 녹인다
void ice_melting(){
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if (board[i][j]){
                int water = 0;
                for(int k = 0; k < 4 ; k++){
                    if (origin[i + dx[k]][j + dy[k]] == 0)
                        water++;
                }
                board[i][j] -= water;
                if (board[i][j] < 0)    board[i][j] = 0;
            }
        }
    }
    
    //print_module();
}

//bfs check[] initializer
void init_check(){
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            check[i][j] = false;
        }
    }
}

//빙산 갯수를 재는 데에 이용한다
void bfs(pair<int, int> x){
    queue<pair<int, int>> q;
    q.push(x);
    check[x.first][x.second] = true;
    while (!q.empty()){
        x = q.front();
        q.pop();
        for(int i = 0; i < 4; i++){
            int nx = x.first + dx[i];
            int ny = x.second + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m){
                if (board[nx][ny] && !check[nx][ny]){
                    check[nx][ny] = true;
                    q.push(make_pair(nx, ny));
                }
            }
        }
    }
    
}

void init_c(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
}

int main(){
    init_c();
    cin >> n >> m;
    for(int i = 0; i < n; i++)
        for(int j = 0; j < m; j++)
            cin >> origin[i][j];
    
    int year = 0;
    while (1){

        bool flag = true;
        //origin to board
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j++){
                board[i][j] = origin[i][j];
                if (origin[i][j])
                    flag = false;
            }
        }
        if(flag){
            cout << 0;
            return 0;
        }
        
        year++;
        ice_melting();
        init_check();
        int total = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (board[i][j] && !check[i][j]){
                    total++;
                    bfs(make_pair(i, j));
                }
            }
        }
        //end condition
        if (total >= 2)
            break;

        //board to origin
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j++){
                origin[i][j] = board[i][j];
            }
        }
    }
    
    cout << year;
    return (0);
}