//10415 순열 사이클 (Silver 1)
#include <iostream>
#include <queue>

using namespace std;
int board[2][1001];
bool check[1001] = {false};
int t;

//사이클이 만들어지면 return
void bfs(int x){
    if(board[0][x] == board[1][x])
        return;
    queue<int> q;
    q.push(x);
    check[x] = true;
    while (!q.empty()){
        x = q.front();
        q.pop();
        int nx = board[1][x];
        if (!check[nx]){
            q.push(nx);
            check[nx] = true;
        }
    }
    return;
}

int main(){
    cin >> t;
    while(t--){
        //input
        int n; cin >> n;
        for(int i = 1; i <= n; i++){
            check[i] = false;
            board[0][i] = i;
            cin >> board[1][i];
        }
        //do
        int ctr = 0;
        for(int i = 1; i <= n; i++){
            if (!check[i]){
                bfs(i);
                ctr++;
            }
        }
        //output
        cout << ctr << "\n";
    }
    return (0);
}