//14916 거스름돈(Silver 5)
package Greedy;

import java.io.*;

public class java_14916 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ctr = 0;
        while (N >= 0) {
            if (N % 5 == 0) {
                System.out.println(ctr + N / 5);
                return;
            }
            N -= 2;
            ctr++;
        }
        System.out.println(-1);
        br.close();
    }
}
