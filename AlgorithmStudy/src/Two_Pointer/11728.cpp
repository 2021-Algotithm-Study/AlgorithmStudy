//11728 배열 합치기 (Sliver 5)
#include <iostream>
#include <vector>

using namespace std;

int n, m;
int main(){
    
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    //input, init
    cin >> n >> m;
    vector<int> arr1(n);   
    vector<int> arr2(m);
    
    for(int i = 0; i < n; i++)
        cin >> arr1[i];
    for(int i 
    = 0; i < m; i++)
        cin >> arr2[i];
    arr1.push_back(1e9);
    arr2.push_back(1e9);
    
    int i = 0;
    int j = 0;
    while (i < n || j < m){
        if (i != 0 || j != 0)   cout << " ";
        if(arr1[i] == arr2[j])
            cout << arr1[i++] << " " << arr2[j++]; 
        else if(arr1[i] < arr2[j])
            cout << arr1[i++];
        else
            cout << arr2[j++]; 
    }
    return (0);
}