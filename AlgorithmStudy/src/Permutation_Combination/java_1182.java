//1182 부분수열의 합(Silver 2)
package Permutation_Combination;

import java.util.*;
import java.io.*;
public class java_1182 {
    static int N;
    static int S;
    static int[] a;
    static int ctr = 0;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        a = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++)  a[i] = Integer.parseInt(st.nextToken());
        knapsack(0, 0);
        if(S == 0)  ctr--; 
        System.out.println(ctr);
        br.close();
    }

    static void knapsack(int idx, int sum){
        if(idx==N){
            if(sum == S) ctr++;
            return;
        }
        knapsack(idx+1, sum+a[idx]);
        knapsack(idx+1, sum);
    }


}
