//1931 회의실배정(Silver 2)
package Greedy;

import java.io.*;
import java.util.*;

public class java_1931 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Long[][] room = new Long[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            room[i][0] = Long.parseLong(st.nextToken());
            room[i][1] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(room, (o1, o2) -> Long.compare(o1[0], o2[0]));
        // 요점적인 sort를 뒤에다 둬서 최종 결과가 될 수 있게 한다
        Arrays.sort(room, (o1, o2) -> Long.compare(o1[1], o2[1]));
        int ctr = 1;
        long end = room[0][1];
        for (int i = 1; i < N; i++) {
            // 맞추긴 했는데 여기 왜 이해안가
            if (room[i][0] >= end) {
                end = room[i][1];
                ctr++;
            }
        }
        System.out.println(ctr);
        br.close();
    }
}
