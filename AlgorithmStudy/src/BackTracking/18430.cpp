//18430 무기공학 (Silver 1)
#include <iostream>

using namespace std;

int board[6][6];
int check[6][6];
int N, M;
int max = -1;

bool is_possible(int row, int col){
    //검사한 애들 체크 여기서 가능한가?
    return true;
}

void boomerang(int row, int col, int ctr){
    if(row == N && col == M){
        if(max < ctr)   ctr = max;
        return;
    }

    //부메랑을 하나씩 어케든 만들어서 넣는데 지금 오는 애가 가운데라고 침
    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            if(is_possible(i, j)){
                //부메랑 만들 떄 쓴 조각들을 표시해서 재귀

            }
            //여기서 체크 다시 풀어 줌

        }
    }
}

int main(){
    ios_base::sync_with_stdio;
    cin.tie(NULL); cout.tie(NULL);
    cin >> N >> M;
    for(int i = 0; i < N; i++)
        for(int j = 0; j < M; j++)
            cin >> board[i][j];

    boomerang(0, 0, 0);
}