
//SWEA 8458 원점으로 돌아감 
import java.io.*;
import java.util.*;

public class Solution_8458 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] len = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            len[0] = Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken()));
            int max = len[0];
            boolean isNotPossible = false;
            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                len[i] = Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken()));
                max = Math.max(max, len[i]);
                if (len[i] % 2 != len[i - 1] % 2)
                    isNotPossible = true;
            }
            if (isNotPossible)
                sb.append("#" + t + " -1\n");
            else if (max == 0)
                sb.append("#" + t + " 0\n");
            else {
                int sum = 0;
                int cnt = 0;
                while (!(sum >= max && (max - sum) % 2 == 0))
                    sum += ++cnt;
                sb.append("#" + t + " " + cnt + "\n");
            }
        }
        System.out.print(sb);
    }
}
// gcd lcd 계산하다 터짐
// //ctr 하나씩 올려가면서 -> 가장 큰 것만 검사하면 된다
// //이걸 전부 계산해야 하나? 안 터지나?
// 최대값부터 역으로도 들어가면?
// n(n+1)/2해도 대략 answer가 10의 5제곱 조금 못 미침: 10만
// 전부 미리 구해놓으면?
// 근데 10만이라 냅다 돌려도 터지지는 않을듯
// %2로 Even 검사
// 958개 맞은 거면 뭐가 틀린거임..?