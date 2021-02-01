/* Gold 4, 내리막 길 */
#include<iostream>
#include<memory.h>

using namespace std;

int n, m;
int map[501][501];
int dp[501][501];
int dx[4] = { 1, 0, -1, 0 }, dy[4] = { 0, 1, 0, -1 };

int dfs(int row, int col)
{
	if (dp[row][col] != -1) return dp[row][col]; 
	if ( row >= n || row < 0 || col >= m || col < 0 ) return 0;
	if (row == 0 && col == 0) return 1; 

	dp[row][col] = 0;

	for (int i = 0; i < 4; i++) { 
		int nx = row + dx[i]; 
		int ny = col + dy[i];
		if (map[nx][ny] > map[row][col])
			dp[row][col] += dfs(nx, ny);
	}
	return dp[row][col];
}

int main()
{
	cin >> n >> m;
	memset(dp, -1, sizeof(dp));

	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			cin >> map[i][j];

	cout << dfs(n - 1, m - 1);

	return 0;
}


