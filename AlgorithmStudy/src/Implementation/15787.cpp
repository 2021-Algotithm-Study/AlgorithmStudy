#include <iostream>
#include <vector>
using namespace std;

int n, m, cnt;
bool visit[1<<21];
vector<int> v;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> n >> m;

	v.resize(n + 1);
	for (int i = 0; i < m; i++) {
		int q, w, e;
		cin >> q;
		if (q == 1) {
			cin >> w >> e;
			v[w] = v[w] | (1 << e);
		}
		else if (q == 2) {
			cin >> w >> e;
			v[w] = v[w] &~ (1 << e);
		}
		else if (q == 3) {
			cin >> w;
			v[w] = v[w] << 1;

			v[w] = v[w] &((1 << 21)-1);
		}
		else {
			cin >> w;
			v[w] = v[w] >> 1;
			v[w] = v[w] & ~1;
		}
	}
	for (int i = 1; i <= n; i++) {
		if (!visit[v[i]]) {
			cnt++;
		}
		visit[v[i]] = true;
	}
	cout << cnt << '\n';
	return 0;
}