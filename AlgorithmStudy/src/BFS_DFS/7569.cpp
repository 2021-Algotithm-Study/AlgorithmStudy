#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int row, col, h;
int box[102][102][102];
int dz[6] = { 0,0,0 ,0,-1,1 };
int dx[6] = {0,0 ,1,-1,0,0};
int dy[6] = {-1,1,0,0,0,0 };

int check[102][102][102];
int day = 0;

struct Tomato{
    Tomato(int X, int Y, int Z) : x(X), y(Y), z(Z){}
    int x, y, z;
};

int main() {
	ios::sync_with_stdio(NULL);
	cin.tie(NULL);
	cin >> col >> row >> h;
	queue<Tomato> q;
	for (int i = 0; i < h; i++) {
		for (int j = 0; j < row; j++) {
			for(int k = 0; k < col ; k++) {
				cin >> box[i][j][k];
				if (box[i][j][k] == 1) {
					q.push(Tomato(i, j, k));
				}
				if (box[i][j][k] == 0)
					check[i][j][k] = -1;
			}
		}
	}
	while (!q.empty()) {
		Tomato temp = q.front();
		q.pop();
		for (int i = 0; i < 6; i++) {
			int nz = temp.x + dz[i];
			int nx = temp.y+ dx[i];
			int ny = temp.z + dy[i];
			if (nx >= 0 && nx < row && ny >= 0 && ny < col && nz >= 0 && nz < h){
			    if (check[nz][nx][ny] < 0){
			        check[nz][nx][ny] = check[temp.x][temp.y][temp.z] + 1;
			        q.push(Tomato(nz, nx, ny));
                }
            }

		}
	}
	for (int i = 0; i < h; i++) {
		for (int j = 0; j < row; j++) {
			for (int k = 0; k < col; k++) {
				if (check[i][j][k] == -1) {
					cout << -1;
					return 0;
				}
				day = max(day, check[i][j][k]);
			}
		}
	}
	cout << day;
}