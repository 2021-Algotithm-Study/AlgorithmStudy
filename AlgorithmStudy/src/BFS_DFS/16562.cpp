#include <iostream>

using namespace std;

int leader[100001] = {0};
int cost[10001] = {0};
int n, m, money;

int find_leader(int x){
    if (leader[x] == x)
        return x;
    return (find_leader(leader[x]));
}

//������ x y�� ģ������� ���� �����Ƿ� ���� leader cost�� ���ؼ� �׷��� ����պ���Ų��
void union_leader(int x, int y){
    x = find_leader(x);
    y= find_leader(y);
    if (cost[x] > cost[y])
        leader[x] = y;
    else
        leader[y] = x;
}

int main(void){
    cin >> n >> m >> money;
    //��� ����� ���� leader�� �ڱ� �ڽ�
    for(int i = 1; i <= n; i++)
        leader[i] = i;
    for(int i =1; i <= n; i++)
        cin >> cost[i];
    for(int i = 0; i < m; i++){
        int temp1, temp2;
        cin >> temp1 >> temp2;
        union_leader(temp1, temp2);
    }

    int total = 0;
    for(int i = 1; i <=n ; i++){
        int temp_leader = find_leader(i);
        if (temp_leader != 0){
            total += cost[temp_leader];
            union_leader(0, temp_leader);
        }    
    }
    if (money >= total)
        cout << total;
    else
        cout << "Oh no";
    return (0);
}