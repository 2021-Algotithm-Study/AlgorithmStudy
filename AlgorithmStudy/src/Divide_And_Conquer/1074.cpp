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
        int add = (int)pow(4, N);  //��и鿡 ����ִ� ��ҵ� ����
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

    //�ִ밪 32768*32768
    cout << ctr;
    return 0;
}