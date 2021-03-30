//14503 �κ� û�ұ�(Gold 5)
#include <iostream>
#include <queue>

using namespace std;

int n, m, cur;
int answer = 0;
pair<int, int> robot;
int board[51][51];
bool check[51][51] = {false};

int dx[] = {-1, 0, 1, 0};
int dy[] = {0, 1, 0, -1};
queue<pair<int, int>> q;


void bfs(pair<int, int> x){
    /*
    if (board[x.first][x.second]){
        cur = (cur + 1) % 4;
        bfs(make_pair(dx[cur], dy[cur]));
    }
    */
    q.push(x);
    check[x.first][x.second];

    while (!q.empty()){
        x = q.front();
        q.pop();
        //������ġ û�� �����ϸ� û��
        if (board[nx][ny] == 0 && !check[nx][ny]){
           check[nx][ny] = true;
           answer++;
        }

        //���ʺ��� Ž���ϸ鼭
        for(int i = 0; i < 4; i++){
            int nx = x.first + dx[(cur + i) % 4];
            int ny = x.second + dy[(cur + i) % 4];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m){
                //û������ ���� ������ �����Ѵٸ�
                if(board[nx][ny] == 0 && !check[nx][ny]){
                    q.push(make_pair(nx, ny));
                    check[nx][ny] = true;
                }
                //û���� ������ ���ٸ� �� ���� ����
                else if()
            }
        }
    }
}

void init_c(){
    std::ios_base::sync_with_stdio;
    cin.tie(NULL);
    cout.tie(NULL);
}

int main(){
    init_c();
    cin >> n >> m >> robot.first >> robot.second >> cur;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> board[i][j];
        }
    }
    bfs(robot);

    cout >> answer;

    return (0);
}