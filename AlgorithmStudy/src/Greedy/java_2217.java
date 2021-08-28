//2217 로프(Silver 2)
package Greedy;

import java.io.*;
import java.util.*;

public class java_2217 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] rope = new int[N];
        for (int i = 0; i < N; i++)
            rope[i] = Integer.parseInt(br.readLine());
        // 어 그냥 곱하면 되는 거 아닌가
        // 오 똑똑한생각함
        Arrays.sort(rope);
        int max = 0;
        for (int i = 0; i < N; i++) {
            int temp = rope[i] * (N - i);
            max = temp > max ? temp : max;
        }
        System.out.println(max);

        br.close();
    }
}
