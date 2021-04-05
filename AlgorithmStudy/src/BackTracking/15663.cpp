//15657 N�� M(9) (Silver 2)
#include <iostream>
#include <vector>       //�ߺ������� �ʿ� �����Ƿ� vector �� �ᵵ �ƴ�
#include <algorithm>

using namespace std;
int N, M;
vector<int> n(10);
int arr[10];
bool visit[10] = {false};

void getComb(int ctr){
    if (ctr == M){
        for(int i = 0; i < M; i++)
            cout << arr[i] << " ";
        cout << "\n";
        return;
    }
    //prev�� �־ for���� ���� ���� ���� ���ڰ� ���� �ڸ��� ���� �ʵ���
    int prev = -1;
    for(int i = 0; i < n.size(); i++){
        if(!visit[i] && prev != n[i]){
            visit[i] = true;
            arr[ctr] = n[i];
            prev = n[i];
            getComb(ctr + 1);
            visit[i] = false;
        }
    }
}

int main(){
    cin >> N >> M;
    n.resize(N);
    for(int i = 0; i < N; i++)
        cin >> n[i];
    sort(n.begin(), n.end());
    //n.erase(unique(n.begin(), n.end()), n.end());
    getComb(0);
}