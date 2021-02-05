/*2018 KAKAO BLIND RECRUITMENT �߼�Ʈ����*/

#include <iostream>
#include <vector>
#include <string>

using namespace std;

int solution(vector<string> lines) {
	int answer = 0;
	vector<int> start_time;
	vector<int> end_time;

	vector<double> process_time;
	//���۽ð��� ����ð� vector ä�� for��
	for (int i = 0; i < lines.size(); i++) {
		string temp = lines[i].substr(11, 12);	//����ð� 
		end_time.push_back(
			stoi(temp.substr(0, 2)) * 3600000 + stoi(temp.substr(3, 2)) * 60000 +
			stoi(temp.substr(6, 2)) * 1000 + stoi(temp.substr(9, 3))
		);

		temp = lines[i].substr(23);
		temp = temp.substr(0, temp.length() - 1);	//s�����ϰ� ���ڸ� �����

		start_time.push_back(end_time[i] - (stof(temp) * 1000) + 1);
	}



	//i���۽ð�-999<= j���۽ð�(or ����ð�) <=i���۽ð�
	//j���۽ð� <= i���۽ð�-999~i���۽ð� <= j����ð�
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