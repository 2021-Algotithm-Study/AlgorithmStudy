/* Silver 3, 2*N ≈∏¿œ∏µ2 */

#include <iostream>
#include <vector>

using namespace std;

int dp[1001] = {0, };

int main() {

	int n; cin >> n;
	dp[1] = 1; dp[2] = 3;

	if (n > 2) {
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + (dp[i - 2] * 2))%10007;
			//cout << i << ": " << dp[i] << "\n";
		}
	}
	cout << dp[n];

	//system("pause");
	return 0;
}