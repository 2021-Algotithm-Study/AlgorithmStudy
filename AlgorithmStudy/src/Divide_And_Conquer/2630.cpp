//2630 색종이 만들기(Silver 3)
#include <iostream>

using namespace std;

int board[129][129];
int N;
int blue = 0; 
int white = 0;

void solution(int x, int y, int size)
{
    int pivot = board[x][y];
    for (int i = x; i < x + size; i++)
    {
        for (int j = y; j < y + size; j++)
        {
            if (pivot != board[i][j])
            {
                solution(x, y, size / 2);
                solution(x, y + size / 2, size / 2);
                solution(x + size / 2, y, size / 2);
                solution(x + size / 2, y + size / 2, size / 2);
                return;
            }
        }
    }
    if (pivot == 0)
        white++;
    else
        blue++;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> N;
    for(int i = 0; i < N; i++)
        for(int j = 0; j < N; j++)
            cin >> board[i][j];

    solution(0, 0, N);
    cout << white << "\n" << blue;
    return 0;
}