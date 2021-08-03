//1244 스위치 켜고 끄기 (Silver 4)
import java.io.*;
import java.util.*;

public class java_1244 {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/* Initialize */
		int n = Integer.parseInt(br.readLine());
		int[] light = new int[n + 1];
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		for (int i = 1; i <= n; i++)
			light[i] = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());

		/* do */
		while (t-- > 0) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			int type = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (type == 1) {
				for (int i = num; i <= n; i += num)
					light[i] ^= 1;
			} else {
				int p = 0;
				light[num] ^= 1;
				while ((num - p - 1 > 0) && (num + p + 1 <= n) && (light[num - p - 1] == light[num + p + 1])) {
					light[num - p - 1] ^= 1;
					light[num + p + 1] ^= 1;
					p++;
				}
			}
		}
		
		/*print*/
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(light[i]).append(" ");
			if (i % 20 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);

	}
}
