import java.io.*;
import java.util.*;

//9205 맥주 마시면서 걸어가기(Silver 1)
public class java_9205 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[][] board;
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] src = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
            int[][] conv = new int[N + 1][2];
            boolean[] visit = new boolean[N + 1];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                conv[i][0] = Integer.parseInt(st.nextToken());
                conv[i][1] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            conv[N] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

            /* do */
            // 만일 락페장에서 출발했을 경우
            if (conv[N][0] == src[0] && conv[N][1] == src[1]) {
                sb.append("happy\n");
                break;
            }

            boolean isPossible = false;
            Deque<int[]> q = new ArrayDeque<>();
            q.offer(src); // 시작위치 넣어놓고 시작
            loop: while (!q.isEmpty()) {
                int[] cur = q.poll();
                // 도착하면 break
                for (int i = 0; i <= N; i++) {
                    if (cur[0] == conv[N][0] && cur[1] == conv[N][1]) {
                        isPossible = true;
                        break loop;
                    }
                    if (!visit[i] && Math.abs(cur[0] - conv[i][0]) + Math.abs(cur[1] - conv[i][1]) <= 1000) {
                        q.offer(conv[i]);
                        visit[i] = true;
                    }
                }
            }

            if (isPossible)
                sb.append("happy\n");
            else
                sb.append("sad\n");
        }
        System.out.println(sb);
        br.close();
    }
}
