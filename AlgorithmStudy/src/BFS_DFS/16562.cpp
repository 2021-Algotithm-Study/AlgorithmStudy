//16562 친구비
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int parent[100001] = {0};
int cost[10001] = {0};
int n, m, money;

//최상위 parent만큼
int findParent(int x){
    if (parent[x] == x){
        return x;
    }
    return parent[x] = findParent(parent[x]);
}

void unionParent(int x, int y){
    x = findParent(x);
    y = findParent(y);
    if (cost[x] < cost[y])
        parent[y] = x;
    else 
        parent[x] = y;
}

int main(){
    cin >> n >> m >> money;
    for(int i = 1; i <= n; i++)
        parent[i] = i;
    for(int i =1; i <= n; i++)
        cin >> cost[i];
    int temp1, temp2;
    for(int i = 0; i <m; i++){
        cin >> temp1 >> temp2;
        unionParent(temp1, temp2);
    }
   
    int total = 0;
    for(int i = 1; i <= n; i++){
        int temp = findParent(i);
        if (temp){
            //한 번 더해준 최상위 parent는 0과 union해서 0으로 만들어버림
            //temp 0으로 잡히므로 다음에도 안 더해짐
            total += cost[temp];
            unionParent(0, temp);
        }
    }
    if (money >= total)
        cout << total;
    else
        cout << "Oh no";
    return (0);
}