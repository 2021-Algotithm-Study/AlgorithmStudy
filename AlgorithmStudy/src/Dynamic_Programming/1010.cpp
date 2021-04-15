//1010 다리 놓기 (Silver 5)
#include <iostream>

using namespace std;

int dp[31][31] = {0, };
int T, M, N;
int main(){
    cin >> T;
    for(int i = 1; i <= 30; i++)  dp[1][i] = i;
        for(int i = 2; i <= 30; i++){
            for(int j = i; j <= 30; j++){
                for(int k = j-1; k >= i - 1; k--){
                    dp[i][j] += dp[i-1][k];
                }
            }
        }        
    while (T--){
        cin >> N >> M;
        
        cout << dp[N][M] << "\n";
        
    }
}