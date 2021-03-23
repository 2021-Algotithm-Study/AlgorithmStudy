#include <iostream>

using namespace std;

int n;
int map[101][101];
int clone_map[101][101];
bool check[101][101];

int dx[] = {0, -1, 0, 1};
int dy[] = {-1, 0, 1, 0};

//틀렸었는데 얘 초기화값 0에서 1로 고쳐주니까 바로 맞음
//아무도 잠기지 않을 경우 1이므로 MAX의 최솟값은 1임
int max_safe = 1;

void dfs(int x, int y, int safe){
    check[x][y] = 0;
    for(int i = 0; i < 4; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx >= 0 && nx < n && ny >= 0 && ny < n){
            if (clone_map[nx][ny] == 0 && !check[nx][ny]){
                check[nx][ny] = true;
                clone_map[nx][ny] = safe;
                dfs(nx, ny, safe);
            }
        }
    }
}

int main(){
    int rain = 0;
    cin >> n;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> map[i][j];
            rain = rain < map[i][j] ? map[i][j] : rain;
        }
    }
    while (--rain){
        //강우량 만큼 들이부었을 때!
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                check[i][j] = 0;
                if(map[i][j] > rain){
                    clone_map[i][j] = 0;
                }else
                    clone_map[i][j] = 1;
            }
        }
        int safe = 0;
        //영역 개수 구하고
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if (clone_map[i][j] == 0){
                    safe++;
                    dfs(i, j, safe);
                }
            }
        }
        max_safe = max_safe < safe ? safe : max_safe;
    }
    cout << max_safe;
    return (0);
}