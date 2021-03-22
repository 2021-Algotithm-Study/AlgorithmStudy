#include <iostream>
#include <queue>

using namespace std;

int board[1001][1001];
int check[1001] = {0, };
int m, n, v;

//check = 0 이면 방문한 것
void dfs(int v) {
	cout << v << ' ';
	check[v] = 1;            
	for (int i = 1; i <= n; i++) {
		if (check[i] == 1 || board[v][i] == 0)
			continue;
		dfs(i);              
	}
}

//check = 1 이면 방문한 것
void bfs(int v) {
	queue<int> q;
	q.push(v);
	check[v] = 0;
	while (!q.empty()) {
		v = q.front();
		cout << q.front() << " ";
		q.pop();
		for (int i = 1; i <= n; i++) {
			if (check[i] == 0 || board[v][i] == 0)
				continue;
			q.push(i);
			check[i] = 0;
		}
	}
}

int main() {
	int x, y;
	cin >> n >> m >> v;
	for (int i = 0; i < m; i++) {
		cin >> x >> y;
		board[x][y] = 1;
		board[y][x] = 1;
	}

	dfs(v);
	cout << "\n";
	bfs(v);
	return (0);
}