
//17472 다리 만들기 2(Gold 2) kruskal
import java.io.*;
import java.util.*;

public class Main_17472 {
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int island_ctr, result;
    static PriorityQueue<int[]> pq;
    static int[] parents;
    static int bridge_ctr = 0;

    public static void main(String[] args) throws Exception {
        /* input & initialize */
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        /* do */
        // 섬 갯수세기
        island_ctr = 0;
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    island_ctr++;
                    bfs(i, j);
                }
            }
        }
        // 섬 사이의 거리 계산하기
        pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (map[i][j] != 0)
                    getDist(i, j);

        // MST 계산
        // kruskal
        parents = new int[island_ctr + 1];
        for (int i = 0; i < parents.length; i++)
            parents[i] = i;
        result = 0;
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int a = find(tmp[0]);
            int b = find(tmp[1]);
            if (a == b)
                continue;
            result += tmp[2];
            union(tmp[0], tmp[1]);
            bridge_ctr++;
        }
        // print
        System.out.print((result == 0 || bridge_ctr != island_ctr - 1) ? -1 : result);
    }

    static void bfs(int a, int b) {
        Deque<int[]> q = new ArrayDeque<int[]>();
        visited[a][b] = true;
        map[a][b] = island_ctr;
        q.add(new int[] { a, b });

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 1 && !visited[nx][ny]) {
                    q.add(new int[] { nx, ny });
                    map[nx][ny] = island_ctr;
                    visited[nx][ny] = true;
                }
            }

        }
    }

    public static void getDist(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            while (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (map[nx][ny] == map[x][y])
                    break;
                if (map[nx][ny] != 0) {
                    if (Math.abs(nx - x) + Math.abs(ny - y) - 1 >= 2)
                        pq.offer(new int[] { map[x][y], map[nx][ny], Math.abs(nx - x) + Math.abs(ny - y) - 1 });
                    break;
                }
                nx = nx + dx[i];
                ny = ny + dy[i];
            }
        }
    }

    public static int find(int a) {
        if (a == parents[a])
            return a;
        return parents[a] = find(parents[a]);
    }

    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot != bRoot) {
            parents[aRoot] = b;
        } else {
            return;
        }
    }
}
