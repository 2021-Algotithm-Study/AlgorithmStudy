/* Silver 1, ¹Ì·ÎÅ½»ö */

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<vector<int>> map(100, vector<int>(100, 0));
vector<vector<int>> check(100, vector<int>(100, 0));
int dx[] = { 0, -1, 0, 1 };
int dy[] = { -1, 0, 1, 0 };
int n, m;

void bfs(int x, int y) {
	queue<pair<int, int>> q;
	q.push(make_pair(x, y));
	check[x][y] = 1;

	while (!q.empty()) {
		x = q.front().first;
		y = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
				if (map[nx][ny] == 1 && check[nx][ny] == 0) {
					q.push(make_pair(nx, ny));
					check[nx][ny] = check[x][y] + 1;
				}
			}
		}
	}


}

int main() {

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%1d", &map[i][j]);
		}
	}

	bfs(0, 0);
	cout << check[n - 1][m - 1];

	system("pause");
	return 0;
}