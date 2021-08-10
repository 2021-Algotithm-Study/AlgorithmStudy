//SWEA 사칙연산 유효성 검사(D3)

import java.util.*;
import java.io.*;

public class java_1233 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String dump;
        for(int t = 1; t <= 10; t++){
            boolean flag = true;
            int N = Integer.parseInt(br.readLine());
            for(int n = 0; n < N; n++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int ctr = st.countTokens();
                dump = (st.nextToken());
                String node = st.nextToken(); 
                //node가 연산자라면
                if(node.equals("+") || node.equals("-") || node.equals("*") || node.equals("/")){
                    if(ctr != 4)    flag = false;
                }else{
                    if(ctr != 2)    flag = false;
                }
            }
            sb.append("#" + t + " ");
            if(flag)    sb.append(1 + "\n");
            else        sb.append(0 + "\n");
        }
        System.out.print(sb);
        br.close();
    }
}
