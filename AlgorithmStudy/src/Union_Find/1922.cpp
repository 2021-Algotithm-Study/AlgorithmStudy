//1922 ��Ʈ��ũ ���� (Gold 4)
#include <iostream>

using namespace std;

int parent[1001];
int cost[1001];
int n, m;



int main(){
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        parent[i] = i;
        cost[i] = 1;
    }
    for(int i = 0; i < m; i++){
        int temp1, temp2, temp_cost;
        cin >> temp1 >> temp2 >> temp_cost;
        //������ �׳� �н��Ѵ�
        if (temp1 != temp2){
            
        }
    }
    return (0);
}