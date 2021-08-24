//SWEA 7465 창용 마을 무리의 개수(D4)
import java.io.*;
import java.util.*;

public class java_7465 {
    static int N, M;
    static int[] p;
    static boolean[] visit;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int ctr = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            p = new int[N+1];
            visit = new boolean[N+1];
            for(int i = 1; i <= N; i++ )    p[i] = i;
            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine(), " ");
                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            for(int i = 1; i <= N; i++)
                if(p[i] == i)   ctr++;
            
            sb.append("#" + t + " " + ctr + "\n");        
        }
        System.out.print(sb);
        br.close();
    }

    static void union(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if(a > b)   p[a] = b;
        else        p[b] = a;
    }

    static int findParent(int a){
        if(p[a] == a)   return a;
        else            return findParent(p[a]);
    }
}
