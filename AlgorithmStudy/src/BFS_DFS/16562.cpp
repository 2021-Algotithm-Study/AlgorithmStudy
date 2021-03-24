//16562 ģ����
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int parent[100001] = {0};
int cost[10001] = {0};
int n, m, money;

//�ֻ��� parent��ŭ
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
            //�� �� ������ �ֻ��� parent�� 0�� union�ؼ� 0���� ��������
            //temp 0���� �����Ƿ� �������� �� ������
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