//SWEA 3234 준환이의 양팔저울(D4)
import java.io.*;
import java.util.*;

public class java_3234 {
	static int N,result, total;
    static int[] weight;
    static int[] order;
	static boolean[] pick;
	
	public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        int T= Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			weight = new int[N];
			order = new int[N];
			pick = new boolean[N];
			total=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
                weight[i]=Integer.parseInt(st.nextToken());
				total += weight[i];
			}

            result = 0;
			calc(0, 0, 0, total);
			sb.append("#" + t + " " + result + "\n");
		}
        System.out.print(sb);
	}
    static void calc(int pos,int sum_R, int sum_L, int remainder) {
        //가짓수 계산
        if(sum_R+remainder <= sum_L) {
            int cnt=1;
            for(int i=1;i<=N-pos;i++)   cnt = cnt * (2 * i);
            result+=cnt;
            return;
        }
        
        //순열로 계속 돌면서 
        for(int i = 0; i < N; i++) {
            if(!pick[i]) {
                pick[i] = true;
                if(sum_R + weight[i] <= sum_L)  calc(pos+1, sum_R+weight[i], sum_L, remainder-weight[i]);
                calc(pos+1, sum_R, sum_L+weight[i], remainder-weight[i]);
                pick[i] = false;
            }
        }
    }
}
