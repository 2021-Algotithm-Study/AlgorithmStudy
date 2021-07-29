//2580 ½ºµµÄí (Gold 4)
#include <iostream>

using namespace std;
int board[9][9];
int main(){
    ios_base::sync_with_stdio;
    cin.tie(NULL); cout.tie(NULL);

    for(int i = 0; i < 9; i++)
        for(int j = 0; j < 9; j++)
            cin >> board[i][j];

    return 0;
}