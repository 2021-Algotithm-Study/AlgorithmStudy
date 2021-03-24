//7562 나이트의 이동
#include <iostream>
#include <queue>

using namespace std;

int n;
int l;
int board[301][301];
bool check[301][301];
int dx[] = {-2, -1, 1, 2, 2, 1, -1, -2};
int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};
pair<int, int> knight;
pair<int, int> dest;

void bfs(){
    queue<pair<int, int>>   q;
    q.push(knight);
    check[knight.first][knight.second] = 1;
    while (!q.empty()){
        pair<int, int> temp = q.front();
        if(temp.first == dest.first && temp.second == dest.second){
            break;
        }
        q.pop();
        for(int i = 0; i < 8; i++){
            int nx = temp.first + dx[i];
            int ny = temp.second + dy[i];
                   // cout << nx << ", " << ny << "\n";
            if (nx >= 0 && nx < l && ny >= 0 && ny < l){
                //cout << "!";
                if (board[nx][ny] == 0 && !check[nx][ny]){
                    board[nx][ny] = board[temp.first][temp.second] + 1;
                    check[nx][ny] = true;
                    q.push(make_pair(nx, ny));
                }
            }
        }
    }
}

int main(void){
    cin >> n;
    while (n--){
        cin >> l;
        cin >> knight.first >> knight.second >> dest.first >> dest.second;
        for(int i = 0; i < l; i ++){
            for(int j = 0; j < l; j++){
                board[i][j] = 0;
                check[i][j] = false;
            }
        }
        bfs();
        cout << board[dest.first][dest.second] << endl;
    }
    return (0);
}