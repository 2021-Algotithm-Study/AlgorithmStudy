//4195 模备 匙飘况农 (Gold 2)

#include <iostream>
#include <map>
#include <algorithm>

using namespace std;

int f, n;
int group[200001], g_size[200001];

int find_group(int x){
    if(group[x] == x)
        return x;
    return (group[x] = find_group(group[x]));
}

void union_group(int x, int y){
    if (g_size[x] < g_size[y]){
        swap(x, y);
    }
    group[y] = x;
    g_size[x] += g_size[y];
    g_size[y] = 0;

}

int main(){
    cin >> f;
    while (f--){
        cin >> n;
        for(int i = 0; i <= 2*n; i++){
            group[i] = i;
            g_size[i] = 1;
        }
        map<string, int> people;
        int id = 0;
        for(int i = 0; i < n; i++){
            string temp1, temp2;
            cin >> temp1 >> temp2;
            if (!people.count(temp1))
                people[temp1] = id++;
            if (!people.count(temp2))
                people[temp2] = id++;
            int t1_g = find_group(people[temp1]);
            int t2_g = find_group(people[temp2]);
            if (t1_g != t2_g)
                union_group(t1_g, t2_g);
            cout << max(g_size[t1_g], g_size[t2_g]) << "\n";
        }
    }
    return (0);
}