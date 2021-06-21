//1074 Z(Silver 1)
#include <iostream>
#include <math.h>
using namespace std;
int N, r, c;
int ctr =0;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> N >> r >> c;
    int x = (int)pow(2, N-1);
    int y = x;

    while (N-- > 0) {
        int add = (int)pow(4, N);  //사분면에 들어있는 요소들 개수
        int temp = (int)pow(2, N-1);
 
        if (c < x && r < y) {
            x -= temp;
            y -= temp;
        } else if (x <= c && r < y) {
            x += temp;
            y -= temp;
            ctr += add;
        } else if ( c < x && y <= r) {
            x -= temp;
            y += temp;
            ctr += add * 2;
        } else {
            x += temp;
            y += temp;
            ctr += add * 3;
        }
    }

    //최대값 32768*32768
    cout << ctr;
    return 0;
}