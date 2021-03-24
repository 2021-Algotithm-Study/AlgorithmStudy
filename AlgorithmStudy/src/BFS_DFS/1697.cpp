//1697 ¼û¹Ù²ÀÁú
#include <iostream>
#include <queue>

using namespace std;

int cost[100001];
int visit[100001];
int n, k; 

int main(void){
    cin >> n >> k;

    int temp;
    visit[n] = 1;
    cost[n] = 0;

    queue<int> q;
    q.push(n);

    while (!q.empty()){
        temp = q.front(); 
        q.pop();
        if (temp == k){
            break;
            
        }
        int t1 = temp - 1;
        int t2 = temp + 1;
        int t3 = temp * 2;
        if (t1 >= 0 && visit[t1] == 0){
            visit[t1] = 1;
            cost[t1] = cost[temp] + 1;
            q.push(t1);
        }
        if (t2 <= 100001 && !visit[t2]){
            visit[t2] = 1;
            cost[t2] = cost[temp] + 1;
            q.push(t2);
        }
        if (t3 <= 100001 && visit[t3] == 0){
            visit[t3] = 1;
            cost[t3] = cost[temp] + 1;
            q.push(t3);
        }
    }
    cout << cost[k] << endl;
    return (0);
}