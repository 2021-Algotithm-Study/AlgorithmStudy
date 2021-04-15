//11053 가장 긴 증가하는 부분 수열 (Silver 2)
#include <iostream>

using namespace std; 

int arr[1001];
int dp[1001] = {1, };
int n;

int main() { 
    std::ios::sync_with_stdio(false); 
    //input
    cin >> n; 
    for (int i = 0; i < n; i++)
        cin >> arr[i]; 
    
    int answer = 1; 
    for (int i = 0; i < n; ++i) { 
        int cur = arr[i]; 
        for (int j = 0; j < i; ++j) {
            if (cur > arr[j]) { 
                dp[i] = max(dp[i], dp[j] + 1); 
                
            } 
        } 
        answer = max(answer, dp[i]); 
    } 
    cout << sol << "\n"; 
    return 0; 
    
}

/*
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
*/