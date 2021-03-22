//2667 ??????? ?????

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

char map[101][101] = {0};
int check[101][101] = {0};
int n;
int dx[] = {-1, 0, 1, 0};
int dy[] = {0, -1, 0, 1};

int total;
vector<int> building;

int	dfs(int x, int y) {
	check[x][y] = 1;
	int answer = 0;
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
			if (map[nx][ny] == '1' && check[nx][ny] == 0) {
				check[nx][ny] = 1;
				map[nx][ny] = total + '0';
				answer++;
				answer += dfs(nx, ny);
			}
		}
	}
	return (answer);
	//building.push_back(answer);
}

int	main(void) {

	total = 0;

	cin >> n;
	for (int i = 0; i < n; i++)
			cin >> map[i];

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (check[i][j] == 0 && map[i][j] == '1') {
				total++;
				building.push_back(dfs(i, j) + 1);
			}
		}
	}
	sort(building.begin(), building.end());

	cout << total;
	for (int i = 0; i < building.size(); i++)
		cout << "\n" << building[i];

	return (0);
}
