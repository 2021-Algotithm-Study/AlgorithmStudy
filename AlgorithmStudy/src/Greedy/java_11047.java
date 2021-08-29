//11047 동전0(Silver 2)
package Greedy;

import java.io.*;
import java.util.*;

public class java_11047 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coin = new int[N];
        for (int i = 0; i < N; i++) {
            coin[N - 1 - i] = Integer.parseInt(br.readLine());
        }
        int ctr = 0;
        int i = 0;
        while (K > 0) {
            if (coin[i] <= K) {
                ctr += (K / coin[i]);
                K = K % coin[i];
            }
            i++;
        }
        System.out.println(ctr);
        br.close();
    }
}
