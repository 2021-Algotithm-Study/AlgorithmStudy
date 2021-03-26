//1976 여행가자 (Gold 5)
#include <iostream>

using namespace std;
int n, m;
int map[201][201];
int plan[201];
int parent[201];

int find_group(int x){
    if (parent[x] == x)
        return (x);
    return (parent[x] = find_group(parent[x]));
}

void union_map(int x, int y){
    x = find_group(x);
    y = find_group(y);
    parent[x] = y;
}

int main(void){

    //initialize && do
    cin >> n >> m;
    for(int i = 1; i <= n; i++)
        parent[i] = i;
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= n; j++){
            cin >> map[i][j];
            if (map[i][j] == 1){
                union_map(i, j);
            }
        }
    }

    cin >> plan[0];
    int flag = find_group(plan[0]);
    for(int i = 1; i < m; i++){
        cin >> plan[i];
        if (find_group(plan[i]) != flag){
            cout << "NO";
            return (0);
        }
    }
    cout << "YES";
    return (0);
}