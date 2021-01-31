/* Silver 1, 횇채쨍쨋횇채 */

//일어날 수 있는 케이스 전부 염두에 두기
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<vector<int>> board(1000, vector<int>(1000, 0));
queue<pair<int, int>> q;
int n, m, answer;

int dx[] = { 0, -1, 0, 1 };
int dy[] = { -1, 0, 1, 0 };

void bfs() {
	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {	//check boundary
				if (board[nx][ny] == 0) {
					board[nx][ny] = board[x][y] + 1;
					q.push(make_pair(nx, ny));						
				}
			}
		}
	}

}

int main() {
	cin >> m >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> board[i][j];		//if ripe -> push to queue
			if (board[i][j] == 1)	q.push(make_pair(i, j));
		}
	}

	bfs();

	//board
	int answer = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (board[i][j] == 0) {
				cout << "-1";
				return 0;
			}
			else {
				if (answer < board[i][j])	answer = board[i][j];
			}
		}
	}
	cout << answer - 1;
	return 0;
}
