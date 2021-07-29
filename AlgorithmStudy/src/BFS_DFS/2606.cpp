//2606 ДЎБо (Silver 3)
#include <iostream>
#include <queue>

using namespace std;

int n, m;
int network[101][101] = {0};
bool check[101] = {false};

int main(){
    cin >> n >> m;    
    for(int i = 0;i < m; i++){
        int temp1, temp2;
        cin >> temp1 >> temp2;
        network[temp1][temp2] = 1;
        network[temp2][temp1] = 1;
    }
    
    int total = 0;
    queue<int> q;
    q.push(1);
    check[1] = true;
    while (!q.empty()){
        int x = q.front();
        q.pop();
        for(int i = 1; i <= n; i++){
            if(network[x][i] && !check[i]){
                check[i] = true;
                total++;
                q.push(i);
            }
        }
    }    
    
    cout << total;
    return 0;
}