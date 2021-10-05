
//15961 회전초밥 (Gold 4)
//2531 회전초밥 (Silver 1)
import java.io.*;
import java.util.*;

public class Main_15961 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, D, K, C;
        int[] belt;
        int[] isAte;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        belt = new int[N]; // 여기에 초밥 이름 하나씩 들어감
        for (int i = 0; i < N; i++)
            belt[i] = Integer.parseInt(br.readLine());
        isAte = new int[D + 1];
        int total = 0, max = 0;
        for (int i = 0; i < K; i++) {
            if (isAte[belt[i]] == 0)
                total++;
            isAte[belt[i]]++;
        }
        max = total;
        for (int i = 1; i < N; i++) {
            if (max <= total) {
                if (isAte[C] == 0)
                    max = total + 1;
                else
                    max = total;
            }
            isAte[belt[i - 1]]--;
            if (isAte[belt[i - 1]] == 0)
                total--;
            if (isAte[belt[(i + K - 1) % N]] == 0)
                total++;
            isAte[belt[(i + K - 1) % N]]++;
        }
        System.out.println(max);
        /*
         * // 모든 가짓수를 뽑는다 int max = 0; next: for (int i = 0; i < N; i++) { // 어떤 초밥부터
         * 시작할지-> 여기서부터 K개 isAte = new boolean[D + 1]; // 1부터 시작함 for (int j = 0; j < K;
         * j++) { // j개 먹음 if (belt[(i + j) % N] == belt[(i + j + 1) % N]) continue
         * next; isAte[belt[(i + j) % N]] = true;
         * 
         * } isAte[C] = true; int ctr = 0; for (int j = 1; j <= D; j++) { if (isAte[j])
         * ctr++; } if (ctr > max) max = ctr; } System.out.println(max);
         */
        br.close();
    }
}
