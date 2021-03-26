//10775 °øÇ× (Gold 2)
#include <iostream>

using namespace std;

int parent[100001];
int g, p;

int find_gate(int x){
    if (x == parent[x])
        return x;
    return (parent[x] = find_gate(parent[x])); 
}

void union_gate(int x, int y){
    x = find_gate(x);
    y = find_gate(y);
    parent[x] = y;
}

int main(){

    int answer = 0;

    cin >> g >> p;
    for(int i = 0; i <= g; i++)
        parent[i] = i;
    for(int i = 0; i < p; i++){
        int gi, g_empty;
        cin >> gi;
        g_empty = find_gate(gi);
        if (!g_empty)
            break;
        else{
            answer++;
            union_gate(g_empty, g_empty-1);
        }
    }

    //output
    cout << answer;
    return (0);
}