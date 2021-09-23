//1786 찾기 (Platinum 5)

package String;

import java.io.*;

public class Main_1786 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] text = br.readLine().toCharArray();
        char[] pattern = br.readLine().toCharArray();

        int tLength = text.length, pLength = pattern.length;
        int[] pi = new int[pLength];
        for (int i = 1, j = 0; i < pLength; i++) {
            while (j > 0 && pattern[i] != pattern[j]) {
                j = pi[j - 1];
            }
            if (pattern[i] == pattern[j])
                pi[i] = ++j;
        }

        int cnt = 0;
        for (int i = 0, j = 0; i < tLength; ++i) {
            while (j > 0 && text[i] != pattern[j])
                j = pi[j - 1];
            if (text[i] == pattern[j]) {
                if (j == pLength - 1) {
                    cnt++;
                    sb.append((i + 2) - pLength + " ");
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }

        sb.insert(0, cnt + "\n");
        System.out.println(sb);
    }
}
