//SWEA 1289 원재의 메모리 복구하기
import java.io.*;

public class java_1289 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            char[] s = br.readLine().toCharArray();
            char pivot = '0';
            int ctr = 0;
            for (int i = 0; i < s.length; i++) {
                if(pivot != s[i]) {
                    ctr++;
                    pivot = s[i];
                }
            }
            sb.append("#").append(t).append(" ").append(ctr).append("\n");
        }
        System.out.print(sb);
    }
}
