#include <iostream>
#include <string>
#include <map>
#include <algorithm>

using namespace std;

int m;
int group_leader[200001], group_size[200001];

int find_group(int x)
{
	if (x == group_leader[x])
		return x;
	return group_leader[x] = find_group(group_leader[x]);
}

void union_group(int x, int y)
{
	if (group_size[x] < group_size[y])
		swap(x, y);

	group_leader[y] = x; 
    group_size[x] += group_size[y];
	group_size[y] = 0;
}
int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	int f;
	cin >> f;

	for (int t = 0; t < f; t++)
	{
		cin >> m;

		for (int i = 0; i <= 2*m; i++)
		{
			group_leader[i] = i;
			group_size[i] = 1;
		}
		map<string, int> people;
		int id = 1;
		
		for (int i = 0; i < m; i++)
		{
			string temp1, temp2;
			cin >> temp1 >> temp2;
			if (!people.count(temp1))
				people[temp1] = id++;
			if (!people.count(temp2))
				people[temp2] = id++;

			int temp1_group = find_group(people[temp1]);
			int temp2_group = find_group(people[temp2]);

			if (temp1_group != temp2_group)
				union_group(temp1_group, temp2_group);
			cout << max(group_size[temp1_group], group_size[temp2_group]) << "\n";
		}
	}
	return 0;
}