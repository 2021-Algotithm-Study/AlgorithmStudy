//17413 단어 뒤집기2 (Silver3)
#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);

    string str; getline(cin, str);
    string temp = "";
    string rev = "";
    int i = 0;
    while (str[i]){
        if (str[i] == ' ')  
            i++;
        else if(str[i] == '<'){
            int j = i;
            while (j < str.size() && str[j] != '>') j++;
            i = j + 1;
        }
        else{
            int j = i;
            while(i < str.size() && str[i] != ' ' && str[i] != '<') i++;
            reverse(str.begin() + j, str.begin()+i);
        }
    }

    cout << str << endl;

}