//13305 주유소(Silver 4)
//long으로 안 쓰면 서브태스크3 에서 걸려서 58점만 나온다
package Greedy;

import java.io.*;
import java.util.*;

public class java_13305 {
    static long[] oil, road;
    static int N;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        road = new long[N - 1];
        oil = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N - 1; i++)
            road[i] = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            oil[i] = Long.parseLong(st.nextToken());

        long res = oil[0] * road[0];
        long min = oil[0];
        int i = 1;
        while (i < N - 1) {
            if (oil[i] < min) {
                min = oil[i];
            }
            res += min * road[i++];
            // 자기보다 작아지는 기름값이 나오기 전까지는 계속 얘로 간다
        }
        System.out.print(res);
        br.close();
    }
}
