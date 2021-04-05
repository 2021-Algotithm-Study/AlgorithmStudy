//1182 부분수열의 합 (Silver 2)
#include <iostream>

using namespace std;
int N, S;
int n[21];

int dfs(int i, int sum){
    int ctr = 0;
    if (i == N)   return 0;
    if (sum + n[i] == S)    ctr++;

    ctr += dfs(i + 1, sum);
    ctr += dfs(i + 1, sum + n[i]);
    
    return ctr;
}

int main(){
    //input
    cin >> N >> S;
    for(int i = 0; i < N; i++)
        cin >> n[i];
    
    //count
    cout << dfs(0, 0);
    return (0);
}