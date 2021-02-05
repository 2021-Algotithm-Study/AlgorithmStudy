/*2018 KAKAO BLIND RECRUITMENT 추석트래픽*/

#include <iostream>
#include <vector>
#include <string>

using namespace std;

int solution(vector<string> lines) {
	int answer = 0;
	vector<int> start_time;
	vector<int> end_time;

	vector<double> process_time;
	//시작시간과 종료시간 vector 채울 for문
	for (int i = 0; i < lines.size(); i++) {
		string temp = lines[i].substr(11, 12);	//종료시간 
		end_time.push_back(
			stoi(temp.substr(0, 2)) * 3600000 + stoi(temp.substr(3, 2)) * 60000 +
			stoi(temp.substr(6, 2)) * 1000 + stoi(temp.substr(9, 3))
		);

		temp = lines[i].substr(23);
		temp = temp.substr(0, temp.length() - 1);	//s제거하고 숫자만 남기기

		start_time.push_back(end_time[i] - (stof(temp) * 1000) + 1);
	}



	//i시작시간-999<= j시작시간(or 종료시간) <=i시작시간
	//j시작시간 <= i시작시간-999~i시작시간 <= j종료시간
	for (int i = 0; i < start_time.size(); i++) {
		int ctr = 0;
		for (int j = 0; j < end_time.size(); j++) {
			if (start_time[i] - 999 <= start_time[j] && start_time[j] <= start_time[i]) {
				ctr++;
			}
			else if (start_time[j] <= start_time[i] - 999 && start_time[i] - 999 <= end_time[j]) {
				ctr++;
			}
		}
		answer = ctr > answer ? ctr : answer;
	}


	return answer;
}



int main() {

	system("pause");
	return 0;
}