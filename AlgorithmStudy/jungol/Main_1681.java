
//정올 1681 해밀턴 순환 회로
import java.io.*;
import java.util.*;

public class Main_1681 {
    static int N; // 1<= N <= 12
    static int[][] cost;
    static int min;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                cost[i][j] = Integer.parseInt(st.nextToken());
        }

        // 0부터 시작해서 0까지 돌아온다
        // 전부 연결한 다음 마지막 친구부터 다시 연결
        min = Integer.MAX_VALUE;
        visit[0] = true;
        dfs(0, 1, 0);

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);

        br.close();
    }

    static void dfs(int cur, int ctr, int sum) { // now sel cost
        if (ctr == N) {
            if (cost[cur][0] == 0)
                return;
            sum += cost[cur][0]; // 누적계에 회사로 돌아가는 비용 정해주고
            if (sum < min)
                min = sum;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visit[i] && cost[cur][i] != 0) { // 갈 수 있는 길이 있고 아직 방문하지 않았으면
                visit[i] = true;
                if (sum + cost[cur][i] < min)
                    dfs(i, ctr + 1, sum + cost[cur][i]);
                visit[i] = false;
            }
        }

    }

}
