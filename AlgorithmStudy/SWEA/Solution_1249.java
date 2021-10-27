
//1249. [S/W 문제해결 응용] 4일차 - 보급로(D4)
import java.io.*;
import java.util.*;

public class Solution_1249 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] board = new int[N][N];
            int[][] dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                String temp = br.readLine();
                for (int j = 0; j < N; j++) {
                    board[i][j] = temp.charAt(j) - '0';
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
            /* do */
            // 0, 0에서 N-1, N-1까지
            int[] dx = { 0, -1, 0, 1 };
            int[] dy = { -1, 0, 1, 0 };
            dist[0][0] = 0;
            Deque<int[]> q = new ArrayDeque<>();
            q.offer(new int[] { 0, 0 });
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (dist[nx][ny] > dist[cur[0]][cur[1]] + board[nx][ny]) {
                            dist[nx][ny] = dist[cur[0]][cur[1]] + board[nx][ny];
                            q.offer(new int[] { nx, ny });
                        }
                    }
                }
            }
            // System.out.println(dist);
            // for (int i = 0; i < N; i++) {
            // for (int j = 0; j < N; j++) {
            // System.out.print(dist[i][j] + " ");
            // }
            // System.out.println();
            // }
            sb.append("#" + t + " " + dist[N - 1][N - 1] + "\n");
        }
        System.out.println(sb);
        br.close();

    }
}
