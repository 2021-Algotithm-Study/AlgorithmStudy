package Graph;

//4485 녹색 옷 입은 애가 젤다지? (Gold 4): BFS
//누적합 나타내는 dist 배열을 MAX_VALUE로 초기화시켜놓고, 현재 뻗어나간 누적합이 얘보다 작을 때만 q에 offer하는 방식
import java.io.*;
import java.util.*;

public class Main_4485 {
    static int N;
    static int[][] board, dist;
    static int dx[] = { 0, -1, 0, 1 };
    static int dy[] = { -1, 0, 1, 0 };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            board = new int[N][N];
            dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE / 2;
                }
            }

            /* do */
            Deque<int[]> q = new ArrayDeque<int[]>();
            dist[0][0] = board[0][0];
            q.offer(new int[] { 0, 0 });

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                for (int i = 0; i < 4; i++) { // 상하좌우 탐색하면서
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) { // 방문처리할 필요가 없음 어차피 아래서 찡김
                        if (dist[cur[0]][cur[1]] + board[nx][ny] < dist[nx][ny]) {
                            dist[nx][ny] = dist[cur[0]][cur[1]] + board[nx][ny];
                            q.offer(new int[] { nx, ny });
                        }
                    }
                }
            }
            sb.append("Problem " + t++ + ": " + dist[N - 1][N - 1] + "\n");
        }
        System.out.print(sb);

        br.close();
    }
}
