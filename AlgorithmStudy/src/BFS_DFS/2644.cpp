//2644 촌수 계산
#include <iostream>
#include <queue>

using namespace std;

int family[102][102] = {0};
int check[102] = {0};
int depth[102] = {0};

int n, m;
int x, y;

void bfs(int v){
    queue<int> q;
    check[v] = 1;
    q.push(v);
    while (!q.empty()){
        v = q.front();
        q.pop();
        for(int i = 1; i <= n; i++){
            if (family[v][i] == 1 && !check[i]){
                check[i] = 1;
                depth[i] = depth[v] + 1;
                q.push(i);
            }
        }
    }
    
}

int main(void){
    cin >> n >> x >> y >> m;
    
    int temp1;
    int temp2;
    for(int i = 0; i< m; i++){
        cin >> temp1 >> temp2;
        family[temp1][temp2] = 1;
        family[temp2][temp1] = 1;
    }
    
    bfs(x);
    if (depth[y] != 0)
        cout << depth[y] << endl;
    else
        cout << "-1" << endl; 
    return (0);
}