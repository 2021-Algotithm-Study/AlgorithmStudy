//2636 치즈 (Gold 5)
#include <iostream>
#include <queue>

using namespace std;

int n, m;
int origin[101][101];
int board[101][101];
bool check[101][101] = {false};

int dx[] = {0, -1, 0, 1};
int dy[] = {-1, 0, 1, 0};

void print_module(){
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cout << board[i][j] << " ";
        }
        cout << "\n";
    }
}

void init_check(){
    for(int i =0; i < n; i++){
        for(int j = 0; j < m; j++){
            check[i][j] = false;
        }
    }
}

int bfs_melting(){
    int erase_cheese = 0;;
    queue<pair<int, int>> q;
    q.push(make_pair(0, 0));
    check[0][0] = true;
    
    while (!q.empty()){
        pair<int, int> x = q.front();
        q.pop();
        for(int i = 0; i < 4; i++){
            int nx = x.first + dx[i];
            int ny = x.second + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m){
                //1일 경우는 지우고
                //0일 경우는 q.push
                if (origin[nx][ny] == 1 && !check[nx][ny]){
                    board[nx][ny] = 0;
                    erase_cheese++;
                    check[nx][ny] = true;
                }
                else if(origin[nx][ny] == 0 && !check[nx][ny]){
                    check[nx][ny] = true;
                    q.push(make_pair(nx, ny));
                }
            }
        }
    }
    return (erase_cheese);
}

int count_cheese(){
    int ctr = 0;
    for(int i = 0; i < n; i++)
        for(int j = 0; j < m; j++)
            if(board[i][j] == 1)
                ctr++;
    return (ctr);
}

void init_c(){
    std::ios_base::sync_with_stdio;
    cin.tie(NULL);
    cout.tie(NULL);
}

int main(){
    init_c();
    bool flag = true;
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> origin[i][j];
            if (origin[i][j])
                flag = false;
        }
    }
    if(flag){
        cout << 0;
        return 0;
    }
    int pre_cheese;
    int cur_cheese;
    int hours = 0;
    while (1){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                board[i][j] = origin[i][j];
            }
        }
        pre_cheese = count_cheese();
        
        hours++;
        init_check();
        cur_cheese = pre_cheese - bfs_melting();
        //cout << "\n";
        //print_module();
        //cout << "pre: " << pre_cheese << "\tcur: " << cur_cheese << "\n\n";
        //cout << "\n";
        if(!cur_cheese)
            break;
            
        for(int i = 0; i < n; i++){
            for(int j = 0; j <m; j++){
                origin[i][j] = board[i][j];
            }
        }
        
    }
    cout << hours << "\n";
    cout << pre_cheese;
}