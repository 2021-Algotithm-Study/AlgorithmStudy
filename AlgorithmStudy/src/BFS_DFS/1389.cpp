//1389 케빈 베이컨의 6단계 법칙
#include <iostream>
#include <queue>

using namespace std;

int person[101][101] = {0};
bool check[101][101] = {false};
int dx[] = {0, -1, 0, 1};
int dy[] = {-1, 0, 1, 0};

int n, m;


void print_module(int n, int m){
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= m; j++){
            cout << person[i][j] << " ";
        }
        cout << "\n";
    }
}

void bfs(int x, int y){
    queue<pair<int, int>> q;
    q.push(make_pair(x, y));
    check[x][y] = true;
    while (!q.empty()){
        pair<int, int> temp = q.front();
        q.pop();
        for(int i = 1; i <= n; i++){
            if(person[temp.second][i] > 0 && !check[temp.first][i] && person[temp.first][i] == 0){
                person[temp.first][i] = person[temp.second][i] + 1;
                person[i][temp.first] = person[temp.second][i] + 1;
                check[temp.first][i] = true;
                check[i][temp.first] = true;
                print_module(n, n);
                cout << "\n";
                q.push(make_pair(temp.first, i));                 
            }
        }
    }
}


int main(void){
    cin >> n >> m;
    for(int i = 0; i < m; i++){
        int temp1; int temp2;
        cin >> temp1 >> temp2;
        person[temp1][temp2] = 1;
        person[temp2][temp1] = 1;
    }

    print_module(n, n);
    cout << "\n";

    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= n; j++){
            if (person[i][j] == 1 && !check[i][j])
                bfs(i, j);
        }
    }

    int min_kevin = 1000001;
    int answer = 0;
    for(int i = 1; i <= n; i++){
        int kevin = 0;
        for(int j = 1; j <= n; j++){
            if(j != i)
                kevin += person[i][j];
            else
                person[i][j] = 0;
        }
        if(kevin != 0)
            if (kevin < min_kevin){
                min_kevin = kevin;
                answer = i;
            }
    }

    print_module(n, n);

    cout << answer;

    return (0);
}