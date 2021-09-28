import java.io.*;
import java.util.*;

//16236 아기상어 (Gold 4)
public class Main_16236 {
    static int N;
    static int[][] board;

    static int dx[] = { 0, -1, 0, 1 };
    static int dy[] = { -1, 0, 1, 0 };
    static int ctr, T;

    public static void main(String[] args) throws Exception {
        int[] baby = new int[3];
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9)
                    baby = new int[] { i, j, 2 };
            }
        }

        /* do */
        ctr = 0;
        T = 0;
        while (true) {
            // 먹을 수 있는 물고기 전부 넣어놓기
            boolean[][] check = new boolean[N][N];
            Deque<int[]> q = new ArrayDeque<>();
            ArrayList<int[]> fish = new ArrayList<>();
            q.offer(new int[] { baby[0], baby[1], 0 });
            check[baby[0]][baby[1]] = true;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                // System.out.println(cur[0] + " " + cur[1]);
                for (int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    // 아직 안 가본 곳이면
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && !check[nx][ny]) {

                        // 나보다 몸집 크면 못 지나감
                        if (board[nx][ny] > baby[2])
                            continue;
                        // 나보다 몸집 작으면
                        if (board[nx][ny] > 0 && board[nx][ny] < baby[2]) {
                            // 일단 fish에 넣어둠
                            if (fish.isEmpty() || fish.get(0)[2] >= cur[2] + 1) {

                                fish.add(new int[] { nx, ny, cur[2] + 1 });
                                // System.out.println(T + " [find]" + nx + " " + ny + " " + (cur[2] + 1));
                            }
                        }
                        q.offer(new int[] { nx, ny, cur[2] + 1 });
                        // System.out.println(nx + " " + ny);
                        check[nx][ny] = true;
                    }
                }
            }
            if (fish.size() == 0)
                break;

            // 거리순, 왼쪽 순으로 정렬하고
            Collections.sort(fish, (o1, o2) -> Integer.compare(o1[1], o2[1]));
            Collections.sort(fish, (o1, o2) -> Integer.compare(o1[0], o2[0]));
            int[] eat = fish.get(0);
            board[baby[0]][baby[1]] = 0;
            baby[0] = eat[0];
            baby[1] = eat[1];
            board[baby[0]][baby[1]] = 9;

            // 움직여서 먹은 다음에 시간이랑 몸집 계산
            T += eat[2];
            if (++ctr >= baby[2]) {
                ctr = 0;
                baby[2]++;
            }
            // if (T < 20) {
            // for (int i = 0; i < fish.size(); i++) {
            // System.out.println(fish.get(i)[0] + " " + fish.get(i)[1] + " " +
            // fish.get(i)[2]);
            // }
            // }
            // System.out.println(T + " [eat]" + baby[0] + " " + baby[1]);
            // System.out.println(ctr + " / " + baby[2]);
            // print();

        }
        System.out.println(T);

    }

    static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
