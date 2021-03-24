//2593엘리베이터 (Platinum 5)
//메모리랑 시간 너무 쓰는데
//

#include <iostream>
#include <queue>
#include <vector>

using namespace std;
int n, m, A, B;
vector<int> entire_map[101], elevator[100001];
queue<int> q;
int cnt[101], parent[101];
int last;
 
int bfs()
{
    int result = -1;
    for (int i = 0; i < elevator[A].size(); i++) {
        for (int j = 0; j < elevator[B].size(); j++) {
            if (elevator[A][i] == elevator[B][j]){
                last = elevator[A][i];
                return result = 1;
            }
        }
        cnt[elevator[A][i]] = 1;
        q.push(elevator[A][i]);
    }
 
    while (!q.empty()) {
        int temp = q.front();
        q.pop();
 
        for (int i = 0; i < entire_map[temp].size(); i++) {
            int through = entire_map[temp][i];
            if (through == B) {
                last = temp;
                return result = cnt[temp];
            }
            else {
                for (int j = 0; j < elevator[through].size(); j++) {
                    if (cnt[elevator[through][j]] == 0) {    
                        cnt[elevator[through][j]] = cnt[temp] + 1;
                        parent[elevator[through][j]] = temp;
                        q.push(elevator[through][j]);
                    }
                }
            }
        }
    }
    return result;
}
 
void print(int num)
{
    if (num == 0)    return;
    print(parent[num]);
    cout << num << "\n";
}
 
int main()
{
    int x, y, ans;
 
    cin >> n >> m;
 
    for (int i = 1; i <= m; i++) {
        cin >> x >> y;
        while (x <= n) {
            entire_map[i].push_back(x);
            elevator[x].push_back(i);
            x += y;
        }
    }
    cin >> A >> B;
     
    ans = bfs();
    if (ans == -1)
        cout << "-1\n";
    else {
        cout << ans << "\n";
        print(last);
    }
 
    return 0;
}
