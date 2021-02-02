/* Gold 5, ÇÕºÐÇØ */

#include <iostream>

using namespace std;

int dp[201][201] = {0, };

int main() {
	int n, k; cin >> n >> k;
	//initialize
	for (int i = 1; i < 201; i++) {
		dp[1][i] = i;
		dp[i][1] = 1;
	}

	if (n > 1 && k > 1) {
		for (int i = 2; i <= n; i++) {
			for (int j = 2; j <= k; j++) {
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1])%1000000000;
			}
		}
	}

	cout << dp[n][k];
	
	//system("pause");
	return 0;
}