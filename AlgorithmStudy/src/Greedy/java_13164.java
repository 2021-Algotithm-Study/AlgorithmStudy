//13164 행복 유치원(Gold 5)
package Greedy;

import java.io.*;
import java.util.*;

public class java_13164 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] child = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            child[i] = Integer.parseInt(st.nextToken());
        int[] diff = new int[N - 1];
        for (int i = 1; i < N; i++) {
            diff[i - 1] = child[i] - child[i - 1];
        }
        Arrays.sort(diff);
        // 1 2 3 4 5 6 106을 2개로 나눈다고 함
        // diff가 //1 1 1 1 1 100이렇게 나왔으면
        // N-K-1: 7-2-1 = 4
        int sum = 0;
        for (int i = 0; i < N - K; i++) {
            sum += diff[i];
        }
        System.out.println(sum);
        br.close();
    }
}
