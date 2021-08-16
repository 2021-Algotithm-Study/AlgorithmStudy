//1339 단어 수학(Gold 4)
package Permutation_Combination;

import java.io.*;
import java.util.*;

public class java_1339 {
    static int N;
    static String[] a;
    static ArrayList<Character> charset;
    static int c_num;
    static int max = 0;
    public static void main(String[] args) throws Exception{
        /*input & initialize*/
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        a = new String[N];
        charset = new ArrayList<>();
        for(int i = 0; i < N; i++)  {
            a[i] = br.readLine();
            for(int j = 0; j < a[i].length(); j++){
                if(isContain(a[i].charAt(j)) < 0)  charset.add(a[i].charAt(j));
            }
        }
        int t = charset.size();
        if(t < 10){
            for(int i = t; i < 10; i++) charset.add('z');
        }
        c_num = 10;
        /*match*/
        Collections.sort(charset);
        do{
            //index에 해당하는 숫자로 치환해서 단어합 계산하기
            int sum = charToIndex();
            max = sum > max ? sum : max;
        }while(np(charset));
        System.out.println(max);   
        br.close();
    }

    static int isContain(char target){
        for(int i = 0; i < charset.size(); i++){
            if(charset.get(i) == target){
                return i;
            }
        }
        return -1;
    }

    static boolean np(ArrayList<Character> c){
        int i = c_num-1;
        while(i > 0 && c.get(i-1) >= c.get(i))  i--;
        if(i == 0)  return false;

        int j = c_num-1;
        while(j > 0 && c.get(i-1) >= c.get(j))  j--;
        swap(c, i-1, j);

        int k = c_num-1;
        while(i < k)    swap(c, i++, k--);
        return true;
    }

    static void swap(ArrayList<Character> c, int i, int j){
        char temp = c.get(i);
        c.set(i, c.get(j));
        c.set(j, temp);
    }

    //a에 있는 단어들을 charset에 맞춰 숫자로 변환
    static int charToIndex(){
        int sum = 0;
        for(int i = 0; i < a.length; i++){
            String temp = a[i];
            int num = 0;
            for(int j = 0; j < temp.length(); j++){
                num*= 10;
                num+= isContain(temp.charAt(j));
            }
            sum += num;
        }
        return sum;
    }
}
