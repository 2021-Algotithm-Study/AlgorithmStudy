//2747 피보나치 수
#include <iostream>

using namespace std;

int dp[46] = {0, };

int main() {
	int n;
	cin >> n;
	
	dp[0] = 0;
	dp[1] = 1;
	if (n < 2){
		cout << dp[n];
		return (0);
	}
	for (int i= 2; i <= n; i++) {
		dp[i] = dp[i - 1] + dp[i - 2];
	}
	cout << dp[n];
	return (0);
}