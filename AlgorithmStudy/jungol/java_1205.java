//jungol 1205 조커

import java.io.*;
import java.util.*;

public class java_1205 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] card = new int[N];
        int joker = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
            if (card[i] == 0)
                joker++;
        }
        if (joker == N) {
            System.out.println(N);
            return;
        }
        // sort
        Arrays.sort(card);

        int max = 1 + joker;

        for (int i = joker; i < N; i++) {
            int wild = joker;
            int ctr = 1;
            for (int j = i + 1; j < N; j++) {
                if (card[j - 1] == card[j]) {
                    continue;
                }
                if (card[j] - card[j - 1] <= wild + 1) {
                    wild = wild - (card[j] - card[j - 1] - 1);
                    ctr += (card[j] - card[j - 1]);
                } else {

                    break;
                }
            }
            ctr += wild;
            if (ctr > max)
                max = ctr;
            // System.out.println(card[i] + ": " + ctr);
        }
        System.out.println(max);
        br.close();
    }
}
