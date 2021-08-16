//10974 모든 순열(Silver 3)
package Permutation;

import java.io.*;
public class java_10974 {
    static int a[];
    static int N;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        a = new int[N];
        for(int i = 0; i < N; i++)
            a[i] = i+1;
        do{
            for(int i = 0; i < N; i++) sb.append(a[i] + " ");
            sb.append("\n");
        }while(np(a));
        System.out.print(sb);
        br.close();
    }

    static boolean np(int[] a){
        int i = N-1;
        while(i > 0 && a[i-1] >= a[i]) i--;
        if(i == 0)  return false;
        
        int j = N-1;
        while(j > 0 && a[i-1] >= a[j]) j--;
        swap(a, i-1, j);

        int k = N-1;
        while(i < k)    swap(a, i++, k--);
        return true;
    }

    static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
