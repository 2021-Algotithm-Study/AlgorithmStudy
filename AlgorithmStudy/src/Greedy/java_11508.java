//11508 2+1 세일(Silver 4)
package Greedy;

import java.io.*;
import java.util.*;

public class java_11508 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] dairy = new Integer[N];
        for (int i = 0; i < N; i++)
            dairy[i] = Integer.parseInt(br.readLine());

        Arrays.sort(dairy, Collections.reverseOrder());
        long ctr = 0;
        for (int i = 0; i < N; i++) {
            if (i % 3 == 2)
                continue;
            ctr += dairy[i];
            // System.out.println(dairy[i]);
        }
        System.out.println(ctr);
        br.close();
    }
}
