
//7576 토마토(Silver 1)
import java.io.*;
import java.util.*;

public class Main_7576 {
    static int N, M, day, not_riped;
    static int[][] board;
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { -1, 0, 1, 0 };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        Deque<int[]> q = new ArrayDeque<>();
        not_riped = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1)
                    q.offer(new int[] { i, j });
                else if (board[i][j] == 0)
                    not_riped++;
            }
        }

        /* do */
        if (not_riped == 0) {
            System.out.println(0);
            return;
        }
        day = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == 0) {
                    board[nx][ny] = board[x][y] + 1;
                    q.offer(new int[] { nx, ny });
                    not_riped--;
                    if (board[nx][ny] > day)
                        day = board[nx][ny];
                }
            }
        }

        // for (int i = 0; i < N; i++) {
        // System.out.println();
        // for (int j = 0; j < M; j++) {
        // System.out.print(board[i][j] + " ");
        // }
        // }

        System.out.println(not_riped != 0 ? -1 : day - 1);

        br.close();
    }
}
