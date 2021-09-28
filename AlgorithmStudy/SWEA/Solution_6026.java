
//SWEA 6026 성수의 비밀번호 공격(D4)
import java.io.*;
import java.util.*;

public class Solution_6026 {
    static int N, M;
    static int MOD = 1_000_000_007;
    static long fac[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        /* fac[]미리 구해놓기 */
        fac = new long[101];
        fac[0] = fac[1] = 1;
        for (int i = 2; i < fac.length; i++)
            fac[i] = fac[i - 1] * i % MOD; // 어차피 나머지만 찾을 거니까

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            /* do */
            long total = 0;
            for (int i = 0; i <= M; i++) {
                long l1 = i % 2 == 0 ? 1 : -1;
                long l2 = nCr(i);
                long l3 = pow(M - i, N);
                long result = ((l1 * l2) % MOD * l3) % MOD;
                total = (total + result + MOD) % MOD; // result가 음수일까봐 MOD함 더 더해줌
                // total = (total + (((i % 2 == 0 ? 1 : -1) * nCr(i)) % MOD * pow(M - i, N)) %
                // MOD + MOD) % MOD;
            }
            sb.append("#" + t + " " + total + "\n");
        }
        System.out.print(sb);
        br.close();
    }

    // (n!*((n-r)!*r!)^(mod-2) ) % MOD
    static long nCr(int r) {
        if (r == 0)
            return 1;
        long l1 = fac[M];
        long l2 = pow(fac[M - r], MOD - 2);
        long l3 = pow(fac[r], MOD - 2);
        return ((l1 * l2) % MOD * l3) % MOD;
    }

    // 교수님이 BigInteger주셨는데 일단은 그냥 MOD로 나눠봄
    static long pow(long a, int b) {
        if (b == 1)
            return a;
        long half = pow(a, b / 2);
        if (b % 2 == 0)
            return (half * half) % MOD;
        else
            return ((half * half) % MOD * a % MOD) % MOD;
    }

}
