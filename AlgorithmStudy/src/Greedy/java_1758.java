//1758 알바생 강호(Silver 4)
package Greedy;

import java.io.*;
import java.util.*;

public class java_1758 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] customer = new Integer[N];
        for (int i = 0; i < N; i++) {
            customer[i] = Integer.parseInt(br.readLine());

        }
        Arrays.sort(customer, Collections.reverseOrder());
        // N, 팁이 모두 최대 10만이므로 합은 long으로 선언해야 한다
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (customer[i] - i <= 0)
                break;
            sum += customer[i] - i;
        }
        System.out.println(sum);
        br.close();
    }
}
