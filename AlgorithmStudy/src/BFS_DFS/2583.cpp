#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

int board[101][101] = {0};
int check[101][101] = {0};
int dx[] = {0, -1, 0, 1};
int dy[] = {-1, 0, 1, 0};

int total;
int m, n, k;
vector<int> answer;
void    bfs(int x, int y){
    int ctr = 1;
    queue<pair<int, int>> q;
    q.push(make_pair(x, y));
    check[x][y] = 1;
    board[x][y] = total;
    while (!q.empty()){
        pair<int, int> temp = q.front();
        q.pop();
        for(int i = 0; i < 4; i++){
            int nx = temp.first + dx[i];
            int ny = temp.second + dy[i];
            if (nx >=0 && nx < n && ny >= 0 && ny < m){
                if (board[nx][ny] == 0 && check[nx][ny] == 0){
                    board[nx][ny] = total;
                    check[nx][ny]++;
                    ctr++;
                    q.push(make_pair(nx, ny));
                }
            }
        }
    }
    answer.push_back(ctr);
}

int main(){
    cin >> m >> n >> k;
    total = 0;
    pair<int, int> temp1;
    pair<int, int> temp2;
    for (int i = 0; i < k; i++){
         cin >> temp1.first >> temp1.second >> temp2.first >> temp2.second;
        for (int x = temp1.first; x < temp2.first; x++){
            for (int y = temp1.second; y < temp2.second; y++){
                board[x][y] = -1;   //block 처리
            }
        }
    }
    
    //bfs
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if (board[i][j] == 0 && check[i][j] == 0){
                total++;
                bfs(i, j);
            }
        }
    }
    /*
    //print
    cout << "\n";
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cout << board[i][j] << " ";
        }
        cout << "\n";
    }
    */
    
    sort(answer.begin(), answer.end());
    cout << total << "\n";
    for(int i = 0; i < answer.size(); i++){
        cout << answer[i] << " ";
    }
    return (0);
}