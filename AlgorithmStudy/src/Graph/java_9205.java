package Graph;

import java.io.*;
import java.util.*;

//9205 맥주 마시면서 걸어가기(Silver 1)
public class java_9205 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] dist = new int[N + 2][N + 2];
            boolean[][] d = new boolean[N + 2][N + 2];
            int[][] point = new int[N + 2][2];
            for (int i = 0; i <= N + 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                point[i][0] = Integer.parseInt(st.nextToken());
                point[i][1] = Integer.parseInt(st.nextToken());

            }

            /* do */
            for (int i = 0; i <= N + 1; i++)
                for (int j = 0; j <= N + 1; j++) {
                    int[] p1 = point[i], p2 = point[j];
                    dist[i][j] = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);

                    if (dist[i][j] <= 50 * 20)
                        d[i][j] = true;
                }

            for (int k = 0; k <= N + 1; k++)
                for (int i = 0; i <= N + 1; i++)
                    for (int j = 0; j <= N + 1; j++)
                        if (d[i][k] & d[k][j])
                            d[i][j] = true;

            sb.append(d[0][N + 1] ? "happy\n" : "sad\n");
        }

        br.close();
        System.out.print(sb);

    }
}
