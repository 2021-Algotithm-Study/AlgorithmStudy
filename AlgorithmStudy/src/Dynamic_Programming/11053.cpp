//11053 가장 긴 증가하는 부분 수열 (Silver 2)
#include <iostream>

using namespace std;

int dp[1001];
int arr[1001];
int N;
int main(){
    
    //input
    cin >> N;
    for(int i = 0; i < N; i++)
        cin >> arr[i];
        
    //do
    dp[N-1] = 1;
    for(int i = N-2; i >= 0; i--){
        int ctr = 1;
        int cur = arr[i];
        for(int j = i+1; j < N; j++){
            if(cur < arr[j]){
                ctr++;
                cur = arr[j];
            }
            
        }
        if(ctr > dp[i+1])   
            dp[i] = ctr;
        else    dp[i] = dp[i+1];
    }
    for(int i = 0; i < N; i++){
        cout << arr[i] << ", " << dp[i] << "\n";
    }
    cout << dp[0];
    return 0;
}