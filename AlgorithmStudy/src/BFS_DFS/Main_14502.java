
//14502 연구소(Gold 5)
import java.io.*;
import java.util.*;

public class Main_14502 {
    static int[][] origin;
    static int[][] walled;
    static int N, M, max;
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { -1, 0, 1, 0 };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        origin = new int[N][M];
        walled = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /* do */
        // 벽을 세개씩 세워주면서 나간다
        max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (origin[i][j] == 0) {
                    mapCopy(origin, walled);
                    walled[i][j] = 1;
                    wall(1);
                    walled[i][j] = 0;
                }
            }
        }
        System.out.println(max);
        br.close();
    }

    static void bfs() {
        int[][] check = new int[N][M];
        mapCopy(walled, check); // 벽 세개세운
        Deque<int[]> q = new ArrayDeque<>();
        // check 기준으로
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (walled[i][j] == 2)
                    q.offer(new int[] { i, j });

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if ((nx >= 0 && nx < N && ny >= 0 && ny < M) && check[nx][ny] == 0) {
                    check[nx][ny] = 2;
                    q.offer(new int[] { nx, ny });
                }
            }
        }

        int ctr = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (check[i][j] == 0)
                    ctr++;
        if (max < ctr)
            max = ctr;

    }

    static void wall(int ctr) {
        if (ctr == 3) {
            bfs();
            return;
        }
        // 벽 두 개 더 세우고, 바이러스 퍼트리고, 안전구역 갯수 세기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (walled[i][j] == 0) {
                    walled[i][j] = 1;
                    wall(ctr + 1);
                    walled[i][j] = 0;
                }
            }
        }
    }

    static void mapCopy(int[][] origin, int[][] copy) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = origin[i][j];
            }
        }
    }
}
