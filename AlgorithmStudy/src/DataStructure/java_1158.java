//1158 요세푸스 문제(Silver 5)
import java.io.*;
import java.util.*;

public class java_1158{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        sb.append("<");
        boolean[] b = new boolean[N+1];
        int idx= K;
        for(int i = 1; i <= N; i++){
            int cycle = 0;
            sb.append(idx + ", ");
            b[idx] = true;
            if(i == N)  break;
            while(cycle != K){
                if(++idx == (N+1))  idx = 1;
                if(b[idx])  continue;
                else cycle++;
            }
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append(">");
        System.out.println(sb);
        br.close();
    }
}