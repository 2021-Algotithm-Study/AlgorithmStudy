//20291 파일 정리
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    
    vector<string> files;
    int N; cin >> N;
    for(int i = 0; i < N; i++){
        string temp; cin >> temp;
        files.push_back(temp.substr(temp.find(".") + 1));
      //  cout << files[i] << " ";
    }
    //cout << "\n";
    sort(files.begin(), files.end());
    for(auto i : files){
    //    cout << i << " ";
    }
    //cout << "\n";
    int first = 0;
    while (first < N){
        int last = first+1;
        int ctr = 1;
        while (last < N && files[first] == files[last]) {
            last++;
            ctr++;
        }
        cout << files[first] << " " << last-first << "\n";
        first = last;
    }
    return 0;
}