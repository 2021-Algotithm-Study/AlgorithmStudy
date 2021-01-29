/* Gold 3, 과제 */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<pair<int, int>>	chore;
vector<int> schedule;

//sort by high score
bool sort_helper(pair<int, int> p1, pair<int, int> p2) {
	return (p1.second > p2.second);
}

int main() {
	int maxscore = 0;
	int lastday = 0;
	int N; cin >> N;
	chore.resize(N);
	for (int i = 0; i < N; i++) {
		cin >> chore[i].first >> chore[i].second;
		lastday = max(chore[i].first, lastday);
	}

	schedule.resize(lastday + 1);
	fill(schedule.begin(), schedule.end(), 0);	// nitialize schedule
	sort(chore.begin(), chore.end(), sort_helper);	//sort chore list

	for (int i = 0; i < chore.size(); i++) {
		//고득점순으로 정렬된 choer 탐색 
		//schedule을 확인-> 마감날짜가 비어 있는지 확인, 점점 앞으로 빼면서 계속 확인

		for (int j = chore[i].first; j > 0; j--) {
			if (schedule[j] == 0) {
				schedule[j] = chore[i].second;
				maxscore += schedule[j];
				break;
			}
		}
	}

	cout << maxscore << endl;
	return 0;
}