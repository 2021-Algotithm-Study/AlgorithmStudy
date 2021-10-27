
//1868 파핑파핑 지뢰찾기(D4)
import java.io.*;
import java.util.*;

public class Solution_1868 {
    static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };
    static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static char board[][];
    static boolean[][] visit;
    static int N;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            board = new char[N][N];
            visit = new boolean[N][N];
            for (int i = 0; i < N; i++)
                board[i] = br.readLine().toCharArray();

            /* do */
            int result = 0;
            for (int i = 0; i < N; i++) {
                nextloop: for (int j = 0; j < N; j++) {
                    if (board[i][j] == '.' && !visit[i][j]) {
                        for (int d = 0; d < 8; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                if (board[nx][ny] == '*') {
                                    continue nextloop;
                                }
                            }
                        }

                        bfs(i, j);
                        result++;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == '.' && !visit[i][j])
                        result++;
                }
            }
            System.out.print("#" + t + " " + result + "\n");
        }
        // System.out.print(sb);
        br.close();
    }

    static void bfs(int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { x, y });
        visit[x][y] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int ctr = 0;
            if (!(cur[0] == x && cur[1] == y)) {

                // 8방 탐색하면서 지뢰가 있으면 있는 개수만 cur에 적어서 visit처리
                for (int i = 0; i < 8; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (board[nx][ny] == '*') {
                            ctr++;
                            break;
                        }
                    }
                }
            }
            // 주변에 지뢰 없으면
            if (ctr == 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        q.offer(new int[] { nx, ny });
                    }
                }
            }
            visit[cur[0]][cur[1]] = true; // 그리고 값은 지뢰값
        }

    }

}
