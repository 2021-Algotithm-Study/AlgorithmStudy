
//1859 백만장자 프로젝트(D2)
import java.io.*;
import java.util.*;

public class java_1859 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] price = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++)
                price[i] = Integer.parseInt(st.nextToken());
            long money = 0;
            int high = N - 1;
            for (int i = N - 1; i >= 0; i--) {
                if (price[i] < price[high]) {
                    money += price[high] - price[i];
                } else {
                    high = i;
                }
            }
            sb.append("#" + t + " " + money + "\n");
        }
        System.out.print(sb);
        br.close();
    }
}
