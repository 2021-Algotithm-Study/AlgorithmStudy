/*2018 KAKAO BLIND RECRUITMENT 뉴스 클러스터링*/

#include <iostream>
#include <vector>
#include <ctype.h>
#include <map>
#include <string>

using namespace std;

int solution(string str1, string str2) {
	int answer = 0;

	multimap<string, int> map1;
	multimap<string, int> map2;

	vector<string> and_set;
	vector<string> or_set;

	//전부 소문자로 바꾸기
	for (int i = 0; i < str1.length(); i++) {
		if (str1[i] >= 65 && str1[i] < 97)	str1[i] += 32;
	}
	for (int i = 0; i < str2.length(); i++) {
		if (str2[i] >= 65 && str2[i] < 97)	str2[i] += 32;
	}

	//set 구성
	for (int i = 0; i < str1.length() - 1; i++) {
		if (isalpha(str1[i]) && isalpha(str1[i + 1])) {
			map1.insert(make_pair(str1.substr(i, 2), 0));
			cout << str1.substr(i, 2) << " ";
		}
	}
	for (int i = 0; i < str2.length() - 1; i++) {
		if (isalpha(str2[i]) && isalpha(str2[i + 1])) {
			map2.insert(make_pair(str2.substr(i, 2), 0));
			cout << str2.substr(i, 2) << " ";
		}
	}
	cout << "\n" << map1.size() << " " << map2.size() << "\n";
	//공집합 처리
	if (map1.size() + map2.size() == 0)	return 65536;

	//합집합과 교집합 만들기
	multimap<string, int>::iterator it1;
	multimap<string, int>::iterator it2;

	int ctr = 0;

	for (it1 = map1.begin(); it1 != map1.end(); it1++) {
		for (it2 = map2.begin(); it2 != map2.end(); it2++) {
			if (!(it1->first).compare(it2->first) && it1->second == 0 && it2->second == 0) {
				it1->second++;
				it2->second++;
				cout << it1->first << ", " << it2->first << "\n";
				ctr++;
			}
		}
	}

	int size = map1.size() + map2.size();
	cout << ctr << " " << size << "\n";

	size = size - ctr;
	float res = (float)ctr / size;
	res = res * 65536;
	cout << res;
	//교집합 크기/합집합크기
	return (int)res;
}

int main() {
	string string1 = "aa1+aa2";
	string string2 = "AAAA12";
	cout << solution(string1, string2) << endl;
	system("pause");
	return 0;
}

