
//SWEA 1263 [S/W 문제해결 응용] 8일차 - 사람 네트워크2 D6
import java.io.*;
import java.util.*;

class swea_1263 {
    static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] == 0 && i != j)
                        arr[i][j] = INF;
                }
            }

            for (int k = 0; k < n; k++)
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < n; j++)
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);

            int min = INF;

            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 0; j < n; j++)
                    sum += arr[i][j];
                min = Math.min(sum, min);
            }
            sb.append("#" + t + " " + min + "\n");
        }
        System.out.println(sb);
    }
}