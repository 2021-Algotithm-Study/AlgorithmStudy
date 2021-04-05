//15654 N�� M(5) (Silver 3)
#include <iostream>
#include <algorithm>

using namespace std;
int N, M;
int n[10];
int arr[10];
bool visit[10];

void getComb(int ctr){
    if (ctr == M){
        for(int i = 0; i < M; i++)
            cout << arr[i] << " ";
        cout << "\n";
        return;
    }
    for(int i = 0; i < N; i++)
    {
        //visit[n[i]]�� ������ �� �Ǵ� ����
        //n[i]�� 123121 �̷� ���ڰ� ��� ���� ���� ����
        if (!visit[i]){
            visit[i] = true;
            arr[ctr] = n[i];
            getComb(ctr + 1);
            visit[i] = false;
        }
    }
}

int main(){
    cin >> N >> M;
    for(int i = 0; i < N; i++)
        cin >> n[i];
    sort(n, n + N);

    getComb(0);
}