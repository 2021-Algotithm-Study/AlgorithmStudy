//18430 ������� (Silver 1)
#include <iostream>

using namespace std;

int board[6][6];
int check[6][6];
int N, M;
int max = -1;

bool is_possible(int row, int col){
    //�˻��� �ֵ� üũ ���⼭ �����Ѱ�?
    return true;
}

void boomerang(int row, int col, int ctr){
    if(row == N && col == M){
        if(max < ctr)   ctr = max;
        return;
    }

    //�θ޶��� �ϳ��� ���ɵ� ���� �ִµ� ���� ���� �ְ� ������ ħ
    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            if(is_possible(i, j)){
                //�θ޶� ���� �� �� �������� ǥ���ؼ� ���

            }
            //���⼭ üũ �ٽ� Ǯ�� ��

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