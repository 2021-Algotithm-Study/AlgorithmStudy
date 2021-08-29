//16953 A → B(Silver 1)
package Greedy;

import java.io.*;
import java.util.*;

public class java_16953 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int ctr = 1; // 최종적으로 1을 더해주느니 초기값 1로 설정
        // 주어진 연산은 *2와 *10+1
        // 역으로 가자-> B부터 생각해서 1로 끝나고 2번 연산 가능하면 2번역연산,
        // 근데 1이 아닌 홀수로 끝난다면 걍 불가능
        // 아니면 1번역연산
        while (A < B) {
            if (B % 10 == 1) {
                if ((B - 1) / 10 < A)
                    break;
                B = (B - 1) / 10;
                ctr++;
            } else if (B % 2 == 1) {
                break;
            } else {
                B /= 2;
                ctr++;
            }
        }
        if (A != B)
            ctr = -1;
        System.out.println(ctr);

        br.close();
    }
}
