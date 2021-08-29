//20300 서강근육맨(Silver 4)
package Greedy;

import java.io.*;
import java.util.*;

public class java_20300 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Long[] arr = new Long[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        long m = 0;
        // 홀수라면 제일 큰 애를 혼자 쓰므로 일단 M으로 만들어 둠
        if (N % 2 != 0) {
            m = arr[N - 1];
            N--;
        }
        int left = 0;
        int right = N - 1;
        while (left < right) {
            long temp = arr[left] + arr[right];
            if (temp > m)
                m = temp;
            left++;
            right--;
        }
        System.out.println(m);

        br.close();
    }
}
