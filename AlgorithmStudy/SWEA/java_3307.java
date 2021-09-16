import java.io.*;
import java.util.*;

public class java_3307 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] dp = new int[N][2];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                dp[i][0] = Integer.parseInt(st.nextToken());
            }
            int max = 0;
            for (int i = 0; i < N; i++) {
                dp[i][1] = 1;
                for (int j = 0; j < i; j++) {
                    if (dp[j][0] < dp[i][0] && dp[i][1] < dp[j][1] + 1) {
                        dp[i][1] = dp[j][1] + 1;
                    }
                }
                if (max < dp[i][1])
                    max = dp[i][1];
            }
            sb.append("#" + t + " " + max + "\n");

        }
        System.out.print(sb);
        br.close();
    }
}