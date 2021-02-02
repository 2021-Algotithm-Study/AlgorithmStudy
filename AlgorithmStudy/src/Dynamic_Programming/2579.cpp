/* Silver 3, 계단 오르기 */
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int dp[301];
int score[301];

int main() {
	int n; cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> score[i];
	}
	
	dp[1] = score[1];
	if(n>=2) dp[2] = score[1] + score[2];
	if(n>=3) dp[3] = max(score[1] + score[3], score[2]+score[3]);

	if (n > 3) {
		for (int i = 4; i <= n; i++) {
			dp[i] = max(dp[i - 3] + score[i - 1] + score[i], dp[i - 2] + score[i]);
		}
	}

	cout << dp[n];

	system("pause");
	return 0;
}