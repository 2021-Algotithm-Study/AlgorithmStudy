//1717 집합의 표현 (Gold 4)
#include <iostream>

using namespace std;

int n, m;

int group[1000001];

int find_group(int x){
    if(x == group[x])
        return x;
    return (group[x] = find_group(group[x]));
}

void union_group(int x, int y){
    x = find_group(x);
    y = find_group(y);
    group[y] = x;
}

int main(void){
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL);
    cin >> n >> m;
    for(int i = 0; i <= n; i++)
        group[i] = i;
    int cmd, temp1, temp2;
    for(int i = 0; i < m; i++){
        cin >> cmd >> temp1 >> temp2;
        if (cmd){
            cout << ((find_group(temp1) == find_group(temp2)) ? "YES\n" : "NO\n");
        }
        else{
            union_group(temp1, temp2);
        }
    }
    return (0);
}