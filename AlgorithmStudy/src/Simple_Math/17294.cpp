/* Bronze 1, 귀여운 수~ε٩(๑> ₃ <)۶з */

#include <iostream>
#include <string>

using namespace std;

int main() {
	string s;
	cin >> s;

	if (s.size() == 1) {
		cout << "?(?????)?..°♡ 뀌요미!!"; return 0;
	}

	int d = s[1] - s[0];

	for (int i = 2; i<s.size(); i++) {
		if (s[i] - s[i - 1] != d) {
			cout << "흥칫뿡!! <(￣ ? ￣)>"; return 0;
		}
	}
	cout << "?(?????)?..°♡ 뀌요미!!";
}