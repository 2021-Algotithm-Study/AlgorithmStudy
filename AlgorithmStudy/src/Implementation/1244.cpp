//1244 스위치 켜고 끄기 (Silver 4)

#include <iostream>

using namespace std;

int light[104];
int N; 

void print_light(){
    for(int i = 1; i <= N; i++){
        if(light[i])    cout << "1";
        else            cout << "0";
        if(i%20 != 0)   cout << " ";
        else            cout << "\n";
    }
}


int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);

    cin >> N;
    for(int i = 1; i <= N; i++){
        cin >> light[i];
    }

    int M; cin >> M;
    while (M--){
        int type, num; cin >> type >> num;
        if(type == 1){
            for(int i=num;i<=N;i+=num) light[i] ^= 1;
        }else {
            int pivot = 0;
            while (1 <= num-pivot-1 && num + pivot + 1<= N && light[num-pivot-1] == light[num+pivot+1])
                pivot++;
            for(int i = num-pivot; i <= num+ pivot; i++){
                light[i] ^= 1;
            }
        }
    }
    print_light();
  
}