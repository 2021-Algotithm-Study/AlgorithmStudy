
//14503 로봇청소기 (Gold 5)
import java.util.*;
import java.io.*;

public class Main_14503 {
    static int N, M;
    static int[][] board;
    // static int[][] check;
    static boolean[][] visit;
    static int[] robot;
    static int[] dx = { -1, 0, 1, 0 }; // 북동남서
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        robot = new int[3];
        st = new StringTokenizer(br.readLine());
        robot[0] = Integer.parseInt(st.nextToken());
        robot[1] = Integer.parseInt(st.nextToken());
        robot[2] = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        // check = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {

                board[i][j] = Integer.parseInt(st.nextToken());
                // check[i][j] = board[i][j];
            }
        }

        /* do */
        int ctr = 0;
        loop: while (true) {
            // 1.현재 위치를 청소한다
            if (!visit[robot[0]][robot[1]]) {
                // check[robot[0]][robot[1]] = ctr;
                visit[robot[0]][robot[1]] = true;
                ctr++;
            }
            // 2.현재 위치에서 방향 기준으로 왼쪽부터 차례대로 인접칸 탐색
            for (int i = 1; i <= 4; i++) {
                int temp_dir = (robot[2] + 4 - i) % 4; // 방향
                // 청소하지 않은 공간
                int nx = robot[0] + dx[temp_dir];
                int ny = robot[1] + dy[temp_dir];
                if ((nx >= 0 && nx < N && ny >= 0 && ny < M) && board[nx][ny] == 0 && !visit[nx][ny]) {
                    // 빈 공간인데 아직 청소를 안 했다면
                    robot[0] = nx;
                    robot[1] = ny;
                    robot[2] = temp_dir;
                    continue loop; // 거기로 로봇 돌리고 옮겨놓기
                }
            }
            // 여기까지 왔다면 사방 전부 청소했거나 벽이라는 뜻
            // 한칸 후진가능하면 후진시키고 그거 안 되면 break loop
            int nx = robot[0] - dx[robot[2]];
            int ny = robot[1] - dy[robot[2]];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == 0) {
                robot[0] = nx;
                robot[1] = ny;
            } else {
                break loop;
            }
        }
        // for (int i = 0; i < N; i++) {
        // for (int j = 0; j < M; j++)
        // System.out.print(check[i][j] + " ");
        // System.out.println();
        // }
        System.out.println(ctr);
        br.close();
    }
}
