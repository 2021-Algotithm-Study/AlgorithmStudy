//11399 ATM(Silver 3)
package Greedy;

import java.io.*;
import java.util.*;

public class java_11399 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Long[] arr = new Long[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            arr[i] = Long.parseLong(st.nextToken());

        Arrays.sort(arr);
        long sum = 0;
        long accum = 0;
        for (int i = 0; i < N; i++) {
            accum += arr[i];
            sum += accum;
        }
        System.out.println(sum);
        br.close();
    }
}
