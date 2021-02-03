/*Silver 3, ¼ö¸®°ø Ç×½Â*/

#include <iostream>
using namespace std;

#define MAX 1001

int leak[MAX] = { 0, };
int N, L;

int solution() {
	int ctr = 0;
	//stick (L-1) from most left leak, move right
	for (int i = 0; i < MAX; i++) {
		if (leak[i] == 1) {						//if leak[i] leak,
			ctr++;								//new tape
												//cout << "!";
												//cout << i << " " << L << endl;
			for (int j = i; j < (i + L); j++) {	// stick tape for L-1
				leak[j] = 0;
			}
		}
	}
	return ctr;
}

int main() {
	cin >> N >> L;	// cover L-1

	while (N--) {
		int temp; cin >> temp;
		leak[temp] = 1;
	}

	cout << solution();

	//system("pause");
	return 0;
}