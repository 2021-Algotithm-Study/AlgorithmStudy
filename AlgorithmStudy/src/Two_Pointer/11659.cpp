//11659 구간 합 구하기4 (Silver 3)
#include <iostream>

using namespace std;

int main(){
    
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n, m; cin >> n >> m;
    int arr[100001];
    int sum[100001];
    for(int i = 1; i <= n; i++){
        cin >> arr[i];
        sum[i] = sum[i-1] + arr[i];
    }
    for(int i = 0; i < m; i++){
        int s, e; cin >> s >> e;
        cout << sum[e] - sum[s-1] << "\n";
    }    
    return (0);
}